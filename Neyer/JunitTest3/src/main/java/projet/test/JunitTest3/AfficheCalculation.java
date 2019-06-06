package projet.test.JunitTest3;

import java.util.ArrayList;
import java.util.HashMap;

import projet.test.JunitTest3.unit.Calculation;

public class AfficheCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> listTest = new ArrayList<Integer>();
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(4);
		listTest.add(5);
		listTest.add(6);
		listTest.add(7);
		
		HashMap<String, Integer> mapTest= new HashMap<String, Integer>();
		mapTest.put("A",1);
		mapTest.put("B",2);
		mapTest.put("C",3);
		mapTest.put("D",4);
		mapTest.put("E",5);
		mapTest.put("F",6);
		mapTest.put("G",7);
		
		int tabTest[]= {0,2,3,4,5,6,7,8,9,2};
		int tabTest2[] = Calculation.swapFirstandLastElement(tabTest);
		String test = "monan";
		
		for(int i = 0 ; i<tabTest.length;i++) {
			System.out.print(tabTest2[i]);
		}
		
		//System.out.println(Calculation.swapFirstandLastElement(tabTest));	
	}
}
