package com.aurionpro.test;

public class classStackMethod {
public static void main(String[] args) {
	System.out.println("main method start");
	method1();
	System.out.println("main method end ");
}

public static void method1() {
	System.out.println("method1 start");
	method2();
	System.out.println("method1 end ");
}

public static void method2() {
	System.out.println("method2 start");
	method3();
	System.out.println("method2 end ");
}

public static void method3() {
	System.out.println("method3 start");
	System.out.println("method3 end ");
}
}
