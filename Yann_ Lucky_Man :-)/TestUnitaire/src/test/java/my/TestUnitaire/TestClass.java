package my.TestUnitaire;

import junit.framework.TestCase;
import org.junit.Assert.*;
import org.junit.*;

public class TestClass extends TestCase {

	Calculator x = new Calculator();
	
	
	@Test
	public final void testCarre()
	{
				assertEquals(3125, x.carre(5));
		
	}
	
	@Test
	public final void testCube()
	{
		assertEquals(512, x.cube(8));
	}
	
}
