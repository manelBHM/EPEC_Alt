package projet.test.JunitFizzBuzz;

public class FizzBuzz {
	
	public String fizbuz(int number){
		
		
		String leRetur = ""+number;
		
		if(number%5==0) {
			leRetur="Buzz";
		}
		if(number%3==0) {
			leRetur="Fizz";
		}
		
		if(number%5==0&&number%3==0) {
			leRetur="FizzBuzz";
		}
			
		return leRetur;
	}

}
