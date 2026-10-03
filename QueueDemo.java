import java.util.*;
public class QueueDemo {
  public static void main(String[] a) {
    Queue<String> q = new LinkedList<>();
    q.offer("T1"); q.offer("T2"); q.offer("T3");
    System.out.println(q.peek());
    System.out.println(q.poll());
    System.out.println(q);
  }
}
