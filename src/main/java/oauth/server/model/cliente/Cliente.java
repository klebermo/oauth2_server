package oauth.server.model.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import oauth.server.model.Model;
import org.springframework.security.oauth2.provider.ClientDetails;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import oauth.server.model.usuario.Usuario;
import oauth.server.model.autorizacao.Autorizacao;

@Entity
public class Cliente extends Model implements ClientDetails {
  @Id
  private Integer id;

  @Column
  private String clientId;

  @Column
  private String clientSecret;

  @ElementCollection
  @Column(name="authorized_grant_types")
  private Set<String> authorizedGrantTypes;

  @Column
  private Integer accessTokenValiditySeconds;

  @Column
  private Integer refreshTokenValiditySeconds;

  @ElementCollection
  @Column(name="redirect_uris")
  private Set<String> redirectUris;

  @ElementCollection
  @Column(name="resource_id")
  private Set<String> resourceId;

  @ElementCollection
  @Column(name="scope")
  private Set<String> scope;

  @Column
  private boolean autoApprove;

  @Column
  private boolean scoped;

  @Column
  private boolean secretRequired;

  @ElementCollection
  @Column(name="authorities")
  private Collection<GrantedAuthority> authorities;

  public Integer getId() {
    return id;
  }

  public void setId() {
    this.id = id;
  }

  public String	getClientId() {
    return clientId;
  }

  public String	getClientSecret() {
    return clientSecret;
  }

  public Set<String>	getAuthorizedGrantTypes() {
    return authorizedGrantTypes;
  }

  public Integer	getAccessTokenValiditySeconds() {
    return 3600;
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
    return autoApprove;
  }

  public boolean	isScoped() {
    return scoped;
  }

  public boolean	isSecretRequired() {
    return secretRequired;
  }

  public Collection<GrantedAuthority>	getAuthorities() {
    return authorities;
  }

  public Map<String,Object>	getAdditionalInformation() {
    return new HashMap<String,Object>();
  }

  public String toString() {
    return clientId;
  }
}
