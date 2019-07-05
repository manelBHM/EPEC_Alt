package Game.fizzBuzz;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameF.GameFizz;

class TestFizz {

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
		 assertEquals("fizz", GameFizz.Game(3));
	}
		 @Test
			void test2() {
		 assertEquals("buzz", GameFizz.Game(5));
		 }
		 @Test
			void test3() {
		 assertEquals("fizzBuzz", GameFizz.Game(15));
	}
		 @Test
		 void test4() {
			 
			 
			 assertThrows(IllegalArgumentException.class, ()-> GameFizz.Game(-15));
		 }
		 
		 

	
}
