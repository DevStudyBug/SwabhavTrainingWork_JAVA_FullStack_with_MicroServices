package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.Printer;

public class PrinterTest {
public static void main(String[] args) {
	String str = "Hello guys!";
	int number = 3;
	Printer printer = new Printer();
	printer.print(number);
	System.out.println(printer.print());
	System.out.print(printer.print(number));
}
}
