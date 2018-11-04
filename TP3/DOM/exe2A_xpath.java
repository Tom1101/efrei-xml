import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.Scanner;

public class exe2A_xpath {
    static void readNode(String link, String element) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String filename = "bib.xml";
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        //ignorer les commentaires dans les fichiers XML parser_exo1
        _factory.setIgnoringComments(true);
        // cree un parseur
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        // Charger le document
        Document doc = _builder.parse(filename);
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile(link).evaluate(
                doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element domain = (Element) nodeList.item(i);
                final Element element1 = (Element) domain.getElementsByTagName(element).item(0);
                System.out.println(element1.getTextContent());
            }
        }
    }
    public static void main(String[] args) {
        try {
            String filename = "bib.xml";
            DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
            //ignorer les commentaires dans les fichiers XML parser_exo1
            _factory.setIgnoringComments(true);
            // cree un parseur
            DocumentBuilder _builder = _factory.newDocumentBuilder();
            // Charger le document
            Document doc = _builder.parse(filename);
            XPath xPath =  XPathFactory.newInstance().newXPath();
            Scanner in = new Scanner(System.in);
            String res = in.nextLine();
            String yes = "y";
            String no = "n";
            if( res.equals(yes)) {
                String expression = "/bib/domain/bib_ref";
                System.out.println("Enter name of element:");
                String element = in.nextLine();
                System.out.println("debut");
                readNode(expression,element);
                System.out.println("fin");
            } else if (res.equals(no)){
                String expression = "/bib/domain";
                System.out.println("Enter name of element:");
                String element = in.nextLine();
                System.out.println("debut");
                readNode(expression,element);
                System.out.println("fin");
            } else {
                System.out.println("fin");
            }

        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

}
