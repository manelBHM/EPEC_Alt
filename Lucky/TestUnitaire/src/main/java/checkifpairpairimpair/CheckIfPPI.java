package checkifpairpairimpair;

public class CheckIfPPI {

	public static boolean checkIfPairPairImpair(int number1, int number2, int number3) {

		boolean res = false;
		
		if(number1 % 2 == 0 & number2 % 2 == 0 & number3 % 2 != 0)

			res = true;
		else
			res = false;

		return res;
	}
}
