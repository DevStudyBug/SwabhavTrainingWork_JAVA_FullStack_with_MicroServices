package assignment.week1;
//2. Count the number of vowels in a string ((without stringbuilder)
import java.util.Scanner;

public class Q2_CountVowels {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scanner.nextLine().toLowerCase();
		
		int count = 0;
//		str = str.toLowerCase();
		
		for(int i = 0; i < str.length() ;i++) {
		char vowel = str.charAt(i);
		if (vowel =='a'|| vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u') {
			count++ ;
		}
		}
		System.out.println("Number of vowels "+ count+" in String "+ " ' "+ str+ " ' " );
		
	scanner.close();	
}
}

