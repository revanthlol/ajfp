import java.io.*;
import java.net.*;
public class FactClient {
  public static void main(String[] a) throws Exception {
    Socket s = new Socket("localhost", 5000);
    DataOutputStream out = new DataOutputStream(s.getOutputStream());
    DataInputStream in = new DataInputStream(s.getInputStream());
    out.writeInt(5);
    System.out.println("Factorial = " + in.readLong());
    s.close();
  }
}
