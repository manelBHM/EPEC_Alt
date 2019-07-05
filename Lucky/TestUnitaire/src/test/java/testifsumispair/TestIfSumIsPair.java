package testifsumispair;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checkifsumispair.CheckIfSumIsPair;

class TestIfSumIsPair {

	CheckIfSumIsPair check = new CheckIfSumIsPair();
	
	@Test
	void testifsumispair() {
		
		assertEquals(false, check.checkIfSumIsPair(2, 4, 1));
		
		assertEquals(true, check.checkIfSumIsPair(-2, 4, 2));
	}

}
