package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FridayTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8, 10, 12, 13);
//	list.stream().filter(num->num%2==0).collect(Collectors.toList()).forEach(System.out::println);
		System.out
				.println("Even numbers are: " + list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList()));

		List<String> name = Arrays.asList("Alok", "Anshika", "Amit", "Beena", "Shreya", "");
		System.out.println("Name starts with letter A: "
				+ name.stream().filter(n -> n.toUpperCase().startsWith("A")).collect(Collectors.toList()));
		System.out.println(
				"Name starts with letter A: " + name.stream().filter(n -> n.toUpperCase().startsWith("A")).count());

		System.out.println("Blank spaces:" + name.stream().filter(n -> n.isEmpty()).collect(Collectors.toList()));
		System.out.println("-----MAP ----");
		System.out.println(
				"Name in Upper case : " + name.stream().map(n -> n.toUpperCase()).collect(Collectors.toList()));
		System.out.println("square of list : " + list.stream().map(n -> n * n).collect(Collectors.toList()));

		Map<String, String> nameGender = Map.of("Anshika", "Female", "Alok", "Male", "Amit", "Male", "Avisha",
				"female");
		nameGender.entrySet().stream().map(e -> (e.getValue().equalsIgnoreCase("male") ? "Mr. " : "Ms. ") + e.getKey())
				.forEach(System.out::println);

		System.out.println("----Count-----");
		List<Integer> marks = Arrays.asList(40, 80, 50, 30, 12, 20, 10, 60, 70, 80);
		System.out.println("total pass student " + marks.stream().filter(m -> m > 35).count());
		List<Integer> list3 = Arrays.asList(90, 89, 70, 100, 1000, 500, 400);
		System.out.println("Count cost above 500 after diacount: "
				+ list3.stream().map(n -> n - (0.2 * n)).filter(c -> c > 500).count());

		System.out.println("----Sorted-----");

		System.out.println("ascending order : " + list.stream().sorted().collect(Collectors.toList()));
//	list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println(
				"descending order : " + list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

		List<String> str = Arrays.asList("Anshika", "Aradhaya", "Om", "Rucha", "Rashi", "Alok");
		System.out.println("names in (A-Z) order " + str.stream().sorted().collect(Collectors.toList()));

		System.out.println("names in reverse (Z → A) order "
				+ str.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		name.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

		System.out.println("--------max--min-------------");
		List<Integer> li= Arrays.asList(2,5,33,26,69,22,46);
		System.out.println("MAXIMUM "+li.stream().max(Comparator.comparing(Integer::intValue)));

		System.out.println("MINIMUM "+li.stream().min(Comparator.comparing(Integer::intValue)));
	}
}
