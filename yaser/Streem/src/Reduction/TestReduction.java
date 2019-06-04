package Reduction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestReduction {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,10,10);
		
		Integer red = 
		list.stream()
		             .reduce(0,Integer::sum);
		             
           System.out.println(red);
           
           //////////////////////////////////////////
           
           List<Integer> list2 = Arrays.asList(10,10);
           
           Optional<Integer> red2 =
        		   
        		   list2.stream()
        		                 .reduce(Integer::sum);
           
           System.out.println(red2);
        		   
	}

}
