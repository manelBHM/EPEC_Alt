package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domains.Person;

public class Main {
	
	/**
	 * @param a
	 * @param b
	 * exercice 1 : Chaque élément a pour valeur le produit du numéro de sa ligne et du numéro de sa colonne.
	 */
	public static void calculateMatrice(int a, int b) {
		int matrice [][] = new int [a][b];
		
		for (int lign = 0; lign < matrice.length; lign++) {
			for (int col = 0; col < matrice[lign].length; col++) {
				matrice[lign][col] = (lign + 1) * (col + 1);
				System.out.print(matrice[lign][col] + "     ");
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * @param path
	 * @throws IOException
	 * exercice 2 : Cette méthode lis, et sysout le fichier que vous lui donnez en paramètre.
	 */
	public static void getStringFromFile(String path) throws IOException {
		FileReader fr = new FileReader(path);
		int i;
		
		while ((i = fr.read()) != -1)System.out.print((char)i);
		fr.close();
		System.out.print("\n\n");
	}
	
	/**
	 * @param tab
	 * exercice 3 : Cette méthode récupère un tableau de personne, et retourne une List trié par Age puis une List triée par Name
	 */
	public static void trierParAgePuisParName(Person [] tab) {
		ArrayList<Person> pers = new ArrayList<Person>();
		
		for (int i = 0; i < tab.length; i ++) {
			pers.add(tab[i]);
		}
		
		Collections.sort(pers, Person.ageComparator);
		System.out.print(pers + "\n");
		pers.sort(Comparator.comparing(Person::getName));
		System.out.println(pers);
		
	}
	
	
	/**
	 * @param string
	 * @return
	 * exercice 4 : Cette méthode vérifie si un String est un palindrome.
	 */
	public static Boolean isPalindrome(String string) {
		StringBuilder sb = new StringBuilder();
		sb.append(string);
		StringBuilder testReverse = sb.reverse();
		if (sb.equals(testReverse)) {
			System.out.println("Oui '" + string + "' est un palindrome.");
			return true;
		}
		System.out.println("Non '" + string + "' n'est pas un palindrome.");
		return false;
	}

	public static void main(String[] args) {
		
		Person Keke = new Person("Kevin", 27);
		Person Tutur = new Person("Arthur", 28);
		Person Neyer = new Person("Neyer", 24);
		Person tabb [] = {Keke, Tutur, Neyer};
		
		calculateMatrice(12,12);
		
		try {
			getStringFromFile("C:\\Users\\k.maslowski\\Desktop\\readandsysout.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		trierParAgePuisParName(tabb);
		
		isPalindrome("Red rum, sir, is murder");
		isPalindrome("Step on no pets");
		
	}

}
