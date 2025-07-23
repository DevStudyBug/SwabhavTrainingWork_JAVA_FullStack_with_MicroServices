package assignment.day1;

//10. Armstrong number example 153 , 370 
public class Q10_ArmstrongNum {
	public static void main(String[] agrs) {
		int number = 370, sum = 0, remainder;
		int temp = number;

		while (number > 0) {
			remainder = number % 10;
			number /= 10;
			sum += remainder * remainder * remainder;

		}
		if (temp == sum) {
			System.out.println("It's an Armstrong number");
		} else
			System.out.println("It's not an Armstrong number");
	}
}


// use math.pow 