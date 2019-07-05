package App1;

import java.util.Scanner;

public class testEtudiant {

	
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Saisissez le nom de l'étudiant au travail: ");
		String name1= saisie.nextLine();
		System.out.println("Saisissez le nom de l'étudiant au repos: ");
		String name2=saisie.nextLine();
		Etudiant etudiant1 = new Etudiant (name1);
		Etudiant etudiant2 = new Etudiant (name2);
		etudiant1.travailler();
		etudiant2.seReposer();
	}

}
