package NabilProjets.FizzBuzz;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;




public class FizzTest {
	
	public FizzBuzzClass fb;
	
	@BeforeAll
	 static void  setUpBeforeClass() throws Exception{
		System.out.println("Test before Class");
	}
	@BeforeEach

	public  void setUp() throws Exception{
		System.out.println("Test Before");

	}
	
	@AfterEach

	public  void tearDown() throws Exception{
		System.out.println("Test After");

	}
	
	@Test
	public  void TestCalcul() throws Exception{
		
		assertEquals("Fizz","Fizz", FizzBuzzClass.lettres(3));
		assertEquals("Buzz","Buzz", FizzBuzzClass.lettres(5));
		assertEquals("Fizz-Buzz","Fizz-Buzz", FizzBuzzClass.lettres(15));
		assertEquals("Fizz-Buzz","Fizz-Buzz", FizzBuzzClass.lettres(17));


	}
	
	@AfterAll

	public  void setUpAfterClass() throws Exception{
		System.out.println("Test After");

	}
	
}
