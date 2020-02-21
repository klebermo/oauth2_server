package oauth.server.model.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import oauth.server.model.Model;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import java.util.List;
import oauth.server.model.autorizacao.Autorizacao;
import java.util.Collection;

@Entity
public class Usuario extends Model implements UserDetails {
  @Id
  private Integer id;

  @Column
  private String username;

  @Column
  private String password;

  @OneToMany
  private List<Autorizacao> autorizacoes;

  public Integer getId() {
    return id;
  }

  public void setId() {
    this.id = id;
  }

  public String	getUsername() {
    return username;
  }

  public String	getPassword() {
    return password;
  }

  public Collection<Autorizacao> getAuthorities() {
    return autorizacoes;
  }

  public boolean	isAccountNonExpired() {
    return true;
  }

  public boolean	isAccountNonLocked() {
    return true;
  }

  public boolean	isCredentialsNonExpired() {
    return true;
  }

  public boolean	isEnabled() {
    return true;
  }

  public String toString() {
    return username;
  }
}
