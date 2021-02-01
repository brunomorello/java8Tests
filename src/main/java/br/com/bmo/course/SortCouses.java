package br.com.bmo.course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCouses {
	public static void main(String[] args) {
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Python", 40));
		courses.add(new Course("javascript", 23132011));
		courses.add(new Course("java 8", 150));
		courses.add(new Course("C", 20));
		
		// Sort Using Lambda
		courses.sort(Comparator.comparing(course -> course.getStudentsQnt()));
		courses.sort(Comparator.comparingInt(course -> course.getStudentsQnt()));
		
		// Sort using method reference
		courses.sort(Comparator.comparing(Course::getStudentsQnt));
		courses.sort(Comparator.comparingInt(Course::getStudentsQnt));
		
		courses.forEach(course -> System.out.println(course.getName()));
		
		System.out.println("sort course with more than 100 students -- lambda");
		courses.stream()
			.filter(course -> course.getStudentsQnt() >= 100)
			.forEach(course -> System.out.println(course.getName()));
		
		System.out.println("sort course with more than 100 students -- method reference");
		courses.stream()
			.filter(course -> course.getStudentsQnt() > 50)
			.map(Course::getStudentsQnt)
			.forEach(System.out::println);
		
		// Stores list filtered by stream
		List<Course> coursesList = courses.stream()
			.filter(course -> course.getStudentsQnt() >= 100)
			.collect(Collectors.toList());
		
		// Student Average
		courses.stream()
			.mapToInt(course -> course.getStudentsQnt())
			.average()
			.ifPresent(avg -> System.out.println("Student Average is " + avg));
		
		// Using Optional with stream
		System.out.println("Using Optional with stream");
		courses.stream()
			.filter(course -> course.getStudentsQnt() >= 100)
			.findAny()
			.ifPresent(course -> System.out.println(course.getName()));
		
		// Stream of String containing only course name
		System.out.println("Stream of String containing only course name");
		Stream<String> courseNames = courses.stream()
				.map(Course::getName);
		courseNames.forEach(System.out::println);
		
		// Stream returning a Map
		System.out.println("Stream using Collectors.toMap() can return an Map");
		courses.stream()
			.filter(course -> course.getStudentsQnt() >= 100)
			.collect(Collectors.toMap(c -> c.getName(), c-> c.getStudentsQnt()))
			.forEach((name, stdQnt) -> System.out.println(name + " has " + stdQnt + " students"));
		
	}
}
