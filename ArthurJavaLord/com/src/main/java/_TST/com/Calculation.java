package _TST.com;

import java.util.ArrayList;

public class Calculation {

//	public Calculation(){
//		
//	}

	public static int square(int x) {
		return x * x;
	}

	public static int cube(int x) {
		return x * x * x;
	}

	public static boolean checkIfPair(int number) {
		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkIfPairPairImpair(int number1, int number2, int number3) {
		if (number1 % 2 == 0) {
			if (number2 % 2 == 0) {
				if (number3 % 2 != 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean checkIfSumIsPair(int number1, int number2, int number3) {
		int sum = number1 + number2 + number3;
		if (sum % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkIfAllElementsPair(int[] array) {
		boolean reponse = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				reponse = true;
			} else {
				reponse = false;
			}
		}
		return reponse;

	}

	public static ArrayList<Integer> exportAllElementsPair(int[] array) {
		ArrayList<Integer> tab = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				tab.add(array[i]);
			}
		}

		return tab;
	}

	public static ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {
		ArrayList<Integer> tab = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0 && !tab.contains(array[i])) {

				tab.add(array[i]);
			}
		}

		return tab;

	}

	public static boolean checkSiTuPeuxAcheter(int prix) {

		if (prix % 2 == 0 && (prix <= 22 && prix > 0)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase1(double prix, int pourcentDeRemise) {
		// t'as 100 euros, vérifie si tu peux acheter l'article solde
		if (100 >= prix * ((100 - pourcentDeRemise) / 100)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean checkCase2(int number1, int number2) {
		// check si un des 2 chiffres, ou leur somme se divise par 7
		if ((number1 % 7 == 0 || number2 % 7 == 0) || ((number1 + number2) % 7 == 0)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase2a(int number1, int number2) {
		// check si un des 2 chiffres mais pas leur somme se divise par 7

		if ((number1 % 7 == 0 || number2 % 7 == 0) && ((number1 + number2) % 7 != 0)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkCase3(int number1, int number2, int number3) {
		// check si les trois chiffres sont dans l'ordre, soit croissant ou décroissant
		if (number1 < number2 && number2 < number3) {
			return true;
		} else if (number1 > number2 && number2 > number3) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		int testTab2[] = { 1, 3, 5, 9, 2, 4, 2, 9, 6, 13, 6, 10, 10 };

		System.out.println(exportAllUniqueElementsPair(testTab2));

	}
}
