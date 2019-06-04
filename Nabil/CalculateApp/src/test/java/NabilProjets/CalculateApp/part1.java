package NabilProjets.CalculateApp;

import java.util.ArrayList;

public class part1 {
	public static boolean checkIfPair(int number) {
		
		if (number%2 == 0) {
			return true;
		}
		else return false;
	}
	
	public static boolean checkIfPairPairImpair(int number1, int number2, int number3) {
		return false;
	}
	public static boolean checkIfSumIsPair(int number1, int number2, int number3) {
		
		int sum = number1 + number2 + number3;
		
		if (sum%2 == 0) {
			return true ;
		}
		
		else return false;
	}
	
	public static boolean checkIfAllElementsPair(int[] array) {
		
		
		for (int i = 0; i < array.length; i++) {
			
			if ( array[i]%2 == 0) {
				return true ;
			}
			else return false;
		}

		return false;
		
	}
	
	public static ArrayList<Integer> exportAllElementsPair(int[] array) {
		return null;
	}
	public static ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {
		return null;
	}
	
	
	public static boolean checkSiTuPeuxAcheter(int prix) {
		// tu as 22 euros en monnaies de 2 euros, la machine ne rend pas de monnaie, check si tu peux payer
		return false;
	}
}
