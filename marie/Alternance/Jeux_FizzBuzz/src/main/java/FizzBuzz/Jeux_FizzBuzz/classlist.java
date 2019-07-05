package FizzBuzz.Jeux_FizzBuzz;

	
public class classlist {

	
	
	public static String exportNumber(int nb) throws IllegalArgumentException{
	
	
		
			try {
				
				if(nb <= 0)
					throw new IllegalArgumentException();
				
				else if((nb % 15==0 && nb>=1)) {
					
					return "FizzBuzz" ;
				}
				
				else if((nb % 5==0 && nb>=1)){
					return "Buzz";
				}
				
				else if(nb % 3==0 && nb>=1) {         
					return "Fizz";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return null;
			
			
						
			
			}		
			
			
	}
