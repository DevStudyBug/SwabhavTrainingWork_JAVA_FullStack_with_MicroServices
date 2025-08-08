package com.aurionpro.test;

import java.sql.*;
import java.util.Scanner;

public class Transaction_Scanner {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "anshika";

        Scanner sc = new Scanner(System.in);
        Connection con = null;

        System.out.println("Welcome to JDBC Bank");

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Transfer Money");
            System.out.println("2. Check Account Balance");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                sc.next(); // consume invalid input
                continue;
            }

            if (choice == 1) {
                while (true) {
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        con.setAutoCommit(false); // Start transaction

                        int senderId, receiverId;
                        double transferAmount = 0;

                        // Sender ID
                        while (true) {
                            System.out.print("Enter Sender Account ID: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid ID. Please enter a numeric value.");
                                sc.next();
                                continue;
                            }
                            senderId = sc.nextInt();
                            if (!isAccountExists(con, senderId)) {
                                System.out.println("Sender account not found. Try again.");
                            } else break;
                        }

                        // Receiver ID
                        while (true) {
                            System.out.print("Enter Receiver Account ID: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid ID. Please enter a numeric value.");
                                sc.next();
                                continue;
                            }
                            receiverId = sc.nextInt();
                            if (!isAccountExists(con, receiverId)) {
                                System.out.println("Receiver account not found. Try again.");
                            } else if (senderId == receiverId) {
                                System.out.println("Sender and Receiver cannot be the same.");
                            } else break;
                        }

                        // Amount validation with 3 attempts
                        double senderBalance = getBalance(con, senderId);
                        int attempts = 0;
                        boolean validAmount = false;

                        while (attempts < 3) {
                            System.out.print("Enter Amount to Transfer: ₹");
                            if (!sc.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                sc.next();
                                attempts++;
                                continue;
                            }

                            transferAmount = sc.nextDouble();

                            if (transferAmount <= 0) {
                                System.out.println("Amount must be greater than ₹0.");
                                attempts++;
                            } else if (transferAmount > senderBalance) {
                                System.out.println("Insufficient funds.");
                                attempts++;
                            } else {
                                validAmount = true;
                                break;
                            }
                        }

                        if (!validAmount) {
                            sc.nextLine(); // clear buffer
                            System.out.print("Too many invalid attempts. Would you like to cancel this transaction? (Y/N): ");
                            String cancel = sc.nextLine();
                            if (cancel.equalsIgnoreCase("Y")) {
                                System.out.println("Transaction cancelled. Returning to main menu.");
                                break;
                            } 
//                                else {
//                                continue; // restart transfer
//                            }
                        }

                        // Withdraw
                        PreparedStatement withdraw = con.prepareStatement(
                                "UPDATE accounts SET balance = balance - ? WHERE id = ?");
                        withdraw.setDouble(1, transferAmount);
                        withdraw.setInt(2, senderId);
                        withdraw.executeUpdate();

                        // Deposit
                        PreparedStatement deposit = con.prepareStatement(
                                "UPDATE accounts SET balance = balance + ? WHERE id = ?");
                        deposit.setDouble(1, transferAmount);
                        deposit.setInt(2, receiverId);
                        deposit.executeUpdate();

                      
                        con.commit();
                        if (transferAmount > 0) {
                            System.out.println("₹" + transferAmount + " transferred from Account ID " + senderId
                                    + " to Account ID " + receiverId);
                        }
                        break;

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        try {
                            if (con != null)
                                con.rollback();
                            System.out.println("Transaction rolled back. Try again.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    } finally {
                        try {
                            if (con != null && !con.isClosed())
                                con.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            } else if (choice == 2) {
                try {
                    con = DriverManager.getConnection(url, user, password);
                    System.out.print("Enter Account ID to check balance: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID. Must be numeric.");
                        sc.next();
                        continue;
                    }
                    int id = sc.nextInt();
                    if (!isAccountExists(con, id)) {
                        System.out.println("Account not found.");
                    } else {
                        double balance = getBalance(con, id);
                        System.out.println("Account ID: " + id + " → Balance: ₹" + balance);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                } finally {
                    try {
                        if (con != null && !con.isClosed())
                            con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            } else if (choice == 3) {
                System.out.println("Thank you for using JDBC Bank. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }

        sc.close();
    }

    // Check if account exists
    private static boolean isAccountExists(Connection con, int accountId) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT id FROM accounts WHERE id = ?");
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    // Get account balance
    private static double getBalance(Connection con, int accountId) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getDouble("balance");
    }
}
