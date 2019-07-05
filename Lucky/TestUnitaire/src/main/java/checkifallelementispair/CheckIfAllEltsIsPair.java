package checkifallelementispair;

public class CheckIfAllEltsIsPair {

	public boolean checkIfAllElementsPair(int[] array) 

	{
		boolean res = false;

		for(int i = 0; i < array.length; i++)
		{
			if ( array[i] % 2 == 0 )
			 
				res = true ;
			 

			else 
				res = false;


		}

		return res;

	}
}
