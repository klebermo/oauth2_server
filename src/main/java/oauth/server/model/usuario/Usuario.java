package oauth.server.model.usuario;

import javax.persistence.Entity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import oauth.server.model.Model;

@Entity
public class Usuario extends Model implements OAuth2User {
  public Integer getId() {
    return null;
  }
  
  public String toString() {
    return null;
  }
}
