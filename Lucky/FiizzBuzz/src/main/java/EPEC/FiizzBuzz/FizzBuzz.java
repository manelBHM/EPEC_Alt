package EPEC.FiizzBuzz;

public class FizzBuzz {


	public static String nmbrAleatoir(int number) 
	{
		String str = "";
	
			if(number<=0) {
				
			throw new IllegalArgumentException("SHIPS");}
				    
			else if (number % 3 == 0 && number % 5 == 0)
			{	
						str = "FizzBuzz";
			}
			
			  else if(number % 3 == 0)
						
			  {	str = "Fizz";
					
			  }
			  else if (number % 5 == 0) 
			  {		
						str = "Buzz";
			  }
					else 
					{
						str = number + " ";
					}
		

	
		return str;
	}
}
