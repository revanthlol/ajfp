import java.io.*;
import java.net.*;
public class FactServer {
  public static void main(String[] a) throws Exception {
    ServerSocket ss = new ServerSocket(5000);
    Socket s = ss.accept();
    DataInputStream in = new DataInputStream(s.getInputStream());
    DataOutputStream out = new DataOutputStream(s.getOutputStream());
    int n = in.readInt();
    long f = 1;
    for (int i = 2; i <= n; i++) f *= i;
    out.writeLong(f);
    s.close(); ss.close();
  }
}
