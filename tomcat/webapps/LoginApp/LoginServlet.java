import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest q, HttpServletResponse r) throws IOException {
    PrintWriter o = r.getWriter();
    String u = q.getParameter("username");
    String p = q.getParameter("password");
    if (u.equals("student") && p.equals("123"))
      o.println("<h2>Login Successful</h2>Welcome, " + u);
    else
      o.println("<h2>Login Failed</h2>");
  }
}
