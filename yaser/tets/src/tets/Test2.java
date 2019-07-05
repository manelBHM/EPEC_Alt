package tets;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

   System.out.println("welcom to the bar of paris"+"\n"+"take your ticket online"+"\n");
   ArrayList<String> names = new ArrayList<>();
   ArrayList<Integer> ages = new ArrayList<>();
   
   System.out.println("how mane persons you are ?");
   Scanner sc = new Scanner(System.in);
   int persons = sc.nextInt();
   
   for (int i=0; i<persons; i++) {
	   System.out.println("enter the"+" "+(i+1)+" "+"name :");
	   names.add(sc.next());
	   System.out.println("enter the age :");
	   ages.add(sc.nextInt());
	   
   }
   sc.close();
   for(int i=0; i<persons; i++) {
	   if (ages.get(i)<18) {
		   System.out.println("sorry for"+" "+ names.get(i)+" "+"you are lase than 18 "+"\n");
		   
	   }
	   else {
		   System.out.println("hello "+names.get(i)+" "+" see you soon ");
	   }
   }
   
   
   
   
	}

}
