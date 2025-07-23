package com.aurionpor.model;

import java.util.Scanner;

public class ExceptionChaining {

    public static void processPayment() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value:");
            String value = sc.nextLine();

            if (value.equalsIgnoreCase("null")) {
                value = null; 
            }

            System.out.println("Length of input: " + value.length());

        } catch (NullPointerException e) {
        	// Chaining with cause
            throw new RuntimeException("Runtime exception due to null value", e); 
        }
    }

    public static void main(String[] args) {
        try {
            processPayment();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause of exception is: " + e.getCause());
        }
    }
}



/*7. Exception Chaining
Problem:
Write a method processPayment() that:
 Catches a NullPointerException and throws a new RuntimeException with the
original as the cause.
Handle the final exception in main() and print the full cause chain.*/