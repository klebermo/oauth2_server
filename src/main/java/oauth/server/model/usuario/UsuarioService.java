package oauth.server.model.usuario;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {
  @Autowired
  private UsuarioDao dao;

  public Usuario loadUserByUsername(String username) {
    List result = dao.findBy("username", username);
    if(result != null)
      return (Usuario)result.get(0);
    else
      return null;
  }
}
