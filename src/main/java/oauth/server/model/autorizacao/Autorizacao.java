package oauth.server.model.autorizacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Autorizacao implements GrantedAuthority {
  @Id
  private Integer id;

  @Column
  private String name;

  public Integer getId() {
    return id;
  }

  public void setInteger(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthority() {
    return name;
  }
}
