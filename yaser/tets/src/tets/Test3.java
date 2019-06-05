package tets;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		System.out.println("welcome to the game blackJack"+"\n");
	 System.out.println("how many persos they want t play blackjack ?");

	 Scanner sc = new Scanner(System.in);
	 ArrayList<String> names = new ArrayList<>();
	 ArrayList<Integer> ages = new ArrayList<>();
	 
	 int persons = sc.nextInt();
	 
	 for ( int i=0; i<persons; i++) {
		 System.out.println("enter the "+" "+(i+1)+" "+" player");
		 names.add(sc.next());
		 System.out.println("and the age ?");
		 ages.add(sc.nextInt());
	 }
	 sc.close();
	 
	 for (int i=0;i<persons;i++) {
		 if(ages.get(i)<18) {
			 System.out.println("sorry for the player "+" "+names.get(i)+" "+"you can't play if you are under than 18 yers");
		 }
		 else {
			 System.out.println("hello"+" "+names.get(i)+" "+"be ready to start" );
		 }
		 
	 }
	 

	}

}
