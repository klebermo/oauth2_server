package oauth.server.model;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import java.util.List;

public class Dao<E> {
  @Autowired
  private EntityManagerFactory factory;

  private Class<E> classe;

  public Dao(Class<E> classe) {
    this.classe = classe;
  }

  public EntityManager getEntityManager() {
    return factory.createEntityManager();
  }

  public E insert(E object) {
    EntityManager entityManager = getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(object);
    entityManager.getTransaction().commit();
    entityManager.close();
    return object;
  }

  public E update(E object) {
    EntityManager entityManager = getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.merge(object);
    entityManager.getTransaction().commit();
    entityManager.close();
    return object;
  }

  public E delete(E object) {
    EntityManager entityManager = getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.remove(entityManager.contains(object) ? object : entityManager.merge(object));
    entityManager.getTransaction().commit();
    entityManager.close();
    return object;
  }

  public List<E> select() {
    EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		List<E> lista = entityManager.createQuery("SELECT a FROM "+classe.getSimpleName()+" a").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
    return lista;
  }

  public List findBy(String key, Object value) {
    EntityManager entityManager = getEntityManager();
    entityManager.getTransaction().begin();
    List result = entityManager.createQuery("SELECT a FROM "+classe.getSimpleName()+" a WHERE a."+key+" = :value").setParameter("value", value).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return result;
  }
}
