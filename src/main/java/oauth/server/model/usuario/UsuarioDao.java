package oauth.server.model.usuario;

import oauth.server.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao extends Dao<Usuario> {
  public UsuarioDao() {
    super(Usuario.class);
  }
}
