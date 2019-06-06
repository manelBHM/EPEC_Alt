package javaLambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class FirstLambda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		List<String> strings = Arrays.asList("one","two","three","four","five");
		List<String> result = new ArrayList<>();
		
		Consumer<String> c1 = s -> System.out.println(s);
		
		strings.forEach(c1);
		
		
//		Comparator<String> compareLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
//
//		List<String> list = Arrays.asList("***", "**", "****", "*");
// 
//		Collections.sort(list, compareLambda);
//
//		for (String s : list) {
//			System.out.println(s);
//		}
	}
} 
