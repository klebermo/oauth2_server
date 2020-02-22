package oauth.server;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.sql.DataSource;
import java.security.KeyPair;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.context.annotation.Bean;
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
  	private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private KeyPair keyPair;

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    @Override
  	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
      endpoints
        .tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter())
      	.authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
  	}

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
          oauthServer
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("permitAll()");
    }

    @Bean
  	public TokenStore tokenStore() {
  		return new JwtTokenStore(accessTokenConverter());
  	}

  	@Bean
  	public JwtAccessTokenConverter accessTokenConverter() {
  		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
  		converter.setKeyPair(this.keyPair);
  		return converter;
  	}
}
