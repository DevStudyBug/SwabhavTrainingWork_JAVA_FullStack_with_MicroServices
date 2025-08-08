package com.aurionpro.FoodOrderingConsoleApp.test;

import java.util.Scanner;

import com.aurionpro.FoodOrderingConsoleApp.model.AdminService;
import com.aurionpro.FoodOrderingConsoleApp.model.CustomerService;

	public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n======= FOOD ORDERING SYSTEM =======");
	            System.out.println("1. Admin Panel");
	            System.out.println("2. Customer Panel");
	            System.out.println("3. Exit");
	            System.out.print("Choose option: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    adminMenu(sc);
	                    break;
	                case 2:
	                    customerMenu(sc);
	                    break;
	                case 3:
	                    System.out.println("Exiting... Thank you!");
	                    return;
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }

	    private static void adminMenu(Scanner sc) {
	        while (true) {
	            System.out.println("\n--- ADMIN MENU ---");
	            System.out.println("1. View All Menu Items");
	            System.out.println("2. View Customers");
	            System.out.println("3. View Delivery Partners");
	            System.out.println("4. Back");
	            System.out.print("Enter choice: ");
	            int adminChoice = sc.nextInt();

	            switch (adminChoice) {
	                case 1:
	                    AdminService.viewMenu();
	                    break;
	                case 2:
	                    AdminService.viewCustomers();
	                    break;
	                case 3:
	                    AdminService.viewDeliveryPartners();
	                    break;
	                case 4:
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }

	    private static void customerMenu(Scanner sc) {
	        while (true) {
	            System.out.println("\n--- CUSTOMER MENU ---");
	            System.out.println("1. Place Order");
	            System.out.println("2. Checkout");
	            System.out.println("3. Back");
	            System.out.print("Enter choice: ");
	            int custChoice = sc.nextInt();

	            switch (custChoice) {
	                case 1:
	                    CustomerService.takeOrder(sc);
	                    break;
	                case 2:
	                    CustomerService.checkout(sc);
	                    break;
	                case 3:
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }
	}
