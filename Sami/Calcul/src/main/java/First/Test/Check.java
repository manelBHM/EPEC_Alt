package First.Test;

public class Check {

	public static boolean checkCase1(double prix, int pourcentRemise) {
		// tu as 100 euros verifie si peux acheter
		double apresremise = prix - ((prix / 100) * pourcentRemise);

		if (apresremise <= 100) {
			return true;
		}

		return false;
	}

	public static boolean checkCase2(int number1, int number2) {
		// si un des deux ou leur somme se divise par 7
		
		if (number1 % 7==0 ||        number2 % 7 == 0 ||           (number1+number2) % 7 == 0) {
			return true;
		}
		
		return false;
	}

	public static boolean checkCase2a(int number1, int number2) {
		// si un des deux mais pas leur somme se divise 7
		
		if((number1 % 7 == 0 || number2 % 7 ==0) && (number1 + number2) %7 !=0) {
			return true;
		}
		
		return false;
	}

	public static boolean checkCase3(int number1, int number2, int number3) {
		// si les trois sont dans un ordre
		
		
		
		return false;
	}

	public static void main(String[] args) {

		System.out.println(checkCase1(99999, 1));
		System.out.println(checkCase2(8, 6));
        System.out.println(checkCase2a(7, 87));
        System.out.println(checkCase3(6, 12, 43));

	}

}
