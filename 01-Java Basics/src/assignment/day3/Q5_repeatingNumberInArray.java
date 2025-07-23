package assignment.day3;

//Finding how many time a number is repeating in an array
import java.util.Scanner;

public class Q5_repeatingNumberInArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of array ");
		int size = scanner.nextInt();

		int[] arr = new int[size];

		// read
		for (int i = 0; i < size; i++) {
			System.out.println("Elemet " + i + " : ");
			arr[i] = scanner.nextInt();
		}
		// element to find
		System.out.println("Enter the element to find : ");
		int findelEment = scanner.nextInt();

		int count = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] == findelEment) {
				count++;
			}

		}
		System.out.println("number " + findelEment + " apprear " + count + " times in array ");

	}
}