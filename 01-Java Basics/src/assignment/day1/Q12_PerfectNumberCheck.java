package assignment.day1;

import java.util.Scanner;

//12. Perfect Number 6-> 1+2+3 , 6 is divison and sum of 1  2 , 3 

public class Q12_PerfectNumberCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int sum = 0, temp = number;

		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		if (temp == sum) {
			System.out.println(number + " is a Perfect Number.");
		} else {
			System.out.println(number + " is NOT a Perfect Number.");
		}
		sc.close();
	}
}
