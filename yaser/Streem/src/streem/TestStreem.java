package streem;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStreem {

	public static void main(String[] args) {
		

		Stream<String> st = Stream.of("one","two","three","four","five");
		
		Predicate<String>p1=s->s.length()>3;
		Predicate<String>p2=Predicate.isEqual("three");
		Predicate<String>p3=Predicate.isEqual("four");
		
		st.filter(p2.or(p3)).forEach(System.out::println);
	}

}
