import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/calc")
public class ArithServlet extends HttpServlet {
  protected void doGet(HttpServletRequest q, HttpServletResponse r) throws IOException {
    double a = Double.parseDouble(q.getParameter("a"));
    double b = Double.parseDouble(q.getParameter("b"));
    PrintWriter o = r.getWriter();
    o.println("Add = " + (a + b) + "<br>");
    o.println("Sub = " + (a - b) + "<br>");
    o.println("Mul = " + (a * b) + "<br>");
    o.println("Div = " + (a / b) + "<br>");
    o.println("Mod = " + (a % b));
  }
}
