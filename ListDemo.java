import java.util.*;
public class ListDemo {
  public static void main(String[] a) {
    List<String> l = new ArrayList<>();
    l.add("Apple");
    l.add("Banana");
    l.add(1, "Mango");
    l.set(0, "Orange");
    l.remove("Banana");
    System.out.println(l);
    System.out.println(l.get(1) + " " + l.contains("Mango") + " " + l.size());
    for (String s : l) System.out.println(s);
  }
}
