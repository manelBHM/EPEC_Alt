package calcul.sum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("hello");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSquare() {

		assertEquals(25, Calculation.square(5));

	}

	@Test
	public void testCube() {
		assertEquals(27, Calculation.cube(3));

	}

	@After
	public void tearDown() throws Exception {
	}

	@Before
	public void setUp1() throws Exception {
	}

	@Test
	public void testPair() {

		assertEquals(true, Calculation.checkIfPair(2));
		assertEquals(false, Calculation.checkIfPair(1));

	}

	@After
	public void tearDown1() throws Exception {
	}

	@Before
	public void setUp2() throws Exception {
	}

	@Test
	public void testPairP() {

		assertEquals(true, Calculation.checkIfPairPairImpair(2, 2, 1));

	}

	@After
	public void tearDown2() throws Exception {
	}

	@Before
	public void setUp3() throws Exception {
	}

	@Test
	public void testSumePair() {

		assertEquals(true, Calculation.checkIfSumIsPair(0, 1, 1));
		assertEquals(false, Calculation.checkIfSumIsPair(1, 1, 1));

	}

	@After
	public void tearDown3() throws Exception {
	}

	@Before
	public void setUp4() throws Exception {
	}

	@Test
	public void testSumeList() {

		int tab1[] = { 2, 4, 6, 8 };
		int tab2[] = { 1, 3, 5, 7 };

		assertEquals(true, Calculation.checkIfAllElementsPair(tab1));
		assertEquals(false, Calculation.checkIfAllElementsPair(tab2));

	}

	@After
	public void tearDown4() throws Exception {
	}

	@Before
	public void setUp5() throws Exception {
	}

	@Test
	public void testAllElement() {

		ArrayList<Integer> table4 = new ArrayList<Integer>();
		ArrayList<Integer> emptyTabl = new ArrayList<Integer>();

		table4.add(2);
		table4.add(4);
		table4.add(6);
		table4.add(8);
		int tab5[] = { 1, 3, 5, 7 };
		int tab6[] = { 0, 0, 0, 0 };
		int tab7[] = { 4, 4, 4, 4 };
		int testTab[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		assertEquals(table4, Calculation.exportAllElementsPair(testTab));
		assertEquals(emptyTabl, Calculation.exportAllElementsPair(tab5));

	}

	@After
	public void tearDown5() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("bey");
	}

}
