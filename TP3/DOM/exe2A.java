import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.util.Scanner;

public class exe2A {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name of first element:");
            String element = in.nextLine();
            System.out.println("debut");
            String filename = "bib.xml";
            DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
            //ignorer les commentaires dans les fichiers XML parser
            _factory.setIgnoringComments(true);
            // cree un parseur
            DocumentBuilder _builder = _factory.newDocumentBuilder();
            // Charger le document
            Document doc = _builder.parse(filename);
            XPath xPath =  XPathFactory.newInstance().newXPath();
            String expression = "/bib/domain";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);
            // Parser le document
            for (int i = 0; i < nodeList.getLength(); i++) {
                if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    final Element domain = (Element) nodeList.item(i);
                    final Element element1 = (Element) domain.getElementsByTagName(element).item(0);
                    System.out.println(element1.getTextContent());
                }
            }
            System.out.println("fin");
        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

}
