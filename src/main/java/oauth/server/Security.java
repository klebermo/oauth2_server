package oauth.server;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity
@Order(1)
public class Security extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
  	public void configure(HttpSecurity http) throws Exception {
      http
        .csrf().disable()
        .authorizeRequests()
          .antMatchers("/css/**", "/img/**", "/js/**", "/**").permitAll()
          .anyRequest().authenticated()
        .and()
        .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/doLogin").permitAll()
          .usernameParameter("login")
          .passwordParameter("senha")
        .and()
        .logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from usuario where username = ?")
            .authoritiesByUsernameQuery("select t1.username, t2.authority from (select u.username as username, c.nome as credencial from usuario u, usuario_credenciais uc, credencial c where u.id = uc.usuario_id and c.id = uc.credencial_id) t1 inner join (select c.nome as credencial, a.nome as authority from credencial c, credencial_autorizacoes ca, autorizacao a where c.id = ca.credencial_id and a.id = ca.autorizacoes_id) t2 on t1.credencial = t2.credencial where t1.username =  ?")
            .passwordEncoder(new BCryptPasswordEncoder(4));
    }

    @Bean
  	public AuthenticationManager authenticationManagerBean() throws Exception {
  		return super.authenticationManagerBean();
  	}
}
