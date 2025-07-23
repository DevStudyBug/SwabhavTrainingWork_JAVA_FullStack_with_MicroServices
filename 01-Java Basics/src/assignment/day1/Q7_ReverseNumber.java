package assignment.day1;

//7. Reverse a number
public class Q7_ReverseNumber {
	public static void main(String[] agrs) {
		int number = 12345, reverse = 0;
		int originalNumber = number;

		while (number != 0) {
			reverse = reverse * 10 + (number % 10);
			number = number / 10;
		} 
		System.out.println("Reverse of number " + originalNumber + " is : " + reverse);
	}
}
