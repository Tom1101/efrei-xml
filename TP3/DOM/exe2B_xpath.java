import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.Scanner;

public class exe2B_xpath {
    static void deleteNode(String link, String element) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
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
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element domain = (Element) nodeList.item(i);
                final Element element1 = (Element) domain.getElementsByTagName(element).item(0);
                nodeList.item(i).removeChild(element1);
                System.out.println(domain.getTextContent());
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("You are in 'domain' element, do you want to go inside 'bib_ref' ? (y/n):");
            String res1 = in.nextLine();
            String yes = "y";
            String no = "n";
            if (res1.equals(yes)) {
                System.out.println("Enter name of element for deleting:");
                String element = in.nextLine();
                System.out.println("Are you sure (y/n):");
                String res2 = in.nextLine();
                if (res2.equals(yes)) {
                    System.out.println("debut");
                    deleteNode("/bib/domain/bib_ref", element);
                    System.out.println("fin");
                } else {
                    System.out.println("fin");
                }
            } else if (res1.equals(no)) {
                System.out.println("Enter name of element for deleting:");
                String element = in.nextLine();
                System.out.println("Are you sure (y/n):");
                String res2 = in.nextLine();
                if (res2.equals(yes)) {
                    System.out.println("debut");
                    deleteNode("/bib/domain", element);
                    System.out.println("fin");
                } else {
                    System.out.println("fin");
                }
            } else {
                System.out.println("fin");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
