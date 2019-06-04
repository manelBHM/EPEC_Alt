package CLASS;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Exampel {
	public static boolean checkIfPair(int number) {

		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkCase2(int number1, int number2) {
		// check si une de 2 chiffres, ou leur somme se divise par 7
		
		 int sum = number1 + number2 ;
		 if ( number1 %7==0 || number2 %7==0 || sum %7 == 0 ) {
			 return true;
		
		 }
		 else {
				return false;
		 }
	}
	
	
	
	public static boolean checkCase2a(int number1, int number2) {
		// check si une de 2 chiffres mais pas leur somme se divise par 7
		
		int sume = number1 + number2;
		if(sume %7 !=0) {
			return true;
		}
		else {
		return false;
		}
	}
	
	
	public static boolean checkCase3(int number1, int number2, int number3) {
		// check si les trois chiffres sont dans l'ordre, soit croissant ou decroissant
		
		if(number1==1 && number2 ==2 && number3 ==3 || number1==3 && number2 ==2 && number3 ==1) {
			return true;
		}
		else {
		return false;
	}}
	
	
	
public static ArrayList<Integer> allElementsExceptFirstThree(int array[]) {
		ArrayList<Integer> al = new ArrayList<Integer> ();
		
		for (int i=3 ; i<array.length; i++) {
			
			al.add(array[i]);

		}
		return al;
		
	}


public static ArrayList<Integer> allElementsExceptFirstAndLast(int array[]) {
	
 ArrayList<Integer> ar = new  ArrayList<Integer>();
 
 for (int i=1; i<array.length -1; i++) {
	 ar.add(array[i]);
 }

	return ar;
}

public static ArrayList<Integer> allElementsWithIndexPair(int array[]) {
	ArrayList<Integer> un = new ArrayList<Integer>();
	
	

	
	for (int i=0; i<array.length; i++) {
		if (i%2==0) {
		un.add(array[i]);
		}
	}
	return un;
			
	
}

public static ArrayList<Integer> reverseOrder(int array[]) {
	
	ArrayList<Integer> or = new ArrayList<Integer>();
	for(int i=array.length-1; i>=0;  i--) {
     or.add(array[i]);
		
	}
	return or;
}

public static int[] reverseOrderInt(int array[]) {
	ArrayList<Integer> or = new ArrayList<Integer>();
	for(int i = array.length-1;i>=0; i--) {
		or.add(array[i]);
	}
	
	int[] tab = new int[array.length];
	for(int i=0;i<or.size();i++) {
		tab[i]=or.get(i);
		System.out.print(tab[i]);
	}
	return tab;
}

public static ArrayList<Integer> insertElementInTheMiddleOfAnArray(int array[], int element ) {
	ArrayList<Integer> t = new ArrayList<Integer>();
	
	 for ( element =0; element<array.length ; element++) {
	
			t.add(array[element]) ; 
	 }
	 t.add(t.size()/2,1);
  
	
	return t;
}

public static ArrayList<Integer> exportElementsWithIndexPair( ArrayList<Integer> list ) {
	ArrayList<Integer> ls = new ArrayList<Integer>();
	for(Integer l :list) {
		if (checkIfPair(list.indexOf(l.intValue()))) { // checkIfPair it's un methode up 
			ls.add(l.intValue());
		}
	}
	return ls;
}

public static boolean checkIfStringStartsWithA( String word ) {
	
	word ="Atoto";
	
	if (word.startsWith("A")) {
		return true;
	}
	else {
		return false;
	}
	
}

public static boolean checkIfStringStartsWithVowel( String word ) {
	
	word = "uoup";
	 String vowel ="aeiouy";
	 if(vowel.indexOf(Character.toLowerCase(word.charAt(0)))!=-1) {
		 return true ;
	 }
	 else {
		 return false;
	 }

}

public static boolean checkIfStringEndsWithS( String word ) {
	
	word = "persons";
	
	if(word.endsWith("s")) {
		return true ;
	}
	else {
		return false;
	}
	
}

public static String findShortestWord(String[] array ) {
	
  String word = array[0];
  for (int i=0; i<array.length; i++) {
	  String test = array[i];
	  if (test.length()<word.length()) {
		  return test;
	  }
	
		
  }
  
	  return word;
 

}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(checkCase2(10, 11));
        //System.out.println(checkCase2a(11, 12));

		
		
		/*
		 * int[] tabTest = {1,2,3,4,5};
		 * System.out.println(allElementsExceptFirstThree(tabTest));
		 * System.out.println(allElementsExceptFirstAndLast(tabTest));
		 * 
		 */
		
		/*
		 * int [] tab= {0,1,2,3,4,5,6};
		 * System.out.println(allElementsWithIndexPair(tab));
		 */
		
		/*
		 * int[] or = {1,2,3,4,5}; System.out.println(reverseOrder(or));
		 */
		
		/*int[] t = {1,2,3,4};
		System.out.println(reverseOrderInt(t));
	*/
		/*
		 * int [] my_array= {22,33,44,55,66,77,88,99};
		 * System.out.println("the orginal array " +Arrays.toString(my_array)); int
		 * newvalue = 0; System.out.println(
		 * insertElementInTheMiddleOfAnArray(my_array,newvalue));
		 */
		
	}
}
