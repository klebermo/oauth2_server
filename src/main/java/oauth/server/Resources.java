package oauth.server;

import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Order(3)
public class Resources extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
        .antMatchers("/userinfo").hasAuthority("#oauth2.hasScope('read')")
        .antMatchers("/error").permitAll()
				.anyRequest().authenticated();
  }
}
