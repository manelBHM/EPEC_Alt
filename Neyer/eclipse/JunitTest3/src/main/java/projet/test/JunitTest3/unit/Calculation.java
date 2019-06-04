package projet.test.JunitTest3.unit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculation {

	public static int test = 2;

	public static boolean checkIfPair(int number) {

		if(number % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}

	public static int square(int n) {

		n = n * n;

		return n;
	}

	public static boolean checkIfTriangleRectangle(int number1, int number2, int number3) {

		if(square(number1)==(square(number2)+square(number3))||square(number2)==(square(number1)+square(number3))||square(number3)==(square(number1)+square(number2))) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean checkCase1(double prix, int pourcentDeRemise) {
		// t'as 100 euros, verifie si tu peux acheter l'article solde

		double remise= (pourcentDeRemise*(prix/100));
		double prixsolde = prix - remise;


		if(prixsolde<=100) {
			return true;
		}else {

			return false;
		}

	}

	public static boolean checkCase2(int number1, int number2) {
		// check si une de 2 chiffres, ou leur somme se divise par 7

		if(number1%7==0||number2%7==0||(number1+number2)%7==0)
		{
			return true;
		}else {
			return false;
		}
	}

	public static boolean checkCase2a(int number1, int number2) {
		// check si une de 2 chiffres mais pas leur somme se divise par 7

		if(number1%7==0||number2%7==0)
		{
			return true;
		}else {
			return false;
		}
	}

	public static boolean checkCase3(int number1, int number2, int number3) {
		// check si les trois chiffres sont dans l'ordre, soit croissant ou decroissant

		if(number1>number2&&number2>number3) {
			return true;
		}

		else if(number1<number2&&number2<number3) {
			return  true;
		}else {
			return false;
		}	
	}

	public static ArrayList<Integer> allElementsExceptFirstThree(int array[]) {

		ArrayList<Integer> listsans1e3 = new ArrayList<Integer>();

		for(int i = 1 ; i<array.length;i++) {

			if(i!=2) {
				listsans1e3.add(array[i]);
			}
		}

		return listsans1e3;
	}

	public static ArrayList<Integer> allElementsExceptFirstAndLast(int array[]) {

		ArrayList<Integer> listsans1elast = new ArrayList<Integer>();

		for(int i = 1 ; i<array.length;i++) {

			if(i!=(array.length-1)) {
				listsans1elast.add(array[i]);
			}
		}
		return listsans1elast;
	}

	public static int[] allElementsExceptFirstAndLastInt(int array[]) {

		int tab1[]= new int[array.length-2];

		for(int i = 1 ; i<array.length;i++) {

			if(i!=(array.length-1)) {
				tab1[i-1]=array[i];
			}
		}
		return tab1;
	}


	public static ArrayList<Integer> allElementsWithIndexPair(int array[]) {

		ArrayList<Integer> listTest = new ArrayList<Integer>();

		for(int i=0;i<array.length;i++) {

			if(checkIfPair(i)==true) {
				listTest.add(array[i]);
			}	
		}

		return listTest;
	}

	public static ArrayList<Integer> reverseOrder(int array[]) {

		ArrayList<Integer> listTest = new ArrayList<Integer>();

		for(int i = array.length-1; i>=0 ; i--) {

			listTest.add(array[i]);

		}
		return listTest;
	}

	public static int[] reverseOrderInt(int array[]) {

		int n = array.length;

		int [] rev;
		rev = new int [n];

		// On renverse le tableau
		for (int i=0; i<= n-1; i++)
			rev[i] = array[n-1-i];

		return rev;

	}

	public static ArrayList<Integer> insertElementInTheMiddleOfAnArray(int array[], int element ) {

		ArrayList<Integer> listTest = new ArrayList<Integer>();

		for(int i = 0 ; i < array.length ; i++) {
			listTest.add(array[i]);
		}

		int middle = array.length/2;

		listTest.add(middle,element);

		return listTest;
	}

	public static ArrayList<Integer> exportElementsPair( ArrayList<Integer> list ) {

		ArrayList<Integer> listTest = new ArrayList<Integer>();

		for(Integer ls : list) {

			if(checkIfPair(ls.intValue())==true) {

				listTest.add(ls.intValue());
			}
		}

		return listTest;
	}

	public static ArrayList<Integer> exportElementsWithIndexPair( ArrayList<Integer> list ) {

		ArrayList<Integer> listTest = new ArrayList<Integer>();

		for(Integer ls : list) {

			if(checkIfPair(list.indexOf(ls.intValue()))) {
				listTest.add(ls.intValue());
			}

		}
		return listTest;
	}

	public static int Addition( HashMap<String, Integer> addition ) {

		int somme = 0;
		for(Map.Entry mp : addition.entrySet()) {
			somme += (Integer) mp.getValue();
		}
		return somme;
	}

	public static boolean checkIfStringStartsWithA( String word ) {
		if(word.charAt(0)=='A') {
			return true;
		}
		return false;
	}

	public static boolean checkIfStringStartsWithVowel( String word ) {

		String word2 = word.toLowerCase();

		if(word2.charAt(0)=='a'||word2.charAt(0)=='e' ||word2.charAt(0)=='i'
				||word2.charAt(0)=='o'||word2.charAt(0)=='u'||word2.charAt(0)=='y') {
			return true;
		}

		return false;
	}

	public static boolean checkIfStringEndsWithS( String word ) {

		char charTab[]=word.toCharArray();

		if(charTab[charTab.length-1]=='s') {
			return true;
		}
		return false;
	}

	public static String findShortestWord(String[] array ) {

		String retour = array[0];
		
		for(int i = 0; i<array.length;i++) {
			String test = array[i];
			if(test.length()< retour.length()) {
				retour = test;
			}
		}
		return retour;
	}

	public static String swapFirstandLastLetter(String array ) {

		char[] charTab = array.toCharArray();

		char premMot = charTab[0];

		charTab[0]=charTab[charTab.length-1];
		charTab[charTab.length-1]=premMot;
		String motRetur = new String(charTab);
		return motRetur;
	}

	public static int[] swapFirstandLastElement(int[] array ) {

   		int premier = array[0];
		int dernier = array[array.length-1];
		
		int[] returTab = array;
		
		returTab[0]=dernier;
		returTab[returTab.length-1]=premier;
		
		return returTab;
	}
}
