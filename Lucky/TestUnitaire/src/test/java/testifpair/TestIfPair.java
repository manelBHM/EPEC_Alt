package testifpair;

import junit.framework.TestCase;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.*;

import org.junit.jupiter.api.Test;

import checkifpair.CheckIfPair;

class TestIfPair {

	CheckIfPair check = new CheckIfPair();

	@Test
	public final void Testpair() {
		
		assertEquals(false, check.checkIfPair(-3));
		
		assertEquals(true, check.checkIfPair(4));
	
	}


	

}
