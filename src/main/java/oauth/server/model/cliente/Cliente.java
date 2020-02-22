package oauth.server.model.cliente;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import oauth.server.model.Model;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="oauth_client_details")
public class Cliente extends Model {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String clientId;

  @Column
  private String clientSecret;

  @Column
  private String authorizedGrantTypes;

  @Column(length=11)
  private Integer accessTokenValidity;

  @Column(length=11)
  private Integer refreshTokenValidity;

  @Column
  private String webServerRedirectUri;

  @Column
  private String resourceIds;

  @Column
  private String authorities;

  @Column
  private String scope;

  @Column
  private boolean scoped;

  @Column
  private boolean secretRequired;

  @Column(name="autoapprove")
  private boolean autoApprove;

  @Column(length=4096)
	private String additionalInformation;

	/**
	* Default empty Cliente constructor
	*/
	public Cliente() {
		super();
	}

	/**
	* Default Cliente constructor
	*/
	public Cliente(Integer id, String clientId, String clientSecret, String authorizedGrantTypes, Integer accessTokenValidity, Integer refreshTokenValidity, String webServerRedirectUri, String resourceIds, String authorities, String scope, boolean scoped, boolean secretRequired, boolean autoApprove, String additionalInformation) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.accessTokenValidity = accessTokenValidity;
		this.refreshTokenValidity = refreshTokenValidity;
		this.webServerRedirectUri = webServerRedirectUri;
		this.resourceIds = resourceIds;
		this.authorities = authorities;
		this.scope = scope;
		this.scoped = scoped;
		this.secretRequired = secretRequired;
		this.autoApprove = autoApprove;
		this.additionalInformation = additionalInformation;
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
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	/**
	* Sets new value of authorizedGrantTypes
	* @param
	*/
	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	/**
	* Returns value of accessTokenValidity
	* @return
	*/
	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	/**
	* Sets new value of accessTokenValidity
	* @param
	*/
	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	/**
	* Returns value of refreshTokenValidity
	* @return
	*/
	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	/**
	* Sets new value of refreshTokenValidity
	* @param
	*/
	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	/**
	* Returns value of webServerRedirectUri
	* @return
	*/
	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	/**
	* Sets new value of webServerRedirectUri
	* @param
	*/
	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	/**
	* Returns value of resourceIds
	* @return
	*/
	public String getResourceIds() {
		return resourceIds;
	}

	/**
	* Sets new value of resourceIds
	* @param
	*/
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	/**
	* Returns value of authorities
	* @return
	*/
	public String getAuthorities() {
		return authorities;
	}

	/**
	* Sets new value of authorities
	* @param
	*/
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	/**
	* Returns value of scope
	* @return
	*/
	public String getScope() {
		return scope;
	}

	/**
	* Sets new value of scope
	* @param
	*/
	public void setScope(String scope) {
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
	* Returns value of autoApprove
	* @return
	*/
	public boolean isAutoApprove() {
		return autoApprove;
	}

	/**
	* Sets new value of autoApprove
	* @param
	*/
	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	/**
	* Returns value of additionalInformation
	* @return
	*/
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	/**
	* Sets new value of additionalInformation
	* @param
	*/
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	/**
	* Create string representation of Cliente for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", clientId=" + clientId + ", clientSecret=" + clientSecret + ", authorizedGrantTypes=" + authorizedGrantTypes + ", accessTokenValidity=" + accessTokenValidity + ", refreshTokenValidity=" + refreshTokenValidity + ", webServerRedirectUri=" + webServerRedirectUri + ", resourceIds=" + resourceIds + ", authorities=" + authorities + ", scope=" + scope + ", scoped=" + scoped + ", secretRequired=" + secretRequired + ", autoApprove=" + autoApprove + ", additionalInformation=" + additionalInformation + "]";
	}
}
