public class Transf_exo3 {

	public static void main(String[] args) {
		try {
		System.out.println("debut");
			Parser_exo3 parseur  = new Parser_exo3();
		
		String filename = "gender.xml";
		
		parseur.parse(filename);
		System.out.println("fin");
		
		}
		catch (Exception e ){
			e.printStackTrace();
		}
		
	}
}
