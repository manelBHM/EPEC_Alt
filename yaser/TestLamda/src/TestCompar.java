import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompar {

	public static void main(String[] args) {
		 
   Comparator<Integer> compLamda = (Integer s1, Integer s2) -> Integer.compare(s1, s2);
   List<Integer> list = Arrays.asList(9,7,5,3,1,8,6,4,2);
   Collections.sort(list, compLamda);
   for(Integer i : list) {
	   System.out.println(i);
   }
	}

}
