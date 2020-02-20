package oauth.server;

import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.authentication.AuthenticationManager;
import java.security.KeyPair;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Import(AuthorizationServerEndpointsConfiguration.class)
@Configuration
@Order(2)
public class Server extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
  	private KeyPair keyPair;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
                .withClient("first-client")
                .secret(passwordEncoder().encode("noonewilleverguess"))
                .scopes("read")
                .authorizedGrantTypes("authorization_code")
                .redirectUris("http://localhost:8081/login");
    }

    @Override
  	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
  		endpoints
  			.authenticationManager(authenticationManager)
  			.accessTokenConverter(accessTokenConverter())
  			.tokenStore(tokenStore());
  	}

    @Bean
  	public TokenStore tokenStore() {
  		return new JwtTokenStore(accessTokenConverter());
  	}

  	@Bean
  	public JwtAccessTokenConverter accessTokenConverter() {
  		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
  		converter.setKeyPair(keyPair);
  		return converter;
  	}
}
