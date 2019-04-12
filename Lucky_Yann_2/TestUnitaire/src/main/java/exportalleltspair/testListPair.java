package exportalleltspair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testListPair {

	
	public static ArrayList<Integer> exportAllElementsPair(int[] array) {

		
		List<Integer> list1 = new ArrayList<Integer>();
		
		for ( int  i =0 ; i <array.length ; i++ ) {
			
		   if ( array[i]%2 == 0)
		   {
			   list1.add(array[i]);
		   }
		
		
		}
		
		return   (ArrayList<Integer>) list1 ;
	
}
	
	
	
	public static ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {

		List<Integer> list1 = new ArrayList<Integer>();

		
		
		list1 = exportAllElementsPair(array);
		
		Set<Integer> list2 = new HashSet<Integer>(list1); 
		
		List<Integer> listfinale = new ArrayList<Integer>(list2);
		
		return (ArrayList<Integer>) listfinale;

	}

	
	
	
}
