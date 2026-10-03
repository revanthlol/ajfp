import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.io.*;
public class ManipulateDom {
  public static void main(String[] a) throws Exception {
    Document d = DocumentBuilderFactory.newInstance()
      .newDocumentBuilder().parse(new File("student.xml"));
    Element s = (Element) d.getElementsByTagName("student").item(0);
    s.getElementsByTagName("grade").item(0).setTextContent("A+");
    Element dep = d.createElement("dept");
    dep.setTextContent("CS");
    s.appendChild(dep);
    TransformerFactory.newInstance().newTransformer()
      .transform(new DOMSource(d), new StreamResult(System.out));
  }
}
