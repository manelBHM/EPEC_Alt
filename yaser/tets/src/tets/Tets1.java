package tets;

import java.util.ArrayList;
import java.util.Scanner;

public class Tets1 {

	public static void main(String[] args) {
		 
		System.out.println("hello how mane one insaid the calss");
		Scanner sc = new Scanner(System.in);
		int persons= sc.nextInt();
		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> ages = new ArrayList<>();
		
		for (int i=0; i<persons;i++) {
			System.out.println("what the name of the " +" "+ (i+1)+ " "+ "?");
			names.add(sc.next());
			System.out.println("what the age of the " +" "+ (i+1)+ " "+ "?");
			ages.add(sc.nextInt());
			
		}
		sc.close();
        
		for(int i=0; i<persons; i++) {
			System.out.println("hello "+" "+names.get(i)+" "+"and you have "+ " "+ ages.get(i));
		}
	}

}
