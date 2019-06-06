package projet.test.JunitTest3.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationTest {
	
	boolean vrai = true;
	boolean faux = false;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@DisplayName("Le triangle est il carré ")
	@Test
	void testTriangleCarre() {
		
		Assertions.assertEquals(true, Calculation.checkIfTriangleRectangle(5,3,4));
		Assertions.assertEquals(false, Calculation.checkIfTriangleRectangle(1,3,4));
	}
	
	@DisplayName("J'ai 100€ je peux acheter ")
	@Test
	void testCase1() {
		
		Assertions.assertEquals(true, Calculation.checkCase1(100, 10));
		Assertions.assertEquals(false, Calculation.checkCase1(200, 49));
	}
	
	@DisplayName("divisible par 7 ou la somme ")
	@Test
	void testCase2() {
		
		Assertions.assertEquals(true, Calculation.checkCase2(14, 44));
		Assertions.assertEquals(false, Calculation.checkCase2(13, 10));
		Assertions.assertEquals(true, Calculation.checkCase2(10, 4));
		
	}
	
	@DisplayName("divisible par 7")
	@Test
	void testCase2a() {
		
		Assertions.assertEquals(true, Calculation.checkCase2a(14, 44));
		Assertions.assertEquals(false, Calculation.checkCase2a(13, 10));
		Assertions.assertEquals(false, Calculation.checkCase2a(10, 4));
		
	}
	
	@DisplayName("croissant ou decroissant")
	@Test
	void testCroissanDecroissant() {
		
		Assertions.assertEquals(true, Calculation.checkCase3(1, 2, 3));
		Assertions.assertEquals(true, Calculation.checkCase3(3, 2, 1));
		Assertions.assertEquals(false, Calculation.checkCase3(1, 3, 2));
		
	}
	
	@DisplayName("list sans 1er et 3eme")
	@Test
	void testListsans1et3() {
		
		int test[]= {1,2,3,4,5};
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(2);
		testList.add(4);
		testList.add(5);
		Assertions.assertEquals(testList, Calculation.allElementsExceptFirstThree(test));
		
	}
	
	@DisplayName("list sans 1er et dernier")
	@Test
	void testListsans1etlast() {
		
		int test[]= {1,2,3,4,5};
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(2);
		testList.add(3);
		testList.add(4);
		Assertions.assertEquals(testList, Calculation.allElementsExceptFirstAndLast(test));
		
	}
	
	@DisplayName("tableau sans 1er et dernier")
	@Test
	void testTableausans1etlast() {
		
		int test[]= {1,2,3,4,5};
		
		int tabTest[]= {2,3,4};
		
		Assertions.assertArrayEquals(tabTest, Calculation.allElementsExceptFirstAndLastInt(test));	
	}
	
	@DisplayName("tableau avec index paire")
	@Test
	void testListsIndexPaire() {
		
		int test[]= {1,2,3,4,5};
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(1);
		testList.add(3);
		testList.add(5);
		Assertions.assertEquals(testList, Calculation.allElementsWithIndexPair(test));	
	}
	
	@DisplayName("tableau avec index paire")
	@Test
	void testListsReverse() {
		
		int test[]= {1,2,3,4,5};
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(5);
		testList.add(4);
		testList.add(3);
		testList.add(2);
		testList.add(1);
		Assertions.assertEquals(testList, Calculation.reverseOrder(test));	
	}
	
	@DisplayName("tableau inversé")
	@Test
	void testTabReverse() {
		
		int test[]= {1,2,3,4,5};
		int test2[]= {5,4,3,2,1};
		
		Assertions.assertArrayEquals(test2, Calculation.reverseOrderInt(test));
	}
	
	@DisplayName("ajout une valeur milieu list")
	@Test
	void testinsertElementInTheMiddle() {
		
		int test[]= {1,2,3,4,5};
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(1);
		testList.add(2);
		testList.add(22);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		Assertions.assertEquals(testList, Calculation.insertElementInTheMiddleOfAnArray(test, 22));	
	}
	
	@DisplayName("list de paire d'une list")
	@Test
	void testexportElementsPair() {
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		
		ArrayList<Integer> testList2 = new ArrayList<Integer>();	
		testList2.add(2);
		testList2.add(4);
		testList2.add(6);
		
		Assertions.assertEquals(testList2, Calculation.exportElementsPair(testList));	
	}
	
	@DisplayName("list avec index paire d'une list")
	@Test
	void testExportElementsWithIndexPair() {
		ArrayList<Integer> testList = new ArrayList<Integer>();	
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		
		ArrayList<Integer> testList2 = new ArrayList<Integer>();	
		testList2.add(1);
		testList2.add(3);
		testList2.add(5);
		
		Assertions.assertEquals(testList2, Calculation.exportElementsWithIndexPair(testList));	
	}
	
	
	@DisplayName("addition d'une map")
	@Test
	void testAddition() {
		
		int test=13;
		HashMap<String, Integer> mapTest = new HashMap<String, Integer>();

		mapTest.put("A", 1);
		mapTest.put("B", 2);
		mapTest.put("C", 10);
		
		Assertions.assertEquals(test, Calculation.Addition(mapTest));	
	}
	
	@DisplayName("mot commence par A")
	@Test
	void testCheckIfStringStartsWithA() {
		
		String test="Monkey";
		String test2="AMonkey";

		Assertions.assertEquals(false, Calculation.checkIfStringStartsWithA(test));	
		Assertions.assertEquals(true, Calculation.checkIfStringStartsWithA(test2));	

	}
	
	@DisplayName("mot commence par voyelle")
	@Test
	void testCheckIfStringStartsWithVowel() {
		
		String test="Monkey";
		String test2="AMonkey";

		Assertions.assertEquals(false, Calculation.checkIfStringStartsWithVowel(test));	
		Assertions.assertEquals(true, Calculation.checkIfStringStartsWithVowel(test2));	

	}
	
	@DisplayName("mot qui finit pas s")
	@Test
	void testCheckIfStringEndsWithS() {
		
		String test="Monkey";
		String test2="AMonkeys";

		Assertions.assertEquals(false, Calculation.checkIfStringEndsWithS(test));	
		Assertions.assertEquals(true, Calculation.checkIfStringEndsWithS(test2));	

	}
	
	@DisplayName("inverser premiere et derniere lettre")
	@Test
	void testSwapFirstandLastLetter() {
		
		String test="Monkey";
		String test2="yonkeM";

		Assertions.assertEquals(test2, Calculation.swapFirstandLastLetter(test));	

	}
	
	@DisplayName("inverser premier derniere chiffre tableau")
	@Test
	void testSwapFirstandLastElement() {
		
		int test[]= {1,2,3,4,5};
		int test2[]= {5,2,3,4,1};
		
		Assertions.assertArrayEquals(test2, Calculation.swapFirstandLastElement(test));	
	}
	
	@DisplayName("le plus petit mot d'un tableau")
	@Test
	void testIndShortestWord() {
		
		String test[]= {"cafe", "coca", "e", "lait","the"};
		String testS = "e";
		
		Assertions.assertEquals(testS, Calculation.findShortestWord(test));	
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
