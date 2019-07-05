import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ArrayToArrayList {

	public static void main(final String[] args) {
		
	List<String> liste = new ArrayList<String> ();	
	List<String> sousliste = new ArrayList<String> ();	

		liste.add("RED");
		liste.add("GREEN");
		liste.add("ORANGE");
		liste.add("WHITE");
		liste.add("BLACK");
	
		System.out.println("Première liste");
		System.out.print(liste);
		
		
		
	System.out.println("\n");
	System.out.println("Deuxième liste");
	Collections.reverse(liste);
	System.out.println(liste);
		
		
	System.out.println("");
	System.out.println("Troisième liste");
	Collections.reverse(liste);
	sousliste = liste.subList(0, 3);
	System.out.println(sousliste);
	
	System.out.println("\n");
	System.out.println("Quatrième liste");
	sousliste.add(3, "PINK");
	sousliste.add(4, "YELLOW");
	System.out.println(sousliste);
}
	}

	


