package fizz.buzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TestFizz  {
    @DisplayName("Fizz-buzz")
	@Test
	public void testfizzz() {
		
		assertEquals("fizz", Fizz.fizz(6));
		assertEquals("buzz", Fizz.fizz(5));
		assertEquals("fizz-buzz", Fizz.fizz(15));
		
		assertThrows(IllegalArgumentException.class,()->Fizz.fizz(-3));
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
