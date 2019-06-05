package streem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test2Stream {

	public static void main(String[] args) {
	
    Stream<String> st =Stream.of("one","two","three","four","five");
    Predicate<String>p1=s->s.length()>4;
    Predicate<String>p2=Predicate.isEqual("two");
    Predicate<String>p3=Predicate.isEqual("three");
    
    List<String>list=new ArrayList<>();
    
    st  
       .peek(System.out::println)
       .filter(p2.or(p3))
       .forEach(list::add);
    
    System.out.println("done!");
    System.out.println("the size is : "+list.size());
   
	}

}
