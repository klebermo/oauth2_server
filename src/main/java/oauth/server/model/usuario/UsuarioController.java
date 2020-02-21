package oauth.server.model.usuario;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
public class UsuarioController {
	@GetMapping("/userinfo")
	public String whoami(@AuthenticationPrincipal(expression="name") String name) {
		return name;
  }
}
