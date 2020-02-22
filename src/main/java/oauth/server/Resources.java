package oauth.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
public class Resources {
	@GetMapping("/userinfo")
	public String whoami(@AuthenticationPrincipal(expression="name") String name) {
		return name;
  }
}
