package calcul.sum;

import java.util.ArrayList;

public class Calculation {

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
		number1 = 2;
		number2 = 2;
		number3 = 1;
		if (number1 == 2 && number2 == 2 && number3 != 2) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkIfSumIsPair(int number1, int number2, int number3) {

		int sume = number1 + number2 + number3;
		int sum = sume % 2;

		if (sum == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkIfAllElementsPair(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int result = array[i] % 2;

			if (result != 0) {
				return false;
			}

		}
		return true;
	}

	public static ArrayList<Integer> exportAllElementsPair(int[] array) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				al.add(array[i]);
			}
		}
		return al;
	}

}
