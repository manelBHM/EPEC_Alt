package EPEC.FiizzBuzz;

import java.util.Scanner;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		FizzBuzz number = new FizzBuzz();
		
		String str = "";
		
		do {
			System.out.println("Entrez un nombre");
			
			int n = sc.nextInt();
			
			System.out.println(number.nmbrAleatoir(n));
			
		}while(str != "hello");
	}

}
