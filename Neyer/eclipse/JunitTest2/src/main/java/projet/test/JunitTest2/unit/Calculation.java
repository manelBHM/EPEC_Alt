package projet.test.JunitTest2.unit;

import java.util.ArrayList;

public class Calculation {
	public int square(int n) {

		n = n * n;

		return n;
	}

	public int cube(int n) {

		n = n * n * n;

		return n;
	}

	public StringBuffer reverse(String rever) {

		StringBuffer inv = (new StringBuffer(rever)).reverse();

		return inv;
	}

	public boolean checkIfPair(int number) {

		if(number % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean checkIfPairPairImpair(int number1, int number2, int number3) {

		if(checkIfPair(number1)==true&&checkIfPair(number2)==true&&checkIfPair(number3)==false) {
			return true;
		}else {
			return false;
		}
	}

	public  boolean checkIfSumIsPair(int number1, int number2, int number3) {

		int somme = number1+number2+number3;

		if(somme % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean checkIfAllElementsPair(int[] array) {

		boolean test = true;

		for(int i=0;i<array.length;i++) {
			boolean test1 = checkIfPair(array[i]);
			if(test1==false) {
				test=false;
			}
		}
		return test;
	}

	public ArrayList<Integer> exportAllElementsPair(int[] array) {

		ArrayList<Integer>paireList = new ArrayList<Integer>();

		for(int i=0;i<array.length;i++) {
			if(checkIfPair(array[i])==true) {
				paireList.add(array[i]);
			}
		}
		return paireList;
	}

	public ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {

		ArrayList<Integer>paireList = new ArrayList<Integer>();

		for(int i=0;i<array.length;i++) {

			boolean comparateur = true;//si c'est false on met pas

			/*for(int i = 0;i<array.length;i++){
			 * if(array[i] % 2 && !element.contains(array[i])){
			 * paireList.add(array[i]);
			 * }
			 * return paireList;
			 * }
			 * */

			if(checkIfPair(array[i])==true) {

				for(Integer ls : paireList) {

					if(array[i]==ls.intValue()){
						comparateur=false;
					}
				}
				if(comparateur==true) {
					paireList.add(array[i]);
				}
			}
		}
		return paireList;
	}

	public boolean checkSiTuPeuxAcheter(int prix) {
		// tu as 22 euros en monnaies de 2 euros, la machine ne rend pas de monnaie, check si tu peux payer

		if(prix<=22) {

			if(checkIfPair(prix)==true) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}