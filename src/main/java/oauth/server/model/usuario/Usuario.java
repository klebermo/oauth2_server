package oauth.server.model.usuario;

import javax.persistence.Entity;
import oauth.server.model.Model;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import oauth.server.model.credencial.Credencial;
import java.util.Date;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Usuario extends Model implements UserDetails {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String username;

  @Column
  private String password;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String email;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="usuario_credenciais", joinColumns={@JoinColumn(name="usuario_id")}, inverseJoinColumns={@JoinColumn(name="credencial_id")})
  private List<Credencial> credenciais;

  @Column
  private Date dataExpiracao;

  @Column
  private Boolean enabled;

  @Column
  private Boolean locked;

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(4);
    this.password = bcrypt.encode(password);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Credencial> getCredenciais() {
    return credenciais;
  }

  public void setCredenciais(List<Credencial> credenciais) {
    this.credenciais = credenciais;
  }

  public Date getDataExpiracao() {
    return dataExpiracao;
  }

  public void setDataExpiracao(Date dataExpiracao) {
    this.dataExpiracao = dataExpiracao;
  }

  public Boolean getEnabled() {
    if(this.enabled == null)
      return true;
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    if(enabled == null)
      this.enabled = false;
    this.enabled = enabled;
  }

  public Boolean getLocked() {
    if(this.locked == null)
      return false;
    return locked;
  }

  public void setLocked(Boolean locked) {
    if(locked == null)
      this.locked = false;
    this.locked = locked;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }

  @Override
  public boolean isEnabled() {
    return getEnabled();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !this.getLocked();
  }

  @Override
  public boolean isAccountNonExpired() {
    Date hoje = new Date();
    if(this.dataExpiracao == null)
      return true;
    else
      return hoje.before(dataExpiracao);
  }

  @Override
  public Collection<? extends GrantedAuthority>	getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for(Credencial c : credenciais)
      authorities.addAll(c.getAutorizacoes());
    return authorities;
  }
}
