import java.util.*;
class S {
  String n; int m;
  S(String n, int m) { this.n = n; this.m = m; }
  public String toString() { return n + " " + m; }
}
class MarkCmp implements Comparator<S> {
  public int compare(S a, S b) { return b.m - a.m; }
}
public class ComparatorDemo {
  public static void main(String[] x) {
    List<S> l = new ArrayList<>();
    l.add(new S("Alice", 85));
    l.add(new S("Bob", 92));
    l.add(new S("Charlie", 78));
    Collections.sort(l, new MarkCmp());
    System.out.println(l);
  }
}
