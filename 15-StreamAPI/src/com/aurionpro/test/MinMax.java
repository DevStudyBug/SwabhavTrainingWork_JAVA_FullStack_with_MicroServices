package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 5, 33, 26, 69, 22, 46);
		System.out.println(list.stream().max(Comparator.comparing(Integer::intValue)));
		System.out.print("minimum : ");
		System.out.println(list.stream().min(Comparator.comparing(Integer::intValue)));
//	
	List<String> names = Arrays.asList("Amit","Om","Aradhya","Anshika","Alok","v","Rucha","Rashi","S");
	System.out.println(names.stream().min(Comparator.naturalOrder()));
	System.out.println("maximum:  "+names.stream().max(String::compareTo));
//	
	List<Integer> marks= Arrays.asList(2,5,33,26,22,46,90,99,45,68,98);
	System.out.println("highest Marks : "+marks.stream().max(Comparator.comparing(Integer::intValue)));
	System.out.println(marks.stream().min(Integer::compareTo));
//	System.out.print("----Limit-----------------");
//	 marks.stream().sorted().limit(3).forEach(System.out::println);
//	 
//	 System.out.print("Skip");
//	 marks.stream().sorted(Comparator.reverseOrder()).skip(3).forEach(System.out::println);
//	using sort max (first ) min 

		List<Integer> list1 = Arrays.asList(2, 5, 70, 33, 76, 76, 76, 69, 89, 22, 46);
		list1.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		System.out.println("----------------");
		list1.stream().sorted(Comparator.reverseOrder()).skip(3).forEach(System.out::println);
		System.out.println("------------");
		list1.stream().distinct().forEach(System.out::println);
		System.out.println("-------");
		System.out.print("Print second highest number : ");
		list1.stream().distinct().sorted(Comparator.reverseOrder()).limit(2).skip(1).forEach(System.out::println);
	}
}
