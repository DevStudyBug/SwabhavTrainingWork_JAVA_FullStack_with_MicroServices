package assignment.day1;
//9. Palindrome Number 
import java.util.Scanner;
public class Q9_Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number to check : ");
		int number = input.nextInt();

		int reverse = 0;
		int originalnum = number;
		
		while (number != 0) {
			reverse = reverse * 10 + (number % 10);
			number = number / 10;
		}
		
		if (originalnum == reverse) {
			System.out.println("Number is palindrome");
		} else {
			System.out.println("Number is not palindrome");
		}
		input.close();
	}
}
