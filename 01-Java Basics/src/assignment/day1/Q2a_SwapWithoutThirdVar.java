package assignment.day1;
import java.util.Scanner;
public class Q2a_SwapWithoutThirdVar {
	public static void main(String []agrs) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int number1 = sc.nextInt();
		
		System.out.print("Enter second number: ");
		int number2 = sc.nextInt();
//		without third variable
		System.out.println("Number before swap : " + number1 + " and "+ number2);
		number1 = number1 + number2;
		number2 = number1 - number2;
		number1 = number1 - number2;
		System.out.println("Number after swap : " + number1 + " and "+ number2);
		sc.close();
	}
}