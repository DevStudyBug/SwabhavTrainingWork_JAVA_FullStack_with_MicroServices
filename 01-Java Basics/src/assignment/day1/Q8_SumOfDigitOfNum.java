package assignment.day1;

//8. Calculate sum of digits of a number
public class Q8_SumOfDigitOfNum {
	public static void main(String[] agrs) {
		int num = 12345;
		int sum = 0;
		while(num!=0) {
			 int digit = num % 10;  
	            sum += digit;          
	            num = num / 10;

		}System.out.println("Sum of digits of a number is : "+sum);
	}
}
