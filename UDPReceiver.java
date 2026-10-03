import java.io.*;
import java.net.*;
public class UDPReceiver {
  public static void main(String[] a) throws Exception {
    DatagramSocket s = new DatagramSocket(9876);
    byte[] b = new byte[1024];
    DatagramPacket p = new DatagramPacket(b, b.length);
    s.receive(p);
    ObjectInputStream in = new ObjectInputStream(
      new ByteArrayInputStream(p.getData(), 0, p.getLength()));
    System.out.println("Received: " + in.readObject());
    s.close();
  }
}
