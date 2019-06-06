package projet.test.JunitFizzBuzz;

import java.util.Scanner;

public class afficheFizzBuzz {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		FizzBuzz fb = new FizzBuzz();
		
		String resultat;
		System.out.println("Entrer votre nombre : ");
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		//for(int i = 1 ; i<=test;i++) {
			
			System.out.print(fb.fizbuz(test));
		//}
	}	
}