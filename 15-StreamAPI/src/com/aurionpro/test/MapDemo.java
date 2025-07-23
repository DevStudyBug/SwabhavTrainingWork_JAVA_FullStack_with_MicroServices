package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Anshika", "vaishnavi", "Sheetal", "Avisha", "Shreya", "Amit", "Disha");
		list.stream().filter(name -> name.length() > 5).map(String::toUpperCase).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
//		3. Given a list of integers, square each number and collect the result into a new list.
		List<Integer> list2 = Arrays.asList(20, 30, 4, 5, 70, 29, 11, 22, 34, 54, 90);
		list2.stream().map(num -> num * num).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");

		// 4. Given a list of names, prefix each name with "Mr." or "Ms." and print the
		// result.
//		String prefix = "Ms";
//		list.stream().map(name-> prefix.concat(list))

		// 5. Given a list of product prices, apply 10% discount to each and collect the new prices.
		System.out.println("discount");
		List<Integer> list3 = Arrays.asList(90, 89, 70, 100, 1000, 500, 400);
		list3.stream().map(n -> n-(0.1 * n )).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		//6. Multiply by 10 for each element from the list.
		list2.stream().map(number->number*10).collect(Collectors.toList()).forEach(System.out::println);
		long count = list3.stream().filter(n1->n1> 100).count();
		System.out.println("count "+count);
		
//		7. Add the 5 grace marks to all the failed students (i.e. marks < 35)
		System.out.println("Pass/fail Student with grace marks"+list2.stream().filter(marks->marks<35).map(add->add+5).collect(Collectors.toList()));
	}
}

