package com.aurionpor.model;

public class NestedTryCatch {
public static void main(String[] args) {
	try {
     
        try {
            int[] arr = {5, 10, 15};
            System.out.println("Accessing 4th element: " + arr[3]);  

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inner catch block: Array index is out of bounds.");
        }
        
        int a = 20, b = 0;
        int result = a / b;
        System.out.println("Division result: " + result);

    } catch (ArithmeticException e) {
        System.out.println("Outer catch block: Cannot divide by zero.");
    }
}
}
