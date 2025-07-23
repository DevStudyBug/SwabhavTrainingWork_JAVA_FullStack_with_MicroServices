package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 7, 9, 11, 22, 34, 54, 90);
		// method 1
		list.stream().filter(num -> num > 10).collect(Collectors.toList()).forEach(System.out::println);

		// method2
		List<Integer> isOdd = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
		System.out.println(isOdd);
		System.out.println("Even number greater than 30");
		list.stream().filter(number -> number % 2 == 0 && number > 30).collect(Collectors.toList())
				.forEach(System.out::println);

//		System.out.println("Even number greater than 30");
//		list.stream().filter(number-> number%2==0 && number>30).collect(Collectors.toList()).forEach((number)-> System.out.println("even number greater than 30 alok ka sada hua code :"+number));

//		2. Given a list of names, print only those that start with the letter 'A'.
		List<String> list2 = Arrays.asList("Anshika", "Alokpgl", "vivek", "rashi", "rucha", "om", "avisha");
		list2.stream().filter(name -> name.toUpperCase().startsWith("A")).collect(Collectors.toList())
				.forEach(System.out::println);

//3. You have a list of Student objects. Filter and print students who scored 60 or above.
		List<Integer> marks = Arrays.asList(89, 90, 100, 23, 35, 78, 60);
		System.out.println("students who scored 60 or above");
		marks.stream().filter(subMarks -> subMarks >= 60).collect(Collectors.toList()).forEach(System.out::println);

//4. Given a list of strings, filter out all empty or blank strings.
		List<String> check = Arrays.asList("", "java", " ");
		System.out.println("strings with all empty or blank");
		check.stream().filter(n -> !n.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
	}
}
