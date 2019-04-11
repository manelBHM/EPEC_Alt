package com.palindrom;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;

import org.junit.Test;


public class TestPalindrom {
	
	
	SuiteTU suiteTu = new SuiteTU();
	@Test
	public void isPalind()  {
		assertEquals(true, Palindrom.isPalindrome("kayak"));
		assertEquals(true, Palindrom.isPalindrome("laval"));
		
	}
	

	@Test
	public void result() {
		assertEquals(28, Calcul.square(4, 7));	
		assertEquals(28, Calcul.square(4, 7));
	}
	
	@Test
	public void testcheckIfPair() {
		assertEquals(false, SuiteTU.checkIfPair(1));
		assertEquals(true, SuiteTU.checkIfPair(2));
		
	}@Test
	public void testcheckIfPairPairImpair() {
		assertEquals(true, SuiteTU.checkIfPairPairImpair(2, 4, 7));
		assertEquals(false, SuiteTU.checkIfPairPairImpair(1, 2, 3));
	}@Test
	public void testcheckIfSumPair() {
		assertEquals(true, SuiteTU.checkIfSumIsPair(2, 4, 6));
		assertEquals(false, SuiteTU.checkIfSumIsPair(1, 1, 1));
		assertEquals(true, SuiteTU.checkIfSumIsPair(0, 0, 0));
	}@Test
	public void testcheckIfAllElementsPair() {
		int tab1[]= {2,4,6,8};
		int tab2[]= {1,3,5,7};
		int tab3[]= {0,0,0,0};
		assertEquals(true, SuiteTU.checkIfAllElementsPair(tab1));
		assertEquals(false, SuiteTU.checkIfAllElementsPair(tab2));
		assertEquals(true, SuiteTU.checkIfAllElementsPair(tab3));
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
		assertEquals(tab4, SuiteTU.exportAllElementsPair(testTab));
		assertEquals(emptyTab, SuiteTU.exportAllElementsPair(tab5));
		
		assertEquals(tab4, SuiteTU.exportAllUniqueElementsPair(testTab));
		assertEquals(emptyTab, SuiteTU.exportAllUniqueElementsPair(tab5));
		}
	}
	
