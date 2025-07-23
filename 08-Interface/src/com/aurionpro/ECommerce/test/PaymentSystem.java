package com.aurionpro.ECommerce.test;

import java.util.Scanner;

import com.aurionpro.ECommerce.model.CreditCard;
import com.aurionpro.ECommerce.model.IPaymentGateway;
import com.aurionpro.ECommerce.model.NetBanking;
import com.aurionpro.ECommerce.model.UPI;

public class PaymentSystem  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPaymentGateway gateway = null;

        while (true) {
            try {
                System.out.println("\n--- Payment Menu ---");
                System.out.println("1. Credit Card");
                System.out.println("2. UPI");
                System.out.println("3. Net Banking");
                System.out.println("4. Exit");
                System.out.print("Choose Payment Method (1-4): ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 4) {
                    System.out.println("Thank you! Transaction session ended.");
                    break;
                }

                switch (choice) {
                    case 1:
                        gateway = new CreditCard();
                        break;
                    case 2:
                        gateway = new UPI();
                        break;
                    case 3:
                        gateway = new NetBanking();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        continue;
                }

                System.out.print("Enter amount to pay: ₹");
                double amount = Double.parseDouble(scanner.nextLine());

                if (amount <= 0) {
                    System.out.println("Invalid amount. Must be greater than ₹0.");
                    continue;
                }

              
                boolean success = gateway.pay(amount);

                if (success) {
                    System.out.print("Do you want a refund? (yes/no): ");
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("yes")) {
                        gateway.refund(amount);
                    }
                } else {
                    System.out.println("Refund not available because payment failed.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric input.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}