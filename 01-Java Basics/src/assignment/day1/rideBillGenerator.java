package assignment.day1;

import java.util.Scanner;

public class rideBillGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your height in centemeter: ");
		int height = scanner.nextInt();

		int price = 0, total_bill = 0;

		if (height > 120) {
			System.out.print("Enter your age: ");
			int age = scanner.nextInt();
			if (age < 12) {
				price = 5;
			} else if (age <= 18) {
				price = 7;
			} else if (age < 45) {
				price = 12;
			} else if (age <= 55) {
				price = 0;
			} else {
				System.out.println("Please enter a valid age range!");
			}
			scanner.nextLine(); 
			System.out.print("Do you want photos (yes/no)? ");
			String photoResponse = scanner.nextLine();

			if (photoResponse.equalsIgnoreCase("yes")) {
				price += 3;
			}
			total_bill = price;
			System.out.println("Your total bill is: $" + total_bill);
		} else {
			System.out.println("You cannot ride!");
		}
		scanner.close();
	}
}


//		if (height>120) {
//			System.out.println("Enter your age : ");
//			int age = scanner.nextInt();
//			
//			switch(age) {
//			case 1 : if (age<12) {
//				price = 5;
//			}
//			break;
//			
//			case 2 : if(age >12 && age<=18) {
//				price = 7;
//			}
//			break;
//			
//			case 3 : if(age>18 && age <45) {
//				price =12;
//			}
//			break;
//			
//			case 4 : if (age >=45 && age<=55) {
//				price = 0;
//			}
//			scanner.nextLine();
//			System.out.println("Do you want photos ? ");
//			boolean want_photos = true ;
//			int newPrice = price + 3;
//			total_bill = newPrice ;
//			default : System.out.println("Please enter correct age !");
//			}
//			
//		}else {
//			System.out.println("You can not ride !");
//		}	
//		System.out.println("your total bill is : " + total_bill);
//		scanner.close();
//	}
//}
