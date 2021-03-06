import java.io.*;
import java.security.AllPermission;
import java.util.Scanner;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;

public class parser_exo3 {

    public PrintWriter out = null;

    //Rem changer Package par ModelElement
    public void parse(String _fichier)
            throws SAXException, ParserConfigurationException, IOException {

        // Charger le document
        FileInputStream _xml_input_file = new FileInputStream(_fichier);

        parse(_xml_input_file);
    }

    public void parse(InputStream _xml_input_file)
            throws SAXException, ParserConfigurationException, IOException {
        out = new PrintWriter(
                new FileOutputStream("./gender_output.xml"));
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE list [");
        out.println("<!ELEMENT list (man | woman)*>");
        out.println("<!ELEMENT man (sons, daughters)>");
        out.println("<!ATTLIST man name CDATA #REQUIRED>");
        out.println("<!ELEMENT woman (sons, daughters)>");
        out.println("<!ATTLIST woman name CDATA #REQUIRED>");
        out.println("<!ELEMENT sons (man)*>");
        out.println("<!ELEMENT daughters (woman)*>");
        out.println("]>");
        out.println("<list>");
        //instancier le contructeur de parseurs
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
        //ignorer les commentaires dans les fichiers XML parsees
        _factory.setIgnoringComments(true);
        // creer un parseur
        DocumentBuilder _builder = _factory.newDocumentBuilder();
        // Charger le document
        Document doc = _builder.parse(_xml_input_file);
        // Parser le document
        Element library = doc.getDocumentElement();
        NodeList allChilds = library.getChildNodes();
        // boucle affichage le fichier xml
        for (int i = 0; i < allChilds.getLength(); i++) {
            Node node = allChilds.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elt = (Element) node;
                out.print(Template(elt, 1));
            }
        }
        out.print("</list>");
        out.close();
        out.flush();
    }
    // Template Principale pour le fichier xml
    public String Template(Element domaine, int cpt) {
        String s = "";
        NodeList filsDomaine = domaine.getChildNodes();
        // If gender is male
        if (domaine.getAttributeNode("gender").getValue().equals("M")) {
            s += tab(cpt);
            s += "<man name=\"" + domaine.getElementsByTagName("name").item(0).getTextContent() + "\">\n";
            s += tab(cpt + 1);
            s += "<sons>\n";

            for (int i = 0; i < filsDomaine.getLength(); i++) {
                Node node = filsDomaine.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elt = (Element) node;
                    if (elt.getNodeName().equals("children")) {
                        NodeList filsfilsDomaine = elt.getChildNodes();

                        for (int j = 0; j < filsfilsDomaine.getLength(); j++) {
                            Node nodefils = filsfilsDomaine.item(j);
                            if (nodefils.getNodeType() == Node.ELEMENT_NODE) {
                                Element eltfils = (Element) nodefils;
                                if (eltfils.getAttributeNode("gender").getValue().equals("M")) {
                                    s += Template(eltfils, cpt + 1);
                                }
                            }
                        }
                    }
                }
            }

            s += tab(cpt + 1);
            s += "</sons>\n";
            s += tab(cpt + 1);
            s += "<daughters>\n";
            for (int i = 0; i < filsDomaine.getLength(); i++) {
                Node node = filsDomaine.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elt = (Element) node;
                    if (elt.getNodeName().equals("children")) {
                        NodeList filsfilsDomaine = elt.getChildNodes();
                        for (int j = 0; j < filsfilsDomaine.getLength(); j++) {
                            Node nodefils = filsfilsDomaine.item(j);
                            if (nodefils.getNodeType() == Node.ELEMENT_NODE) {
                                Element eltfils = (Element) nodefils;
                                if (eltfils.getAttributeNode("gender").getValue().equals("F")) {
                                    s += Template(eltfils, cpt + 2);
                                }
                            }
                        }
                    }
                }
            }
            s += tab(cpt + 1);
            s += "</daughters>\n";
            s += tab(cpt);
            s += "</man>";
        } else { // Or gender is female
            s += tab(cpt);
            s += "<woman name=\"" + domaine.getElementsByTagName("name").item(0).getTextContent() + "\">\n";
            s += tab(cpt + 1);
            s += "<sons>\n";
            for (int i = 0; i < filsDomaine.getLength(); i++) {
                Node node = filsDomaine.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elt = (Element) node;
                    if (elt.getNodeName().equals("children")) {
                        NodeList filsfilsDomaine = elt.getChildNodes();
                        for (int j = 0; j < filsfilsDomaine.getLength(); j++) {
                            Node nodefils = filsfilsDomaine.item(j);
                            if (nodefils.getNodeType() == Node.ELEMENT_NODE) {
                                Element eltfils = (Element) nodefils;
                                if (eltfils.getAttributeNode("gender").getValue().equals("M")) {
                                    s += Template(eltfils, cpt + 1);
                                }
                            }
                        }
                    }
                }
            }

            s += tab(cpt + 1);
            s += "</sons>\n";
            s += tab(cpt + 1);
            s += "<daughters>\n";

            for (int i = 0; i < filsDomaine.getLength(); i++) {
                Node node = filsDomaine.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elt = (Element) node;
                    if (elt.getNodeName().equals("children")) {
                        NodeList filsfilsDomaine = elt.getChildNodes();

                        for (int j = 0; j < filsfilsDomaine.getLength(); j++) {
                            Node nodefils = filsfilsDomaine.item(j);
                            if (nodefils.getNodeType() == Node.ELEMENT_NODE) {
                                Element eltfils = (Element) nodefils;
                                if (eltfils.getAttributeNode("gender").getValue().equals("F")) {
                                    s += Template(eltfils, cpt + 1);
                                }
                            }
                        }
                    }
                }
            }
            s += tab(cpt + 1);
            s += "</daughters>\n";
            s += tab(cpt);
            s += "</woman>";
        }
        s += "\n";
        return s;
    }
    // Just for \t
    public String tab(int cpt) {
        String s = "";
        for (int i = 0; i < cpt; i++) {
            s += "\t";
        }
        return s;
    }
}
