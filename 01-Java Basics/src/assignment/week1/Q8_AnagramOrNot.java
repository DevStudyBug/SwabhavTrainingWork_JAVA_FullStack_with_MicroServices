package assignment.week1;

import java.util.Arrays;
import java.util.Scanner;

/*8. Check if two strings are anagrams
 Input: "listen", "silent"
 Output: Yes (if both contain same characters)
*/

public class Q8_AnagramOrNot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first word: ");
		String str1 = scanner.nextLine().toLowerCase();

		System.out.println("Enter second word: ");
		String str2 = scanner.nextLine().toLowerCase();
		if (str1.length() != str2.length()) {
			System.out.println("Strings are not Anagram!");
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		if (Arrays.equals(arr1, arr2)) {
			System.out.println("Strings are Anagram !");
		} else {
			System.out.println("Strings are not Anagram!");
		}
	}
}
