package exemple6;

import java.util.Scanner;

public class Help {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Bonjour à toi ! Je vois que tu as besoin d'aide...");
		System.out.println("Tu veux en savoir plus sur la structure de la condition IF ? Tape 1 !");
		System.out.println("Tu veux en savoir plus sur la structure de la condition switch ? Tape 2 !");
		System.out.println("Tu veux en savoir plus sur la structure de la boucle for ? Tape 3 !");
		System.out.println("Tu veux en savoir plus sur la structure de la boucle while ? Tape 4 !");
		System.out.println("Tu veux en savoir plus sur la structure de la boucle do while ? Tape 5 !");
		
		int choix =  clavier.nextInt();
		
		switch(choix) {
		
		case 1 :
			System.out.println("if (condition1){");
			System.out.println(" (instruction1;)");
			System.out.println(" (instruction2;)}");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("else if (condition2){");
			System.out.println(" (instruction3;)");
			System.out.println(" (instruction4;)}");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("else: ");
			System.out.println("instruction5;");
			break;
			
		case 2 :
			System.out.println("switch (mention){");
			System.out.println("case 1 (mention=excellent)");
			System.out.println(" liste des intructions;");
			System.out.println("   break;");
			System.out.println("    ");
			System.out.println("case 1 (mention=trés bien)");
			System.out.println(" liste des intructions;");
			System.out.println("   break;");
			System.out.println("  default :  ");
			System.out.println(" liste des intructions;}");
			break;
			
		case 3:
			System.out.println("for (compteur initialisé; compteur < nbr d'itération; compteur à incrémenter ou à décrémenter");
			System.out.println("{");
			System.out.println(" bloc instruction");
			System.out.println(" }");
		break;
			
		case 4:
			System.out.println("while (boolean");
			System.out.println("{");
			System.out.println(" code à exécuter");
			System.out.println(" }");
			 break;
			
		case 5:
			System.out.println("do {");
			System.out.println("instructions1;");
			System.out.println("instructions2");
			System.out.println(" }");
			System.out.println(" while (condition)");
			break;
			
			default:
				System.out.println("Je ne sais compter que de 1 à 5 ! Peux- tu reformuler ta demande ?");
<<<<<<< HEAD
		}
		
	}
	
}
=======
		
		
		}
	}
}

>>>>>>> 9731d8118d80b09b7d14eeaf403e7b8c423e4ae9
