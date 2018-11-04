import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class exe2A {

    public static void readElement(String _fichier, String input)
            throws SAXException, ParserConfigurationException, IOException {

        // Charger le document
        FileInputStream _xml_input_file = new FileInputStream(_fichier);

        parse(_xml_input_file, input);
    }

    public static void parse(InputStream _xml_input_file, String input)
            throws SAXException, ParserConfigurationException, IOException {
        //instancier le contrcuteur de parseurs
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

        //ignorer les commentaires dans les fichiers XML parser_exo1
        _factory.setIgnoringComments(true);

        // cree un parseur
        DocumentBuilder _builder = _factory.newDocumentBuilder();

        // Charger le document
        Document doc = _builder.parse(_xml_input_file);

        // Parser le document
        final Element racine = doc.getDocumentElement(); // racine = bib.xml
        final NodeList nodeList = racine.getElementsByTagName(input);
        final int nodeListLength = nodeList.getLength();
        // First loop: only display titles
        for (int i = 0; i<nodeListLength; i++) {
            if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                // Display the titles
                System.out.println(nodeList.item(i).getTextContent());
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String filename="bib.xml";
            System.out.println("Enter name of element:");
            String element = in.nextLine();
            System.out.println("debut");
            readElement(filename, element);
            System.out.println("fin");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}