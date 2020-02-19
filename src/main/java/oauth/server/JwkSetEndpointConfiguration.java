package oauth.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Order(4)
class JwkSetEndpointConfiguration extends AuthorizationServerSecurityConfiguration {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
			.requestMatchers()
				.mvcMatchers("/.well-known/jwks.json")
				.and()
			.authorizeRequests()
				.mvcMatchers("/.well-known/jwks.json").permitAll();
	}
}
