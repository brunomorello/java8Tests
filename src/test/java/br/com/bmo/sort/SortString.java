package br.com.bmo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortString {
	public static void main(String[] args) {
		
		List<String> words = new ArrayList<String>();
		words.add("alura online");
		words.add("test");
		words.add("zenaide");
		
		// Java 7
//		 Comparator<String> comparator = new compareBySize(); 		
		// Collections.sort(words, comparator);
		
		// Java 8
//		words.sort(comparator);
//		System.out.println(words);
		
		// Java 8 - lambda (Functional Interface)
		words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(words);
		
		words.forEach(word -> System.out.println(word));
		
		// default method - used inside Interfaces (list.sort)
		
		// Java 8 - reference method
		System.out.println("Reference Method - Sorting Array");
		words.sort(Comparator.comparing(s -> s.length())); // lambda
		words.sort(Comparator.comparing(String::length)); // same result as line above using method reference
		System.out.println(words);
		
		// Iterate array using method reference
		words.forEach(System.out::println);
		
		// Using anonymous class without lambda
		System.out.println("Anonymous Class to Sort Array - Without lambda");
		Function<String, Integer> func = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		Comparator<String> comparator = Comparator.comparing(func);
		words.sort(comparator);
		System.out.println(words);
		
		// default method - java8 e.g.: Function.apply (Interface has a default method)
		// method reference - java8 e.g.: User::getName
		// lambda - java8
		
	}
}

class compareBySize implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length())
			return -1;
		if (o1.length() > o2.length())
			return 1;
		return 0;
	}
	
}