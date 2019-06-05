package NabilProjets.FizzBuzz;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class FizzBuzzClass {
	
	
	public static String lettres(int nbr) {

			
		String str = "";
		
		
		if(nbr<=0) {
			
		throw new IllegalArgumentException("Error");}
			    
		else if (nbr % 3 == 0 && nbr % 5 == 0)
		{	
					str = "Fizz-Buzz";
					System.out.println("Fizz-Buzz");
		}
		
		  else if(nbr % 3 == 0)
					
		  {	
			  str = "Fizz";
				System.out.println("Fizz");
		  }
		  else if (nbr % 5 == 0) 
		  {		
					str = "Buzz";
					System.out.println("Buzz");
		  }
				else 
				{
					str = nbr + " ";
					System.out.println(nbr);
				}
	
	return str;
		
		
		
	}

}
