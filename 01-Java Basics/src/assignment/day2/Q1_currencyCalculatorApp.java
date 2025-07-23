package assignment.day2;

import java.util.Scanner;

public class Q1_currencyCalculatorApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount"); // 35000 
		int amount = sc.nextInt();
		if (amount % 100 != 0 || amount > 50000 || amount <= 0) {
            System.out.println("Amount should  not exceed 50000 and always be multiple of 100");
        } else {
            int notes2000 = amount / 2000;  // 35000/2000 =17
            amount %= 2000;   //35000% 2000 = 1000
 
            int notes500 = amount / 500;  // 1000/ 500 = 2
            amount %= 500;   // 0

            int notes200 = amount / 200;
            amount %= 200;

            int notes100 = amount / 100;
            amount %= 100;

            if (notes2000 > 0)
                System.out.println("Two Thousand : " + notes2000);
            if (notes500 > 0)
                System.out.println("Five Hundred : " + notes500);
            if (notes200 > 0)
                System.out.println("Two Hundred : " + notes200);
            if (notes100 > 0)
                System.out.println("One Hundred : " + notes100);
        }
        sc.close();
	}
}

