package alternance.fizzbuzz;

public class FizzBuzz {

	
	public String nmbrAleatoir(int number) 
	{
		String str = "";
	if(number <= 0)
	
		str = "Saisissez un nombre entier";
	
		
	else if (number % 3 == 0 && number % 5 == 0)
			
			str = number + ", FizzBuzz ";

  else if(number % 3 == 0)
			
		str = number + ", Fizz ";
		
		else if (number % 5 == 0) 
			
			str = number + ", Buzz ";
		
		return str;
	}
	


}
