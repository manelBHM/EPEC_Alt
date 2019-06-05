
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {

	public static void main(String[] args) {
	 

		
		List<String> string =Arrays.asList("one","two","three","four","five");
		Consumer<String>c1=System.out::println;
		
		List<String> ruselt = new ArrayList<>();
		Consumer<String> c2= ruselt::add;
		
		string.forEach(c1.andThen(c2));
		System.out.println("the size of the elements is : "+ruselt.size());
	}
}
