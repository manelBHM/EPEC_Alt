package checkifsumispair;

public class CheckIfSumIsPair {

	public static boolean checkIfSumIsPair(int number1, int number2, int number3)
	{

		boolean res = false;

		int n = number1 + number2 + number3;
		
		if(n % 2 == 0)
			
			res = true;
		else
			
			res = false;

		return res;

	}
}
