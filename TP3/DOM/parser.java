/*
 * Created on 26 nov. 2003
 *
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */

import java.io.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;

public class parser {

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

        //creaion du fichier output
        out = new PrintWriter(
                new FileOutputStream("./output.html"));
        out.println("<html xmlns:fo=\"http://www.w3.org/1999/XSL/Format\"><head />");
        out.println("<body>");
        out.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><h1 align=\"left\">Domaines </h1>");

        //instancier le contrcuteur de parseurs
        DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

        //ignorer les commentaires dans les fichiers XML parser
        _factory.setIgnoringComments(true);

        // cree un parseur
        DocumentBuilder _builder = _factory.newDocumentBuilder();

        // Charger le document
        Document doc = _builder.parse(_xml_input_file);

        // Parser le document
        final Element racine = doc.getDocumentElement(); // racine = bib.xml
        final NodeList racineNoeuds = racine.getChildNodes(); // get Child Nodes from racine

        // show name of every nodes
        final int nbRacineNoeuds = racineNoeuds.getLength();
        // First loop: only display titles
        for (int i = 0; i<nbRacineNoeuds; i++) {
            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                // Domain
                final Element domain = (Element) racineNoeuds.item(i);
                final Element title = (Element) domain.getElementsByTagName("title").item(0);
                // Display the titles
                out.println("<h2><a href=\"#"+title.getTextContent()+"\">"+title.getTextContent()+"</a></h2>");
            }
        }
        out.println("<hr>");
        out.println("<hr>");
        for(int i = 0; i<nbRacineNoeuds; i++) {
            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                //Domain
                final Element domain = (Element) racineNoeuds.item(i);
                final Element title = (Element) domain.getElementsByTagName("title").item(0);
                this.DomaineTemplate(domain, title.getTextContent());
                //bib_ref
                final NodeList bib_refs = domain.getElementsByTagName("bib_ref");
                final int nbBib_refNoueds = bib_refs.getLength();
                for(int j = 0; j < nbBib_refNoueds; j++) {
                    final Element bib_ref = (Element) bib_refs.item(j);
                    out.println("<hr>");
                    //get Year
                    final Element year = (Element) bib_ref.getElementsByTagName("year").item(0);
                    // show the year
                    out.println("Annee  :"+year.getTextContent());
                    out.println("<br />");
                    //get Title Child
                    final Element titleChild = (Element) bib_ref.getElementsByTagName("title").item(0);
                    // show titleChild
                    out.println("<h3>Titre  :"+titleChild.getTextContent()+"</h3>");
                    //get author
                    final Element author = (Element) bib_ref.getElementsByTagName("author").item(0);
                    //show author
                    out.println("Author  :"+author.getTextContent());
                    out.println("<br />");
                    //get weblink
                    final Element weblink = (Element) bib_ref.getElementsByTagName("weblink").item(0);
                    //show weblink
                    out.println("Lien : <a href=\"" + weblink.getTextContent() + "\">" + weblink.getTextContent() + "</a></h2>");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<hr>");
                }
            }
        }


        out.close();
        out.flush();
    }

    public void DomaineTemplate(Element domaine, String name) {
        out.println("<table width=\"100%\" border=\"1\">");
        out.println("	<tr>");
        out.println("   	<td width=\"100%\" bgcolor=\"#C0C0C0\">");
        out.println(
                "			<h2><a name=\"" + name + "\">" + name + "</a></h2>");
        out.println("		</td>");
        out.println("	</tr>");
        out.println("</table>");
    }

}