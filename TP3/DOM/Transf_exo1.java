/*
 * Created on 26 nov. 2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */


/**
 * @author Salim
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

public class Transf_exo1 {

	public static void main(String[] args) {
		try {
		System.out.println("debut");
			parser_exo1 parseur  = new parser_exo1();
		
		String filename = "bib.xml";
		
		parseur.parse(filename);
		System.out.println("fin");
		
		}
		catch (Exception e ){
			e.printStackTrace();
		}
		
	}
}
