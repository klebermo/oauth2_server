package oauth.server;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity
@Order(1)
public class Security extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

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
        .userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }
}
