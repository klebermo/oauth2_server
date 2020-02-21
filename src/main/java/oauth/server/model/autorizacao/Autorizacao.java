package oauth.server.model.autorizacao;

import javax.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Autorizacao implements GrantedAuthority {
  public String getAuthority() {
    return null;
  }
}
