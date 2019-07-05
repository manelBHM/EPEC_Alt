
import java.util.Scanner;




public class Tableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Entrez une lettre.");
		Scanner clavier = new Scanner(System.in);
		char reponse = clavier.nextLine().charAt(0);

		int tableauEntier[] = {0,1,2,3,4,5};
		char tableauCaractere[] = {'a','e','i','o','u','y'};
		
		
			
			
			if(reponse=='a') {
				System.out.println("a est à l'indice 1.");
			}
			
			if(reponse=='e')
				System.out.println("e est à l'indice 2.");
			 
		
			 if (reponse == 'i')
				System.out.println("i est à l'indice 3.");
			
			if (reponse == 'o')
				System.out.println("o est à l'indice 4.");
			
		 if (reponse == 'u')
				System.out.println("u est à l'indice 5.");
			
			if (reponse =='y')
				System.out.println("y est à l'indice 6.");		
		
}


	}		
		
		
	


