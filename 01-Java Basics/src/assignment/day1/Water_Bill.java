package assignment.day1;

import java.util.Scanner;

public class Water_Bill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of unit consume ");
		int unitConsume = sc.nextInt();
		int meter_charge = 75, charge = 0, total_water_bill;
		
			if (unitConsume <= 100) {
				charge = unitConsume * 5; //90*5=450 
			} else if (unitConsume <= 250) {
				charge = unitConsume * 10;
			} else {
				charge = unitConsume * 20;
			}
		
		total_water_bill = charge + meter_charge; // 525
		System.out.println("Total water bill is : " + total_water_bill);
		sc.close();
	}
}
