package _TST.com;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Test {

	@BeforeClass
	public static void onlyOnce() throws Exception {
		System.out.println("OK");
	}
    
	@org.junit.Test
	public void testCalc() {
		// square
		
		assertEquals(4, Calculation.square(2));
		assertEquals(4, Calculation.square(-2));
		assertEquals(0, Calculation.square(0));
	}

	@org.junit.Test
	public void testCube() {
		// cube
		assertEquals(27, Calculation.cube(3));

	}

	@org.junit.Test
	public void testPair() {
		// ifPair
		assertEquals(true, Calculation.checkIfPair(2));
		assertEquals(true, Calculation.checkIfPair(-2));
		assertEquals(true, Calculation.checkIfPair(0));
		assertEquals(false, Calculation.checkIfPair(3));
		assertEquals(false, Calculation.checkIfPair(-3));
	}

	@org.junit.Test
	public void testSumIsPair() {
		assertEquals(false, Calculation.checkIfSumIsPair(2, 2, 3));
		assertEquals(true, Calculation.checkIfSumIsPair(2, 2, 4));
	}

	@org.junit.Test
	public void testPPI() {
		// if pair pair import
		assertEquals(true, Calculation.checkIfPairPairImpair(2, 2, 3));
		assertEquals(false, Calculation.checkIfPairPairImpair(3, 2, 3));
		assertEquals(false, Calculation.checkIfPairPairImpair(2, 3, 2));
	}

	@org.junit.Test
	public void testAllIsPair() {
		// if array is pair
		int tab[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int tab2[] = { 2, 2, 2, 2, 2, 2, 2, 8, 12 };

		assertEquals(false, Calculation.checkIfAllElementsPair(tab));
		assertEquals(true, Calculation.checkIfAllElementsPair(tab2));
	}

	@org.junit.Test
	public void testExpPair() {
		// export pair in array
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		test.add(2);
		test.add(2);
		test.add(2);
		int testTab[] = { 2, 3, 2, 5, 7, 9, 2, 2 };
		assertEquals(test, Calculation.exportAllElementsPair(testTab));

	}

	@org.junit.Test
	public void testExpUnique() {

		ArrayList<Integer> test2 = new ArrayList<Integer>();
		test2.add(2);
		test2.add(4);
		test2.add(6);
		test2.add(10);
		int testTab2[] = { 1, 3, 5, 9, 2, 4, 2, 9, 6, 13, 6, 10, 10 };
		assertEquals(test2, Calculation.exportAllUniqueElementsPair(testTab2));
	}
	
	@org.junit.Test
	public void testAchat() {
		assertEquals(true, Calculation.checkSiTuPeuxAcheter(22));
		assertEquals(false, Calculation.checkSiTuPeuxAcheter(17));
		assertEquals(false, Calculation.checkSiTuPeuxAcheter(32));
		assertEquals(false, Calculation.checkSiTuPeuxAcheter(-1));
		assertEquals(false, Calculation.checkSiTuPeuxAcheter(0));
	}
	

	@org.junit.Test
	public void testLogic() {
		assertEquals("azertyuiop", Logic.inverseString("poiuytreza"));
		assertEquals("azert yuiop", Logic.inverseString("poiuy treza"));
	}
	
	@org.junit.Test
	public void testCase1() {
		assertEquals(true, Calculation.checkCase1(100, 0));
		assertEquals(true, Calculation.checkCase1(0, 100));
		assertEquals(false, Calculation.checkCase1(110, 0));
	}
	
	@org.junit.Test
	public void testCase2() {
		assertEquals(true, Calculation.checkCase2(7, 9));
		assertEquals(true, Calculation.checkCase2(1, 21));
		assertEquals(true, Calculation.checkCase2(8, 14));
		assertEquals(false, Calculation.checkCase2(1, 2));
	}
	
	@org.junit.Test
	public void testCase2a() {
		assertEquals(false, Calculation.checkCase2a(1, 2));
		assertEquals(true, Calculation.checkCase2a(7, 2));
		assertEquals(true, Calculation.checkCase2a(1, 7));
		assertEquals(false, Calculation.checkCase2a(1, 13));
		assertEquals(false, Calculation.checkCase2a(7, 7));
		
	}
	
	@org.junit.Test
	public void testCase3() {
		assertEquals(true, Calculation.checkCase3(1, 2, 3));
		assertEquals(true, Calculation.checkCase3(3, 2, 1));
		assertEquals(false, Calculation.checkCase3(1, 2, 1));
		assertEquals(false, Calculation.checkCase3(9, 7, 9));
		assertEquals(false, Calculation.checkCase3(1, 1, 3));
		assertEquals(false, Calculation.checkCase3(2, 2, 2));
	}
	

	@AfterClass
	public static void logout() throws Exception {
		System.out.println("OKAY");
	}
}
