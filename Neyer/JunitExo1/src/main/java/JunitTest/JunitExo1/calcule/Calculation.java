package JunitTest.JunitExo1.calcule;

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
}
