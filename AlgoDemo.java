import java.util.*;
public class AlgoDemo {
  public static void main(String[] a) {
    List<Integer> l = new ArrayList<>(Arrays.asList(40, 10, 30, 20, 10));
    Collections.sort(l);
    System.out.println(l);
    Collections.reverse(l);
    System.out.println(l);
    System.out.println(Collections.min(l) + " " + Collections.max(l));
    System.out.println(Collections.frequency(l, 10));
    Collections.swap(l, 0, 4);
    Collections.sort(l);
    System.out.println(Collections.binarySearch(l, 30));
  }
}
