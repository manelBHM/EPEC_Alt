import java.util.ArrayList;
import java.util.ListIterator;
public class EtudiantsArrays {

	
	

	public static void main(String[] args) {
		ArrayList<String> etudiants =new ArrayList<String>();
		etudiants.add("François");
		etudiants.add("Jean");
		etudiants.add("Phil");
		etudiants.add("Rob");
		etudiants.add("Raf");
		System.out.println(etudiants);
		
		etudiants.remove("François");
		etudiants.remove("Raf");
		System.out.println(etudiants);
		
		etudiants.remove(2);
		System.out.println(etudiants);
		
		ListIterator<String> litr = etudiants.listIterator();
		System.out.println(etudiants);
		
	}

}
