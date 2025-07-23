package assignment.day1;

//11. Prime Number logic = num>1 and not multi fact of 2

public class Q11_PrimeNumber {
	public static void main(String[] agrs) {
		int number = 19, count = 0;
		if (number > 1) {
			for (int i = 1; i <= number; i++) {
				if (number % i == 0)
					count++;
			}
			if (count == 2) {
				System.out.println("The number " + number + " is prime number ");
			} else {
				System.out.println("The number " + number + " is not prime number ");
			}
		} else {
			System.out.println("The number " + number + " is not prime number ");
		}
	}
}