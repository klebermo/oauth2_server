package oauth.server.model.credencial;

import oauth.server.model.Model;
import java.util.List;
import java.util.Date;
import oauth.server.model.autorizacao.Autorizacao;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Credencial extends Model {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String nome;

  @OneToMany(fetch = FetchType.EAGER)
  @Fetch(FetchMode.SELECT)
  private List<Autorizacao> autorizacoes;

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Autorizacao> getAutorizacoes() {
    return autorizacoes;
  }

  public void setAutorizacoes(List<Autorizacao> autorizacoes) {
    this.autorizacoes = autorizacoes;
  }

  @Override
  public String toString() {
    return nome;
  }
}
