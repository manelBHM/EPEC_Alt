package testifppi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checkifpairpairimpair.CheckIfPPI;

class TestIfPPI {
	
	CheckIfPPI check = new CheckIfPPI();

	@Test
	public final void testIfPPI() {
		
		assertEquals(false, check.checkIfPairPairImpair(1, 3, 4));
		
		assertEquals(true, check.checkIfPairPairImpair(2, -4, -5));
	}

}
