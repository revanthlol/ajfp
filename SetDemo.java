import java.util.*;
public class SetDemo {
  public static void main(String[] a) {
    Set<String> h = new HashSet<>();
    h.add("Java"); h.add("Python"); h.add("Java");
    Set<Integer> t = new TreeSet<>();
    t.add(40); t.add(10); t.add(30);
    System.out.println(h.size() + " " + h.contains("Java"));
    h.remove("Java");
    System.out.println(h + " " + t);
  }
}
