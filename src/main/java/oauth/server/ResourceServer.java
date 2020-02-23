package oauth.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;


@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServer extends ResourceServerConfigurerAdapter {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private ResourceServerTokenServices resourceTokenServices;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
      .resourceId("resource-server-rest-api")
      .authenticationManager(authenticationManager)
			.tokenExtractor(tokenExtractor());
	}

  @Override
	public void configure(HttpSecurity http) throws Exception {
		http
      .httpBasic()
        .disable()
        .anonymous()
      .and()
      .authorizeRequests()
        .antMatchers("/user**").authenticated()
				.antMatchers("/", " /doLogin").permitAll();
	}

  public TokenExtractor tokenExtractor() {
    return new TokenExtractor() {
      @Override
      public Authentication extract(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders("Authorization");

    		while (headers.hasMoreElements()) {
    			String value = headers.nextElement();

    			if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
    				String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
    				request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE,value.substring(0, OAuth2AccessToken.BEARER_TYPE.length()).trim());
    				int commaIndex = authHeaderValue.indexOf(',');
            
    				if (commaIndex > 0) {
    					authHeaderValue = authHeaderValue.substring(0, commaIndex);
    				}

    				return new PreAuthenticatedAuthenticationToken(authHeaderValue, "");
    			}
    		}

    		return null;
      }
    };
  }
}
