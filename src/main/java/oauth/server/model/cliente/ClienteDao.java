package oauth.server.model.cliente;

import oauth.server.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao extends Dao<Cliente> {
  public ClienteDao() {
    super(Cliente.class);
  }
}
