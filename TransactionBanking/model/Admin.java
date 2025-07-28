package com.aurionpro.TransactionBanking.model;

import java.sql.*;
import java.util.Scanner;

public class Admin {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "anshika";
    private static final Scanner sc = new Scanner(System.in);

    public static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter Admin Password: ");
            String inputPassword = sc.nextLine();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT password FROM admin LIMIT 1")) {

                if (rs.next() && inputPassword.equals(rs.getString("password"))) {
                    return true;
                } else {
                    System.out.println("Incorrect password. Try again.\n");
                    attempts++;
                }

            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return false;
            }
        }

        System.out.print("Too many failed attempts. Do you want to continue? (yes/no): ");
        String choice = sc.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. View All Accounts");
            System.out.println("2. Delete Customer Account");
            System.out.println("3. View Transaction History (Any Account)");
            System.out.println("4. Add New Customer Account");
            System.out.println("5. Update Account Details (KYC: Name)");
            System.out.println("6. Freeze / Unfreeze Account");
            System.out.println("7. Change Admin Password");
            System.out.println("8. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> viewAllAccounts();
                case 2 -> deleteAccount();
                case 3 -> viewTransactions();
                case 4 -> addAccount();
                case 5 -> updateKYC();
                case 6 -> toggleFreeze();
                case 7 -> changePassword();
                case 8 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewAllAccounts() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {

            printTopBorder();
            printHeader();
            printMidBorder();

            while (rs.next()) {
                System.out.printf("│ %-10d │ %-12s │ %-18.2f │ %-10s │ %-12s │%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("balance"),
                        rs.getString("account_type"),
                        rs.getBoolean("is_frozen") ? "Frozen" : "Active");
            }

            printBottomBorder();

        } catch (SQLException e) {
            System.out.println("Error fetching accounts: " + e.getMessage());
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter Account ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        String sql = "DELETE FROM accounts WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Account deleted.");
            else System.out.println("Account not found.");
        } catch (SQLException e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
    }

    private static void viewTransactions() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "SELECT * FROM transactions WHERE account_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nTransaction History:");
            System.out.printf("%-5s %-10s %-10s %-20s%n", "ID", "Type", "Amount", "Timestamp");
            while (rs.next()) {
                System.out.printf("%-5d %-10s %-10.2f %-20s%n",
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching transactions: " + e.getMessage());
        }
    }

    private static void addAccount() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter 4-digit PIN: ");
        int pin = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.println("3. Salary");
        System.out.print("Enter choice (1/2/3): ");
        int typeChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        String accountType = "";
        double balance = 0;

        switch (typeChoice) {
            case 1 -> {
                accountType = "Savings";
                balance = 0;
                System.out.println("✅ Savings account selected. Initial balance set to ₹0.");
            }
            case 2 -> {
                accountType = "Current";
                while (true) {
                    System.out.print("Enter Initial Deposit (Minimum ₹1000): ");
                    balance = sc.nextDouble();
                    sc.nextLine();
                    if (balance >= 1000) break;
                    System.out.println("❌ Minimum balance for Current account is ₹1000.");
                }
            }
            case 3 -> {
                accountType = "Salary";
                System.out.print("Enter Initial Deposit: ");
                balance = sc.nextDouble();
                sc.nextLine();
            }
            default -> {
                System.out.println("❌ Invalid account type selected.");
                return;
            }
        }

        String sql = "INSERT INTO accounts (name, pin, balance, account_type) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, pin);
            stmt.setDouble(3, balance);
            stmt.setString(4, accountType);
            stmt.executeUpdate();
            System.out.println("✅ Account created successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding account: " + e.getMessage());
        }
    }

    private static void updateKYC() {
        System.out.print("Enter Account ID to update name: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        String sql = "UPDATE accounts SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("✅ Name updated.");
            else System.out.println("❌ Account not found.");

        } catch (SQLException e) {
            System.out.println("Error updating name: " + e.getMessage());
        }
    }

    private static void toggleFreeze() {
        System.out.print("Enter Account ID to toggle freeze status: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE accounts SET is_frozen = NOT is_frozen WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("✅ Account freeze status updated.");
            else System.out.println("❌ Account not found.");

        } catch (SQLException e) {
            System.out.println("Error freezing/unfreezing account: " + e.getMessage());
        }
    }

    private static void changePassword() {
        System.out.print("Enter new Admin password: ");
        String newPass = sc.nextLine();

        String sql = "UPDATE admin SET password = ? WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newPass);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("✅ Password updated.");
            else System.out.println("❌ Update failed.");

        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }

    // ───── Table Formatting ─────
    private static void printTopBorder() {
        System.out.println("┌────────────┬──────────────┬────────────────────┬────────────┬──────────────┐");
    }

    private static void printHeader() {
        System.out.printf("│ %-10s │ %-12s │ %-18s │ %-10s │ %-12s │%n",
                "Account ID", "Name", "Balance", "Type", "Status");
    }

    private static void printMidBorder() {
        System.out.println("├────────────┼──────────────┼────────────────────┼────────────┼──────────────┤");
    }

    private static void printBottomBorder() {
        System.out.println("└────────────┴──────────────┴────────────────────┴────────────┴──────────────┘");
    }
}
