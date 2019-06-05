package tets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
	
	System.out.println("welcome to the game blackJack");
	System.out.println("how many persos are you ?");
	
	Scanner sc = new Scanner(System.in);
	int persons = sc.nextInt();
	
	List<String> names = new ArrayList<>();
	List<Integer> ages = new ArrayList<>();
	
	for(int i=0; i<persons; i++) {
		System.out.println("what the name of the"+" "+(i+1)+" "+"?");
		names.add(sc.next());
		System.out.println("and the age plz ");
		ages.add(sc.nextInt());
	}
for(int i=0; i<persons; i++) {
	if(ages.get(i)<18) {
		System.out.println("sorry for"+" "+names.get(i)+" "+"is -18");
	}
	else {
		System.out.println("hello"+" "+names.get(i)+" "+"be ready!");
	}
}
	}

}
