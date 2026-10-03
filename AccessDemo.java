import java.util.*;
public class AccessDemo {
  public static void main(String[] a) {
    List<String> l = Arrays.asList("Red", "Green", "Blue");
    Iterator<String> it = l.iterator();
    while (it.hasNext()) System.out.print(it.next() + " ");
    ListIterator<String> li = l.listIterator();
    while (li.hasNext()) li.next();
    System.out.println();
    while (li.hasPrevious()) System.out.print(li.previous() + " ");
    System.out.println();
    for (String s : l) System.out.print(s + " ");
  }
}
