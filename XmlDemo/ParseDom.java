import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class ParseDom {
  public static void main(String[] a) throws Exception {
    Document d = DocumentBuilderFactory.newInstance()
      .newDocumentBuilder().parse(new File("student.xml"));
    System.out.println(d.getDocumentElement().getNodeName());
    NodeList l = d.getElementsByTagName("student");
    for (int i = 0; i < l.getLength(); i++) {
      Element e = (Element) l.item(i);
      System.out.println(e.getAttribute("id") + " "
        + e.getElementsByTagName("name").item(0).getTextContent());
    }
  }
}
