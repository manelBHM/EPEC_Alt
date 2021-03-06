package test.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import EPEC.FiizzBuzz.FizzBuzz;
import junit.framework.TestCase;

import static org.junit.Assert.*;

public class TestFizBuz extends TestCase {


	@Test
	public void testApp() 
	{
		assertEquals("Fizz", FizzBuzz.nmbrAleatoir(9));
		assertEquals("Buzz", FizzBuzz.nmbrAleatoir(5));
		assertEquals("FizzBuzz", FizzBuzz.nmbrAleatoir(45));

		IllegalArgumentException thrown =
				assertThrows(IllegalArgumentException.class,
						() -> FizzBuzz.nmbrAleatoir(0),
						"Expected doThing() to throw, but it didn't"); 

		assertTrue(thrown.getMessage().contains("SHIPS"));

	}

//	@Test
//	void exceptionTesting() {
//		IllegalArgumentException thrown =
//				assertThrows(IllegalArgumentException.class,
//						() -> FizzBuzz.nmbrAleatoir(0),
//						"Expected doThing() to throw, but it didn't"); 
//
//		assertTrue(thrown.getMessage().contains("NOGOOD"));
//	}





}

