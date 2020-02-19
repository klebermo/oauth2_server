package oauth.server;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.KeyPair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.security.interfaces.RSAPublicKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.JWKSet;

@FrameworkEndpoint
class JwkSetEndpoint {
  @Autowired
	private KeyPair keyPair;

	@GetMapping("/.well-known/jwks.json")
	@ResponseBody
	public Map<String, Object> getKey() {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAKey key = new RSAKey.Builder(publicKey).build();
		return new JWKSet(key).toJSONObject();
	}
}
