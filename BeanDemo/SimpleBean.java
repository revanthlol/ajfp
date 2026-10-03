import java.io.Serializable;
public class SimpleBean implements Serializable {
  private String name;
  private int id;
  public SimpleBean() {}
  public String getName() { return name; }
  public void setName(String n) { name = n; }
  public int getId() { return id; }
  public void setId(int i) { id = i; }
}
