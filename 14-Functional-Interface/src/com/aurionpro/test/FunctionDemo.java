package com.aurionpro.test;

import java.util.function.Function;

public class FunctionDemo {
public static void main(String[] args) {
	Function<String, Integer> length = s -> s.length();
	System.out.println(length.apply("Helliiiiiiloooooooooo"));
	
	Function<Integer, String > convert = i-> i.toString();
	System.out.println(convert.apply(123));
//	System.out.println(i.type);
	
}
}
