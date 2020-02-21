package oauth.server.model;

public abstract class Model extends Object {
  public abstract Object getId();

  public boolean equals(Model object) {
    return this.toString().equals(object.toString());
  }

  public abstract String toString();
}
