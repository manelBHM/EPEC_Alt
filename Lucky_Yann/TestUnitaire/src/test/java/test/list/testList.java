package test.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exportalleltspair.testListPair;

class testList {

	
	  testListPair test = new testListPair();
	@Test
	void testListe() {
		 
		
		int array[]= {3,4,6,6,8};
		List<Integer> list1 = new ArrayList<Integer>();
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(4);
		list1.add(6);
		list1.add(6);
		list1.add(8);

		
		assertEquals(list1, test.exportAllElementsPair(array));
	}
	
	@Test
	public void test2() {
		int array[]= {3,4,6,6,8};
		List<Integer> list1 = new ArrayList<Integer>();
		
		
		
		list1.add(4);
		list1.add(6);
		list1.add(8);
		
		assertEquals(list1, test.exportAllUniqueElementsPair(array));
	}

}
