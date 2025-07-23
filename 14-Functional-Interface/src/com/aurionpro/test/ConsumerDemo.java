package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		// for single value
		Consumer <String> toUpperCase = msg-> System.out.println(msg.toUpperCase());
		toUpperCase.accept("anshika");
		
		
		// for collection list
		Consumer<List<String>> printlist = list-> list.forEach(System.out::println);
		printlist.accept(Arrays.asList("Amit","om","anshika"));
		
		
	}
}
