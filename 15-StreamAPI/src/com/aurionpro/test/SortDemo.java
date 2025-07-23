package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDemo {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(2,3,5,7,4,11,10,20,6,54,90);
	System.err.println("Start");
//	list.stream().sorted().forEach(System.out::println);
	System.out.println(list.stream().sorted().collect(Collectors.toList()));

	System.out.println("-----------------------");
	list.stream().filter(num->num %2 ==0 && num<50).sorted().collect(Collectors.toList()).forEach(System.out::println);
	System.out.println("-----------------------");
	list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	System.out.println("--------------------");
	List<String> str = Arrays.asList("Anshika","Bee", "Aradhaya", "Om","Rucha","Rashi","Alok");
	System.out.println("---in alphabetical-reverseOrder---");
	str.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	System.out.println("---length----");
	str.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	System.out.println("---reverse----");
	str.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
	
	System.out.println("-------");
//	
}
}
