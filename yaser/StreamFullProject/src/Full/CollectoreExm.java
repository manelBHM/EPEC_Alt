package Full;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectoreExm {

	public static void main(String[] args) throws IOException {
		 
		List<Persson> person = new ArrayList<>();

		try (
			BufferedReader  reader= new BufferedReader(new InputStreamReader(CollectoreExm.class.getResourceAsStream("Pepole.txt")));
				Stream<String> stream =reader.lines();
		){
			stream.map(line ->{
				String[] s =line.split(" ");
				Persson p = new Persson (s[0].trim(), Integer.parseInt(s[1]));
				person.add(p);
				return p;
				
			})
			    .forEach(System.out::println);
		}
		catch (IOException e){
			System.out.println(e);
		}
		
		
		
		
		
		
		Optional<Persson> opt =
		person.stream().filter(p -> p.getAge() >= 20)
		.min(Comparator.comparing(Persson::getAge));
		
		System.out.println(opt);
		
		Optional<Persson> opt2 =
		person.stream().max(Comparator.comparing(Persson::getAge));
				System.out.println(opt2);
				
				
	Map<Integer, String> map=
				 person.stream()
                          .collect(
                            Collectors.groupingBy(
                                        Persson::getAge,
                                        Collectors.mapping(
                                        	 Persson::getName,
                                        	  Collectors.joining(", ")
                )));						
		
		System.out.println(map);
		
		
		
		
		
		
	}

}
