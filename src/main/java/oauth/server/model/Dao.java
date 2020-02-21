package oauth.server.model;

import java.util.List;

public class Dao<E> {
  private Class<E> classe;

  public Dao(Class<E> classe) {
    this.classe = classe;
  }

  public void insert(E object) {
    //
  }

  public void update(E object) {
    //
  }

  public void delete(E object) {
    //
  }

  public List select() {
    return null;
  }

  public List findBy(String key, Object value) {
    return null;
  }
}
