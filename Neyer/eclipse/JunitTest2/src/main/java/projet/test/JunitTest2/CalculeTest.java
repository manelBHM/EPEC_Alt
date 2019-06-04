package projet.test.JunitTest2;

import java.util.ArrayList;

import projet.test.JunitTest2.unit.*;

public class CalculeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 3;
		int prix = 18;
		String mot = "bonjour monde";
		int[] tabTest = {1,2,3,4,4,5,1,8,10,2,4,12,12};
		ArrayList<Integer>listTest = new ArrayList<Integer>();
		ArrayList<Integer>listTest2 = new ArrayList<Integer>();
		
		Calculation c = new Calculation();

		int square = c.square(a);
		int cube = c.cube(a);
		StringBuffer tom = c.reverse(mot);
		listTest=c.exportAllElementsPair(tabTest);
        listTest2 = c.exportAllUniqueElementsPair(tabTest);
		
		System.out.println("Le carré de "+a+" est "+square+" et son cube est "+cube);
		System.out.println("L'inverse de "+mot+" est "+tom);
		System.out.println ("liste de paire :"+listTest);
		System.out.println ("liste de paire sans double :"+listTest2);
		System.out.println("J'ai 22€ en 2€ et je veux acheter un article à "+prix+", j'ai la somme exacte : "+c.checkSiTuPeuxAcheter(prix));
	}
}