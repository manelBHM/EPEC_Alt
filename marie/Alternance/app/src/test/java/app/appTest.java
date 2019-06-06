package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class appTest {
	
	
	Calculation cal = new Calculation();
	
	int sq = 9 ;
	int cu = 27 ; 
	String mot1 = "ruojnob";
	String mot2 = "bonjour";
	Logic logi = new Logic();
	
	@Test
	public void test() {
		
		assertTrue("res",cal.square(3)== sq);
		 	
	}
	
	@Test
	public void test2() {
		
		assertTrue("res",cal.cube(3)== cu);
		 	
	}
	
	@Test
	   public void testReverseWord(){
		assertEquals(mot1, Logic.reverseWord(mot2).toString());
	   }
	
	@Test
   public void testcheckIfPair() {
        assertEquals(false, Part1.checkIfPair(1));
        assertEquals(true, Part1.checkIfPair(2));
    }@Test
   public void testcheckIfPairPairImpair() {
        assertEquals(true, Part1.checkIfPairPairImpair(2, 4, 7));
        assertEquals(false, Part1.checkIfPairPairImpair(1, 2, 3));
    }@Test
   public void testcheckIfSumPair() {
        assertEquals(true, Part1.checkIfSumIsPair(2, 4, 6));
        assertEquals(false, Part1.checkIfSumIsPair(1, 1, 1));
        assertEquals(true, Part1.checkIfSumIsPair(0, 0, 0));
    }@Test
   public void testcheckIfAllElementsPair() {
        int tab1[]= {2,4,6,8};
        int tab2[]= {1,3,5,7};
        int tab3[]= {0,0,0,0};
        assertEquals(true, Part1.checkIfAllElementsPair(tab1));
        assertEquals(false, Part1.checkIfAllElementsPair(tab2));
        assertEquals(true, Part1.checkIfAllElementsPair(tab3));
        }@Test
   public void testcheckIfAllElementUniquePair() {
            ArrayList<Integer>  tab4 = new ArrayList<Integer>();
            ArrayList<Integer>  emptyTab = new ArrayList<Integer>();
        tab4.add(2);
        tab4.add(4);
        tab4.add(6);
        tab4.add(8);
        int tab5[]= {1,3,5,7};
        int tab6[]= {0,0,0,0};
        int tab7[]= {4,4,4,4};
        int testTab[]= {1,2,3,4,5,6,7,8,9};
        assertEquals(tab4, Part1.exportAllElementsPair(testTab));
        assertEquals(emptyTab, Part1.exportAllElementsPair(tab5));
       
        }

}





