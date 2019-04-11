package TEST;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		fail("Not yet implemented");
		
		   Scanner reader = new Scanner(System.in); 
		    System.out.println("Enter a number: ");
		    long limit = 5000L;
		    long startTime = System.currentTimeMillis();
		    Long l = reader.nextLong();
		    if ((startTime + limit) < System.currentTimeMillis())
		        System.out.println("Sorry, your answer is too late");
		    else
		        System.out.println("Your answer is on time");
	}

}
