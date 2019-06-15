package test;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import First.Test.Calculation;
import First.Test.Logic;
import junit.framework.TestCase;


public class Test extends TestCase{
	
	
	@BeforeClass
	public void onlyOnce() {
		System.out.println("OK");
	}
	

	@org.junit.Test
	public void testReverse() {

		// StringBuilder var=new StringBuilder("ruojnob");
		assertEquals("ruojnob er", Logic.reverse("re bonjour").toString());

	}

	@org.junit.Test
	public void testCube() {

		assertEquals(27, Calculation.cube(3));
	}

	@org.junit.Test
	public void testIsPair() {

		assertTrue(Calculation.isPair(2));
		assertFalse( Calculation.isPair(3));
		assertTrue( Calculation.isPair(-2));

	}

	@org.junit.Test
	public void testIsPairPairImpair() {

		assertFalse( Calculation.IsPairPairImpair(2, 3, 5));

	}
	@org.junit.Test
	public void testIsSumPair() {
		
		assertTrue(Calculation.IsSumPair(2, 2, 4));
		
	}
	@org.junit.Test
	public void testIfAllElementsPair() {
		
		assertFalse(Calculation.IfAllElementsPair(new int[] {1,2,3,4,5,6}));
		
	}
	

	@org.junit.Test
	public void testExportAllElementsPair() {
		
		ArrayList<Integer>list=new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		
		
		assertEquals(list, 
				Calculation.exportAllElementsPair(new int[] {1,2,3,4,5,6,7,8,9}));
		

	}
	
	
	@AfterClass
	public void logout() {
		System.out.println("OK");
	}

//	public void exportAllUniqueElementsPair() {
//		
//		
//		
//		
//	}

	
	
	
	
	
	
	
	
	
}