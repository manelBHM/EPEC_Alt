package app.CALCOULATION;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CLASS.Exampel;

class TestApp {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
	assertTrue( Exampel.checkCase2(14,11));
	}
	@Test
	void test2() {
	assertTrue( Exampel.checkCase2a(12,11));
	}
	
	@Test
	void test3() {
	assertTrue( Exampel.checkCase3(3,2,1));
	}
	
	@Test
	void test4() {
		ArrayList<Integer> tabTest2 = new ArrayList<Integer>();
		tabTest2.add(4);
		tabTest2.add(5);
		tabTest2.add(6);
		int[] taTest1 = {1,2,3,4,5,6};
		
	assertEquals(tabTest2, Exampel.allElementsExceptFirstThree(taTest1));
	}
	
	@Test
	void test5() {
		ArrayList<Integer> ta= new ArrayList<Integer>();
		ta.add(2);
		ta.add(3);
		ta.add(4);
		int[] tab = {1,2,3,4,5};
		assertEquals(ta, Exampel.allElementsExceptFirstAndLast(tab));
		
	}
	
	@Test
	void test6() {
		ArrayList<Integer> un = new ArrayList<Integer>();
		un.add(0);
		un.add(2);
		un.add(4);
		un.add(6); 
		int[] tab = {0,1,2,3,4,5,6};
		
		assertEquals(un, Exampel.allElementsWithIndexPair(tab));
	}
	
	@Test
	void test7() {
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add(4);
		t.add(3);
		t.add(2);
		t.add(1);
		int[] tab = {1,2,3,4};
		
		assertEquals(t,Exampel.reverseOrder(tab));
	}

	
	
	@Test
	void test8() {
		ArrayList<Integer> tl = new ArrayList<Integer>();
		int [] array= {22,33,44,55,66,77,88,99};
		int  newvalue = 1;
	
		tl.add(22);
		tl.add(33);
		tl.add(44);
		tl.add(55);
		tl.add(1);
		tl.add(66);
		tl.add(77);
		tl.add(88);
		tl.add(99);
		assertEquals(tl,Exampel.insertElementInTheMiddleOfAnArray(array,newvalue));
	}
	
	@Test
	void test9() {
		ArrayList<Integer> tl = new ArrayList<Integer>();
        tl.add(1);
        tl.add(2);
        tl.add(3);
        tl.add(4);
        tl.add(5);
        tl.add(6);
        tl.add(7);
        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t2.add(1);
        t2.add(3);
        t2.add(5);
        t2.add(7);
		assertEquals(t2,Exampel.exportElementsWithIndexPair(tl));
	}
	
	@Test
	void test10() {
	assertTrue( Exampel.checkIfStringStartsWithA(""));
	}
	
	@Test
	void test11() {
	assertTrue( Exampel.checkIfStringStartsWithVowel(""));
	}
	
	@Test
	void test12() {
	assertTrue( Exampel.checkIfStringEndsWithS(""));
	}
	
	@Test
	void test13() {
		String [] numWord = {"a","aa","aaa","aaaa"};
	    String  words ="a";
	    assertEquals(words, Exampel.findShortestWord(numWord));
	}
	
	
	
}
