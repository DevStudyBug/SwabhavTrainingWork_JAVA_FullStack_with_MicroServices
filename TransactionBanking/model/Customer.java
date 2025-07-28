package com.aurionpro.TransactionBanking.model;

import java.sql.*;
import java.util.Scanner;

public class Customer {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "anshika";
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu(int accountId) {
        while (true) {
            System.out.println("\n========== CUSTOMER MENU ==========");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewBalance(accountId);
                case 2 -> deposit(accountId);
                case 3 -> withdraw(accountId);
                case 4 -> transfer(accountId);
                case 5 -> viewTransactions(accountId);
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewBalance(int accountId) {
        String sql = "SELECT balance FROM accounts WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Current Balance: ₹" + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching balance: " + e.getMessage());
        }
    }

    private static void deposit(int accountId) {
        int attempts = 0;
        double amount = 0;

        // Loop until valid amount is entered or user chooses to cancel
        while (true) {
            System.out.print("Enter deposit amount: ");
            try {
                amount = Double.parseDouble(sc.nextLine());

                if (amount <= 0) {
                    System.out.println("❌ Invalid amount. Please enter a positive value.");
                    attempts++;
                } else {
                    break; // Valid amount
                }

                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Do you want to cancel? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Deposit cancelled.");
                        return;
                    } else {
                        attempts = 0; // Reset counter
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a numeric value.");
                attempts++;
                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Do you want to cancel? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Deposit cancelled.");
                        return;
                    } else {
                        attempts = 0;
                    }
                }
            }
        }

        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        String txnSql = "INSERT INTO transactions (account_id, type, amount) VALUES (?, 'Deposit', ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            try (PreparedStatement updateStmt = conn.prepareStatement(sql);
                 PreparedStatement txnStmt = conn.prepareStatement(txnSql)) {

                updateStmt.setDouble(1, amount);
                updateStmt.setInt(2, accountId);
                updateStmt.executeUpdate();

                txnStmt.setInt(1, accountId);
                txnStmt.setDouble(2, amount);
                txnStmt.executeUpdate();

                conn.commit();
                System.out.println("Amount deposited successfully.");

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("❌ Transaction failed: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }


    private static void withdraw(int accountId) {
        int attempts = 0;
        double amount = 0;

        // Input validation loop
        while (true) {
            System.out.print("Enter withdrawal amount: ");
            try {
                amount = Double.parseDouble(sc.nextLine());

                if (amount <= 0) {
                    System.out.println("❌ Invalid amount. Please enter a positive value.");
                    attempts++;
                } else {
                    break; // Valid amount
                }

                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Do you want to cancel? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Withdrawal cancelled.");
                        return;
                    } else {
                        attempts = 0; // Reset attempts
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a numeric value.");
                attempts++;
                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Do you want to cancel? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Withdrawal cancelled.");
                        return;
                    } else {
                        attempts = 0;
                    }
                }
            }
        }

        String checkSql = "SELECT balance FROM accounts WHERE id = ?";
        String updateSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String txnSql = "INSERT INTO transactions (account_id, type, amount) VALUES (?, 'Withdraw', ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            try (
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                PreparedStatement txnStmt = conn.prepareStatement(txnSql)
            ) {
                checkStmt.setInt(1, accountId);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    double balance = rs.getDouble("balance");

                    if (balance >= amount) {
                        updateStmt.setDouble(1, amount);
                        updateStmt.setInt(2, accountId);
                        updateStmt.executeUpdate();

                        txnStmt.setInt(1, accountId);
                        txnStmt.setDouble(2, amount);
                        txnStmt.executeUpdate();

                        conn.commit();
                        System.out.println("Amount withdrawn successfully.");
                    } else {
                        System.out.println("Insufficient balance.");
                        conn.rollback();
                    }

                } else {
                    System.out.println("Account not found.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction failed: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void transfer(int fromId) {
        int toId = -1;
        double amount = 0;
        int attempts = 0;

        // Get recipient ID with retry logic
        while (true) {
            System.out.print("Enter recipient Account ID: ");
            try {
                toId = Integer.parseInt(sc.nextLine());
                if (toId <= 0 || toId == fromId) {
                    System.out.println("❌ Invalid recipient ID. Cannot transfer to the same account.");
                    attempts++;
                } else {
                    break;
                }

                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Cancel transfer? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Transfer cancelled.");
                        return;
                    } else {
                        attempts = 0;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid numeric account ID.");
                attempts++;
            }
        }

        attempts = 0; // reset for amount input

        // Get amount with retry logic
        while (true) {
            System.out.print("Enter amount to transfer: ");
            try {
                amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.out.println("❌ Amount must be greater than 0.");
                    attempts++;
                } else {
                    break;
                }

                if (attempts >= 3) {
                    System.out.print("Too many invalid attempts. Cancel transfer? (yes/no): ");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        System.out.println("❌ Transfer cancelled.");
                        return;
                    } else {
                        attempts = 0;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a numeric value.");
                attempts++;
            }
        }

        // SQL logic
        String checkSql = "SELECT balance FROM accounts WHERE id = ?";
        String recipientSql = "SELECT id FROM accounts WHERE id = ?";
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        String txnSql = "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            conn.setAutoCommit(false);

            try (
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                PreparedStatement recipientStmt = conn.prepareStatement(recipientSql);
                PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                PreparedStatement creditStmt = conn.prepareStatement(creditSql);
                PreparedStatement txnStmt = conn.prepareStatement(txnSql)
            ) {
                // Check sender's balance
                checkStmt.setInt(1, fromId);
                ResultSet rsSender = checkStmt.executeQuery();

                if (!rsSender.next() || rsSender.getDouble("balance") < amount) {
                    System.out.println("❌ Insufficient balance.");
                    conn.rollback();
                    return;
                }

                // Check if recipient exists
                recipientStmt.setInt(1, toId);
                ResultSet rsRecipient = recipientStmt.executeQuery();

                if (!rsRecipient.next()) {
                    System.out.println("❌ Recipient account not found.");
                    conn.rollback();
                    return;
                }

                // Proceed with transfer
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();

                txnStmt.setInt(1, fromId);
                txnStmt.setString(2, "Transfer Out");
                txnStmt.setDouble(3, amount);
                txnStmt.executeUpdate();

                txnStmt.setInt(1, toId);
                txnStmt.setString(2, "Transfer In");
                txnStmt.setDouble(3, amount);
                txnStmt.executeUpdate();

                conn.commit();
                System.out.println("✅ Transfer successful.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("❌ Transaction failed: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }

    private static void viewTransactions(int accountId) {
        String sql = "SELECT * FROM transactions WHERE account_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            printTransactionTopBorder();
            printTransactionHeader();
            printTransactionMidBorder();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("│ %-10d │ %-12s │ %-12.2f │ %-24s │%n",
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp") != null ? rs.getTimestamp("timestamp").toString() : "N/A");
            }

            if (!found) {
                System.out.printf("│ %-64s │%n", "No transactions found for this account.");
            }

            printTransactionBottomBorder();

        } catch (SQLException e) {
            System.out.println("❌ Error retrieving transactions: " + e.getMessage());
        }
    }


    private static void printTransactionTopBorder() {
        System.out.println("┌────────────┬──────────────┬──────────────┬──────────────────────────┐");
    }

    private static void printTransactionHeader() {
        System.out.printf("│ %-10s │ %-12s │ %-12s │ %-24s │%n", "Txn ID", "Type", "Amount", "Timestamp");
    }

    private static void printTransactionMidBorder() {
        System.out.println("├────────────┼──────────────┼──────────────┼──────────────────────────┤");
    }

    private static void printTransactionBottomBorder() {
        System.out.println("└────────────┴──────────────┴──────────────┴──────────────────────────┘");
    }

}
