package exemple11;

public class Test {

	
	public static void main(String[]args) {
	int j=20;
			int i=0;{
	
	try {
		System.out.println(j/i);}
	catch(ArithmeticException e) {
		e.getMessage();}
	finally {
		System.out.println("Action faite systématiquement !");
	}
	}
	}
}