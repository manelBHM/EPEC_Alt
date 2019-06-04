package Test.fizz_buzz;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Fizz_Buzz {
	private int number = 100;
	
	public void fizzBuzz() throws InterruptedException {
		System.out.println("        |********************|");
		
		System.out.println("        |****  FizzBuzz  ****|\n "
				
				+ "       |********************|\n"
				+ "  *** Game is starting in 6 sec ***"
				+ "\n_____________________________________\n" 
				+ "   \nRules : \n \n" 
				+ " f + Enter At dividable by 3 for Fizz, \n "
				+ "b + Enter At dividable by 5 for Buzz, \n"
				+ " fb  + Enter At diviable by 3 and 5. \n"
				+ " Game is starting now... good luck. \n");
		Thread.sleep(6000);
		Scanner sc = new Scanner(System.in);
		String input;
		boolean bol = true;
		while(bol == true){
			for(int i = 1; i < number; i++) {
				Thread.sleep(1000);
				System.out.println(i);
				if(i % 3 == 0 && i % 5 == 0) {
					long startTime = System.currentTimeMillis();
					System.out.println("Enter fizz/buzz/fizzBuzz");
					input = sc.nextLine();
					long endTime = System.currentTimeMillis();
					long t =  (endTime - startTime);
					long timeTaken = t / 1000;
					if(timeTaken < 4 && input.equals("fb")) {
						System.out.println("Good");
						System.out.println("Time taken : "+ timeTaken);
					} else if(timeTaken >= 4) {
						System.out.println("bad timing");
						number = 0;
						bol = false;
						System.out.println("Time taken : "+ timeTaken + " Sec." + "\nYou have"
								+ " taken too much time!!! You lost. \nBetter luck next time.");
					} else if(input.isEmpty()) {
						System.out.println("You have entered space. \n"
								+ "Game is over, restart please.");
						number = 0;
						bol = false;
					} else {
						number = 0;
						bol = false;
						System.out.println("You didn't follow the rules!Restart");
					}
				} else if(i % 5 == 0) {
					long startTime = System.currentTimeMillis();
					System.out.println("Enter fizz/buzz/fizzBuzz");
					input = sc.nextLine();
					long endTime = System.currentTimeMillis();
					long t =  (endTime - startTime);
					long timeTaken = t / 1000;
					if(timeTaken < 4 && input.equals("b")) {
						System.out.println("Good");
						System.out.println("Time taken : "+ timeTaken + " Sec");
					} else if(timeTaken >= 4) {
						System.out.println("bad timing");
						number = 0;
						bol = false;
						System.out.println("Time taken : "+ timeTaken + " Sec." + "\nYou have"
								+ " taken too much time!!!You lost. \nBetter luck next time.");
					} else if(input.isEmpty()) {
						System.out.println("You have entered space. \n"
								+ "Game is over, restart please.");
						number = 0;
						bol = false;
					} else {
						number = 0;
						bol = false;
						System.out.println("You didn't follow the rules!Restart");
					}
				} else if (i % 3 == 0) {
					long startTime = System.currentTimeMillis();
					System.out.println("Enter fizz/buzz/fizzBuzz");
					input = sc.nextLine();
					long endTime = System.currentTimeMillis();
					long t =  (endTime - startTime);
					long timeTaken = t / 1000;
					if(timeTaken < 4 && input.equals("f")) {
						System.out.println("Good");
						System.out.println("Time taken : "+ timeTaken + " Sec");
					} else if(input.isEmpty()) {
						System.out.println("You have entered space. \n"
								+ "Game is over, restart please.");
						number = 0;
						bol = false;
					} else if(timeTaken >= 4) {
						System.out.println("bad timing");
						number = 0;
						bol = false;
						System.out.println("Time taken : "+ timeTaken + " Sec." + "\nYou have"
								+ " taken too much time!!! You lost. \nBetter luck next time.");
					} else {
						number = 0;
						bol = false;
						System.out.println("You didn't follow the rules!Restart");
					}
				}
			}
		}
		sc.close();
		System.out.println("****** Game Over!!! ******");
		
	}
	
	
}
