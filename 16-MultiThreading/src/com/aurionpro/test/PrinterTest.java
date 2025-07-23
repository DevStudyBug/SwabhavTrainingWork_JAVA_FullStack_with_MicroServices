package com.aurionpro.test;

import com.aurionpro.model.Printer;

public class PrinterTest {
	 public static void main(String[] args) {
	        Printer sharedPrinter = new Printer();
	        Runnable r1 = () -> sharedPrinter.print("Report.pdf");
	        Runnable r2 = () -> sharedPrinter.print("Invoice.pdf");
	        new Thread(r1, "Amit").start();
	        new Thread(r2, "Alok").start();
	    }
}
