package projet.test.JunitFizzBuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class testFizzBuzz {

	FizzBuzz fb = new FizzBuzz();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

//	@Test
//	public void testCube() {
//		
//		System.out.println("test le cube!");
//		assertEquals(27,calculation.cube(3));
//	}
	
	@DisplayName("Avec le chiffre 3")
	@Test
	void testFizz() {
		String fizzBuzz= fb.fizbuz(3);
		Assertions.assertEquals("Fizz", fizzBuzz);
	}
	
	@DisplayName("Avec le chiffre 5")
	@Test
	void testBuzz() {
		String fizzBuzz= fb.fizbuz(5);
		Assertions.assertEquals("Buzz", fizzBuzz);
	}
	
	@DisplayName("Avec le chiffre 15")
	@Test
	void testfizzbuzz() {
		String fizzBuzz= fb.fizbuz(15);
		Assertions.assertEquals("FizzBuzz", fizzBuzz);
	}
	
	@DisplayName("Avec le chiffre 0 et nagatif")
	@Test()
	void testexception() {
	
	    Assertions.assertThrows(IllegalArgumentException.class, () ->FizzBuzz.fizbuz(0));
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
