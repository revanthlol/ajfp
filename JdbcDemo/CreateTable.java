import java.sql.*;
public class CreateTable {
  public static void main(String[] a) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection c = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/college", "root", "root");
    Statement s = c.createStatement();
    s.executeUpdate("CREATE TABLE student(id INT PRIMARY KEY, name VARCHAR(50), marks DOUBLE)");
    System.out.println("Table created");
    c.close();
  }
}
