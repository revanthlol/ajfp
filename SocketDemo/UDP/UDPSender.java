import java.io.*;
import java.net.*;
public class UDPSender {
  public static void main(String[] a) throws Exception {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    new ObjectOutputStream(bo).writeObject(new Student(101, "Rahul"));
    byte[] d = bo.toByteArray();
    DatagramSocket s = new DatagramSocket();
    s.send(new DatagramPacket(d, d.length, InetAddress.getByName("localhost"), 9876));
    s.close();
  }
}
