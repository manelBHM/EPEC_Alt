package testifallelementispair;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

import checkifallelementispair.CheckIfAllEltsIsPair;

class TestIfAllEIsPair {
	
	CheckIfAllEltsIsPair check = new CheckIfAllEltsIsPair();

	@Test
	void test() {
		
		 int arrayPair[] = {2,4,8};
		 int arrayImpair[] = {1,2,3};
		  
	 assertFalse(check.checkIfAllElementsPair(arrayImpair)); 
	 
	 assertTrue(check.checkIfAllElementsPair(arrayPair)); 
		
		 
	}

}
