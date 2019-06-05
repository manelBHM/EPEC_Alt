package NabilProjets.CalculateApp;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestClass {
	
	@BeforeClass
	public static void  setUpBeforeClass() throws Exception{
		System.out.println("Test before Class");
	}
	@Before
	public  void setUp() throws Exception{
		System.out.println("Test Beffore");

	}
	
	@After
	public  void tearDown() throws Exception{
		System.out.println("Test After");

	}
	
	@Test
	public  void TestCalcul() throws Exception{
		
		Calculate Calculate = new Calculate();
		assertEquals(4, Calculate.Squar(2));
		assertEquals(4, Calculate.Squar(-2));

		assertEquals(8, Calculate.Cube(2));
		assertEquals("NABIL", Calculate.reverseWord("NABIL"));
		
		part1 Chek = new part1();
		assertTrue(Chek.checkIfPair(6));
		assertTrue(Chek.checkIfSumIsPair(4,8,50));
		
		int tab[] = {2, 6, 10};
		assertTrue(Chek.checkIfAllElementsPair(tab));


	}	
}
