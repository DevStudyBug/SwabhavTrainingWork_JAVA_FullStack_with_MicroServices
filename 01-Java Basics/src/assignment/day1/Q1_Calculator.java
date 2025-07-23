//1. Addition, Subtraction, Multiplication, Division
package assignment.day1;
import java.util.Scanner;

public class Q1_Calculator {
	public static void main(String []agrs) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int number1 = sc.nextInt();
		
		System.out.print("Enter second number: ");
		int number2 = sc.nextInt();
		
		int addition = number1 + number2;
		int subtraction = number1 - number2;
		int multi = number1 * number2;
		double division = number1 / number2;
		
		System.out.println("Additon of two number is : "+ addition);
		System.out.println("Subtraction of two number is : "+ subtraction);
		System.out.println("Multiplication of two number is : "+ multi);
		System.out.println("Division of two number is : "+ division);
		sc.close();
	}
	
}

