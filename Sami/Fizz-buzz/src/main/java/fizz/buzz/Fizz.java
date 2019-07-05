package fizz.buzz;

public class Fizz extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String fizz(int number) throws IllegalArgumentException{

		String result = "" + number;
		
		if(number<0) { throw new IllegalArgumentException(); }

		if (number % 15 == 0) {
			result = "fizz-buzz";

		}

		else if (number % 5 == 0) {
			result = "buzz";
		}

		else if (number % 3 == 0) {
			result = "fizz";
		}

		return result;

	}

	public static void foor() {

		for (int i = 1; i <= 100; i++) {

			System.out.println(fizz(i));

		}
	}

	public static void main(String[] args) {

//		System.out.println(fizz(69));
//		System.out.println(fizz(37));
//		System.out.println(fizz(60));
//        
		foor();
	}

}
