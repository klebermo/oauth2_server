package oauth.server.model.cliente;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ClienteService implements ClientDetailsService {
  @Autowired
  private ClienteDao dao;

  public Cliente loadClientByClientId(String clientId)  {
    List result =  dao.findBy("clientId", clientId);
    if(result != null)
      return (Cliente)result.get(0);
    else
      return null;
  }
}
