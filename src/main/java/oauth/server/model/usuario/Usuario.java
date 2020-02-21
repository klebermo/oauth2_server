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
import org.springframework.security.core.GrantedAuthority;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Usuario extends Model implements UserDetails, ClientDetails {
  @Id
  private Integer id;

  @Column
  private String username;

  @Column
  private String password;

  @OneToMany
  private Collection<Autorizacao> autorizacoes;

  @OneToMany
  private Set<String> authorizedGrantTypes;

  @Column
  private String clientId;

  @Column
  private String clientSecret;

  @OneToMany
  private Set<String> redirectUris;

  @OneToMany
  private Set<String> resourceId;

  @OneToMany
  private Set<String> scope;

  public Integer getId() {
    return null;
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

  public Integer	getAccessTokenValiditySeconds() {
    return 3600;
  }

  public Map<String,Object>	getAdditionalInformation() {
    return new HashMap<String,Object>();
  }

  public Set<String>	getAuthorizedGrantTypes() {
    return authorizedGrantTypes;
  }

  public String	getClientId() {
    return clientId;
  }

  public String	getClientSecret() {
    return clientSecret;
  }

  public Integer	getRefreshTokenValiditySeconds() {
    return 3600;
  }

  public Set<String>	getRegisteredRedirectUri() {
    return redirectUris;
  }

  public Set<String>	getResourceIds() {
    return resourceId;
  }

  public Set<String>	getScope() {
    return scope;
  }

  public boolean	isAutoApprove(String scope) {
    return true;
  }

  public boolean	isScoped() {
    return true;
  }

  public boolean	isSecretRequired() {
    return true;
  }

  public String toString() {
    return username;
  }
}
