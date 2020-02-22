package oauth.server.model.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import oauth.server.model.Model;
import org.springframework.security.oauth2.provider.ClientDetails;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Entity
public class Cliente extends Model implements ClientDetails {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String clientId;

  @Column
  private String clientSecret;

  @ElementCollection
  @Column
  private Set<String> authorizedGrantTypes;

  @Column
  private Integer accessTokenValiditySeconds;

  @Column
  private Integer refreshTokenValiditySeconds;

  @ElementCollection
  @Column
  private Set<String> registeredRedirectUri;

  @ElementCollection
  @Column
  private Set<String> resourceIds;

  @ElementCollection
  @Column
  private Set<String> scope;

  @Column
  private boolean scoped;

  @Column
  private boolean secretRequired;

	/**
	* Default empty Cliente constructor
	*/
	public Cliente() {
		super();
	}

	/**
	* Default Cliente constructor
	*/
	public Cliente(Integer id, String clientId, String clientSecret, Set<String> authorizedGrantTypes, Integer accessTokenValiditySeconds, Integer refreshTokenValiditySeconds, Set<String> registeredRedirectUri, Set<String> resourceIds, Set<String> scope, boolean scoped, boolean secretRequired) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
		this.registeredRedirectUri = registeredRedirectUri;
		this.resourceIds = resourceIds;
		this.scope = scope;
		this.scoped = scoped;
		this.secretRequired = secretRequired;
	}

	/**
	* Returns value of id
	* @return
	*/
	public Integer getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	* Returns value of clientId
	* @return
	*/
	public String getClientId() {
		return clientId;
	}

	/**
	* Sets new value of clientId
	* @param
	*/
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	* Returns value of clientSecret
	* @return
	*/
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	* Sets new value of clientSecret
	* @param
	*/
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	* Returns value of authorizedGrantTypes
	* @return
	*/
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	/**
	* Sets new value of authorizedGrantTypes
	* @param
	*/
	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	/**
	* Returns value of accessTokenValiditySeconds
	* @return
	*/
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	/**
	* Sets new value of accessTokenValiditySeconds
	* @param
	*/
	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	/**
	* Returns value of refreshTokenValiditySeconds
	* @return
	*/
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	/**
	* Sets new value of refreshTokenValiditySeconds
	* @param
	*/
	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	/**
	* Returns value of redirectUris
	* @return
	*/
	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	/**
	* Sets new value of redirectUris
	* @param
	*/
	public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
	}

	/**
	* Returns value of resourceId
	* @return
	*/
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	/**
	* Sets new value of resourceId
	* @param
	*/
	public void setResourceId(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	/**
	* Returns value of scope
	* @return
	*/
	public Set<String> getScope() {
		return scope;
	}

	/**
	* Sets new value of scope
	* @param
	*/
	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	/**
	* Returns value of scoped
	* @return
	*/
	public boolean isScoped() {
		return scoped;
	}

	/**
	* Sets new value of scoped
	* @param
	*/
	public void setScoped(boolean scoped) {
		this.scoped = scoped;
	}

	/**
	* Returns value of secretRequired
	* @return
	*/
	public boolean isSecretRequired() {
		return secretRequired;
	}

	/**
	* Sets new value of secretRequired
	* @param
	*/
	public void setSecretRequired(boolean secretRequired) {
		this.secretRequired = secretRequired;
	}

	/**
	* Create string representation of Cliente for printing
	* @return
	*/
	@Override
	public String toString() {
		return clientId;
	}

  public Collection<org.springframework.security.core.GrantedAuthority> 	getAuthorities() {
    return null;
  }

  public Map<String,Object> 	getAdditionalInformation() {
    return null;
  }

  public boolean isAutoApprove(String scope) {
    return true;
  }
}
