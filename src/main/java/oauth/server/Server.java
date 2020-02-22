package oauth.server;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import javax.sql.DataSource;
import java.security.KeyPair;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.context.annotation.Bean;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
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
    private DataSource dataSource;

    @Autowired
    private KeyPair keyPair;

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .jdbc(this.dataSource)
            .passwordEncoder(new BCryptPasswordEncoder(4));
    }

    @Override
  	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
  		endpoints
  			.authenticationManager(this.authenticationManager)
  			.accessTokenConverter(accessTokenConverter())
  			.tokenStore(tokenStore());
  	}

    @Bean
  	public KeyPair keyPairBean() throws NoSuchAlgorithmException {
  		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
  		gen.initialize(2048);
  		KeyPair keyPair = gen.generateKeyPair();
  		return keyPair;
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
