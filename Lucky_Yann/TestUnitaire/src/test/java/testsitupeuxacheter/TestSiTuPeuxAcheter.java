package testsitupeuxacheter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import checksitupeuxacheter.CheckSiTuPeuxAcheter;

class TestSiTuPeuxAcheter {

	CheckSiTuPeuxAcheter check = new CheckSiTuPeuxAcheter();
	
	
	@Test
	void test() {
		
		assertEquals(false, check.checkSiTuPeuxAcheter(46));
		assertEquals(true, check.checkSiTuPeuxAcheter(22));
	}

}
