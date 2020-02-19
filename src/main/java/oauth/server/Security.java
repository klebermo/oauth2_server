package oauth.server;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity
@Order(1)
public class Security extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                .username("enduser")
                .password("password")
                .roles("USER")
                .build());
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
        .userDetailsService(userDetailsService());
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }
}
