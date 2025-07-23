package assignment.day1;

public class Q4_PositiveOrNegative {
	public static void main(String[] agrs) {
		int number = -1;
		if (number != 0) {
			if (number > 0) {
				System.out.println("The number is Positive number ");
			} else if (number < 0) {
				System.out.println("The number is negative number ");
			}
		} else {
            System.out.println("The number is Zero.");
        }
	}
}