package First.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class Calculation {

	public static int square(int x) {

		int square = x * x;

		return square;
	}

	public static int cube(int x) {

		int cube = x * x * x;

		return cube;
	}

	public static boolean isPair(int x) {

		if (x % 2 == 0) {
			return true;
		}

		return false;

	}

	public static boolean IsPairPairImpair(int number1, int number2, int number3) {

		if (number1 % 2 == 0 && number2 % 2 == 0 && number3 % 2 != 0) {
			return true;
		}

		return false;

	}

	////////////////////////////////////////////////////////////////////////

	public static boolean IsSumPair(int number1, int number2, int number3) {

		if ((number1 + number2 + number3) % 2 == 0) {
			return true;
		}

		return false;
	}

	public static boolean IfAllElementsPair(int[] array) {

		for (int i = 0; i < array.length; i++) {

			if (i % 2 != 0) {

				return false;
			}
		}

		return true;
	}

	public static ArrayList<Integer> exportAllElementsPair(int[] array) {

		ArrayList<Integer> pairarray = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {

			if (array[i] % 2 == 0) {

				pairarray.add(array[i]);

			}
		}

		return pairarray;
	}

	public static ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {

		ArrayList<Integer> pairarray = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {

			if (array[i] % 2 == 0) {

				pairarray.add(array[i]);

			}
		}

		HashSet<Integer> set = new HashSet<Integer>(pairarray);
		ArrayList<Integer> pairarray2 = new ArrayList<Integer>(set);

		return pairarray2;
	}

	public static boolean checkSiTuPeuxAcheter(int prix) {
		// tu as 22 euros en monnaies de 2 euros, la machine ne rend pas de monnaie,
		// check si tu peux payer

		if (prix % 2 == 0 && prix <= 22) {

			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		System.out.println(IsSumPair(2, 2, 5));

		System.out.println(IfAllElementsPair(new int[] { 1, 2, 3, 4, 5, 6 }));

		System.out.println(exportAllElementsPair(new int[] { 1, 45, 3, 66, 76 }));

		System.out.println(exportAllUniqueElementsPair(new int[] { 1, 2, 3, 4, 6, 4, 4, 87, 86 }));

		System.out.println(checkSiTuPeuxAcheter(13));
	}

}