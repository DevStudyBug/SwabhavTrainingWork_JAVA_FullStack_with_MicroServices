package com.project1.test;

import java.util.Scanner;

import com.project1.model.CommercialCustomer;
import com.project1.model.Customer;
import com.project1.model.ResidentialCustomer;

public class CustomerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer[] customer = new Customer[3];
		
		System.out.println("Electricity Billing System");
		for(int i = 0 ; i<3 ; i++) {
			
			System.out.println("Enter the name: ");
			String name = scanner.nextLine();
			System.out.println("select customer type: ");
			System.out.println("1. Commercial Customer ");
			System.out.println("2. Residential Customer ");
			int select = scanner.nextInt();
			if(select!=1 && select!=2) {
				System.out.println("Invalid selection");
				 i--; 
			}
			
			System.out.println("Enter the Unit consume: ");
			int unitconsume = scanner.nextInt();

			switch(select) {
			case 1:
				customer[i] = new CommercialCustomer(name , unitconsume);
				break;
			case 2: 
				customer[i] = new ResidentialCustomer(name , unitconsume);
				break;
			
			default: System.out.println("Invalid selection!  ");
			}
			scanner.nextLine();
		}	
		System.out.println("----Electricity Billing System-------");
		for (Customer customers:customer ) {
			customers.calculateBill();
		}
		scanner.close();
	}



}
