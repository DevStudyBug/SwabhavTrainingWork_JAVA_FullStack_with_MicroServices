package assignment.day1;
//2. Swap values of two integers (with and without third variable)
import java.util.Scanner;
public class Q2_Swaping {
public static void main(String []agrs) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter first number: ");
	int number1 = sc.nextInt();
	
	System.out.print("Enter second number: ");
	int number2 = sc.nextInt();
	
//	with third variable
	int number3 = number1 ;
	number1 = number2 ;
	number2 = number3 ;
	System.out.println("Number after swap : " + number1 + " and "+ number2);
	sc.close();
	}
}
