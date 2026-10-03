import java.sql.*;
public class InsertValues {
  public static void main(String[] a) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection c = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/college", "root", "root");
    PreparedStatement p = c.prepareStatement("INSERT INTO student VALUES(?,?,?)");
    p.setInt(1, 101);
    p.setString(2, "Rahul");
    p.setDouble(3, 88.5);
    p.executeUpdate();
    System.out.println("Record inserted");
    c.close();
  }
}
