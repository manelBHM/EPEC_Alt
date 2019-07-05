package First.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Part3 {

	public static ArrayList<Integer> allElementsExceptFirstThree(int array[]) {
		
		System.out.println("1");
		System.out.println("All except first three");

		ArrayList<Integer> array2 = new ArrayList<Integer>();

		for (int i = 3; i < array.length; i++) {

			array2.add(array[i]);
		}

		return array2;
	}

	public static ArrayList<Integer> allElementsExceptFirstAndLast(int array[]) {
		
		System.out.println("2");
		System.out.println("All except first and last");


		ArrayList<Integer> array2 = new ArrayList<Integer>();

		for (int i = 1; i < array.length - 1; i++) {

			array2.add(array[i]);
		}

		return array2;
	}

	
	public static int[] allElementsExceptFirstAndLastInt(int array[]) {
		
		System.out.println("3");
		System.out.println("All except first and last int");

		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[]array2=new int[array.length-2];

		for (int i = 1; i < array.length - 1; i++) {

			list.add(array[i]);
		}

		for (int i=0;i<list.size();i++) {
			
			array2[i]=list.get(i);
		}
		
		for(int i=0;i<list.size();i++) {
			
			System.out.print(list.get(i));
		}
		
		
		return array2;
	}

	public static ArrayList<Integer> allElementsWithIndexPair(int array[]) {
		
		System.out.println("4");
		System.out.println("All elements with index pair");


		ArrayList<Integer> array2 = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {

			if (i % 2 == 0) {

				array2.add(array[i]);
			}

		}

		return array2;
	}

	public static ArrayList<Integer> reverseOrder(int array[]) {
		
		System.out.println("5");
		System.out.println("Reverse order");


		ArrayList<Integer> array2 = new ArrayList<Integer>();

		for (int i = array.length - 1; i >= 0; i--) {

			array2.add(array[i]);
		}

		return array2;
	}

	public static int[] reverseOrderInt(int array[]) {
		
		System.out.println("6");
		System.out.println("Reverse order int");

		
		ArrayList<Integer>list=new ArrayList<Integer>();
		int array2[]=new int[array.length];
		
		for(int i=array.length-1;i>=0;i--) {
			
			list.add(array[i]);
		}
		for(int i=0;i<list.size();i++) {
			
			array2[i]=list.get(i);
		}
		
		

        for(int i=0;i<array2.length;i++) {
        	System.out.print(array2[i]);
        }
		return  array2;
	}

	public static ArrayList<Integer> insertElementInTheMiddleOfAnArray(int array[], int element) {

		System.out.println("7");
		System.out.println("Insert in the middle");

		
		ArrayList<Integer> array2 = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {

			array2.add(array[i]);
		}

		array2.add(array.length / 2, element);

		return array2;
	}

	public static ArrayList<Integer> exportElementsPair(ArrayList<Integer> list) {
		
		System.out.println("8");
		System.out.println("Export elements pair");


		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) % 2 == 0) {

				list2.add(list.get(i));
			}

		}

		return list2;
	}

	public static ArrayList<Integer> exportElementsWithIndexPair(ArrayList<Integer> list) {
		
		System.out.println("9");
		System.out.println("Export elements with index pair");


		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {

			if (i % 2 == 0) {

				list2.add(list.get(i));
			}

		}

		return list2;
	}

	public static int Addition(HashMap<String, Integer> addition) {
		
		System.out.println("10");
		System.out.println("Addition");

		
		int result=0;
		
		for(java.util.Map.Entry<String, Integer> e:addition.entrySet()) {
			
			result+=e.getValue();
			
		}
		
		
		return result;
	}

	public static boolean checkIfStringStartsWithA(String word) {
		
		System.out.println("11");
		System.out.println("Check if string starts with 'A'");
		
		word.toUpperCase();


		if (word.charAt(0) == 'A' ) {

			return true;
		}

		return false;
	}

	public static boolean checkIfStringStartsWithVowel(String word) {
		
		System.out.println("12");
		System.out.println("Check if string starts with voyel");

		word.toUpperCase();

		if (word.charAt(0) == 'a' || word.charAt(0) == 'e'
				||  word.charAt(0) == 'i' || word.charAt(0) == 'o'
				||  word.charAt(0) == 'u' || word.charAt(0) == 'y') {

			return true;
		}

		return false;
	}

	public static boolean checkIfStringEndsWithS(String word) {
		
		System.out.println("13");
		System.out.println("Check if string starts with 'S'");


		word = word.toUpperCase();

		if (word.charAt(word.length() - 1) == 'S') {

			return true;
		}

		return false;
	}

	public static String findShortestWord(String[] array) {
		
		System.out.println("14");
		System.out.println("Find shortest word");


		String shortest = array[0];

		for (int i = 0; i < array.length; i++) {

			if (array[i].length() < shortest.length()) {

				shortest = array[i];

			}

		}

		return shortest;
	}

	public static String swapFirstandLastLetter(String word) {
		
		System.out.println("15");
		System.out.println("Swap first and last letter");


		ArrayList<Character> list = new ArrayList<Character>();

		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);

		for (int i = 1; i < word.length() - 1; i++) {

			list.add(word.charAt(i));

		}

		list.add(0, last);
		list.add(first);

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {

			str.append(list.get(i));

		}

		return str.toString();
	}

	public static int[] swapFirstandLastElement(int[] array) {
		
		System.out.println("16");
		System.out.println("Swap first and last element");

		
		ArrayList<Integer> list = new ArrayList<Integer>();
        int[]array2=new int[array.length];
		
		int first = array[0];
		int last = array[array.length-1];

		for (int i = 1; i < array.length- 1; i++) {

		list.add(array[i]);

		}

		list.add(0, last);
		list.add(first);

		for (int i=0;i<list.size();i++) {
			
			array2[i]=list.get(i);
		}
		
        for(int i=0;i<array2.length;i++) {
        	System.out.print(array2[i]);
        }
		return array2;
	}

	public static boolean checkIfTriangleRectangle(int number1, int number2, int number3) {
		
		System.out.println("17");
		System.out.println("Check if triangle rectangle");

		
		if(number1*number1==number2*number2+number3*number3) {
			
			return true;
		}
		
	if(number2*number2==number1*number1+number3*number3) {
			
			return true;
		}
	
	if(number3*number3==number1*number1+number2*number2) {
		
		return true;
	}
	
		
		
		return false;
	}

	
	///////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		
		int [] tab=new int[] {1,2,3,4,5,6,7,8,9,10};
		String[] stringtab=new String[] {"chat","chien","oiseau","crocodile"};
		ArrayList<Integer>list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		String word="bonjour";
		
		
		System.out.println(allElementsExceptFirstThree(tab));
		
		System.out.println(allElementsExceptFirstAndLast(tab));
		
		System.out.println(allElementsExceptFirstAndLastInt(tab));

		System.out.println(allElementsWithIndexPair(tab));

		System.out.println(reverseOrder(tab));
		
		System.out.println(reverseOrderInt(tab));

		System.out.println(insertElementInTheMiddleOfAnArray(tab, 999));

		System.out.println(exportElementsPair(list));

		System.out.println(exportElementsWithIndexPair(list));
		
//		System.out.println(Addition(HashMap<String, Integer> addition));

		System.out.println(checkIfStringStartsWithA(word));
		
		System.out.println(checkIfStringStartsWithVowel(word));
		
		System.out.println(checkIfStringEndsWithS( word));
		
		System.out.println(findShortestWord(stringtab));

		System.out.println(swapFirstandLastLetter(word));
		
		System.out.println(swapFirstandLastElement(tab));
		
		System.out.println(checkIfTriangleRectangle(23,24,25));
	}

}
