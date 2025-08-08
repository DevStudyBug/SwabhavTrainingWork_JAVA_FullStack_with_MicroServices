package com.aurionpro.TransactionBanking.test;

import java.sql.*;
import java.util.Scanner;
import com.aurionpro.TransactionBanking.model.Admin;
import com.aurionpro.TransactionBanking.model.Customer;

public class TransactionTest {
    private static final Scanner sc = new Scanner(System.in);
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "anshika";

    // Optional: Console Colors
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println(GREEN + "Connected to the database successfully!" + RESET);
        } catch (SQLException e) {
            System.out.println(RED + "❌ Failed to connect to the database: " + e.getMessage() + RESET);
            return;
        }

        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Admin");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidatedIntInput();

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> customerLogin();
                case 3 -> {
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    private static void adminLogin() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter Admin Password: ");
            String inputPassword = sc.nextLine();

            if (isValidAdmin(inputPassword)) {
                System.out.println(GREEN + "✅ Admin login successful." + RESET);
                Admin.showMenu();
                return;
            } else {
                System.out.println(RED + "Incorrect password." + RESET);
                attempts++;
            }
        }

        System.out.print("Too many failed attempts. Do you want to continue? (Y/N): ");
        if (sc.nextLine().equalsIgnoreCase("Y")) {
            adminLogin();
        } else {
            System.out.println("Returning to main menu.");
        }
    }

    private static boolean isValidAdmin(String password) {
        String sql = "SELECT * FROM admin WHERE password = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println(RED + "Database error (admin check): " + e.getMessage() + RESET);
        }
        return false;
    }

    private static void customerLogin() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter Account ID: ");
            int id = getValidatedIntInput();

            System.out.print("Enter 4-digit PIN: ");
            int pin = getValidatedIntInput();

            if (isValidCustomer(id, pin)) {
                System.out.println(GREEN + "Customer login successful." + RESET);
                Customer.showMenu(id);
                return;
            } else {
                System.out.println(RED + "Invalid credentials." + RESET);
                attempts++;
            }
        }

        System.out.print("Too many failed attempts. Do you want to continue? (Y/N): ");
        if (sc.nextLine().equalsIgnoreCase("Y")) {
            customerLogin();
        } else {
            System.out.println("Returning to main menu.");
        }
    }

    private static boolean isValidCustomer(int id, int pin) {
        String sql = "SELECT * FROM accounts WHERE id = ? AND pin = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setInt(2, pin);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println(RED + "Database error (customer check): " + e.getMessage() + RESET);
        }
        return false;
    }

    private static int getValidatedIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
