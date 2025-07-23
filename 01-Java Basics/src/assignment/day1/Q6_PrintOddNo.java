package assignment.day1;

//6. Printing odd numbers between 1 to 100
public class Q6_PrintOddNo {
	public static void main(String[] agrs) {
		System.out.println("Odd number between 1 to 100 are : ");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
	}
}
