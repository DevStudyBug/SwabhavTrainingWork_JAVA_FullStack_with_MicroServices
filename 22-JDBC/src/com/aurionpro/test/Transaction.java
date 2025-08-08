package com.aurionpro.test;

import java.sql.*;
import java.util.Scanner;

public class Transaction {

	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
	        String user = "root";
	        String password = "anshika";

	        Scanner sc = new Scanner(System.in);
	        Connection con = null;

	        System.out.println("Welcome to JDBC Bank");

	        while (true) {
	            System.out.println("\n========== MENU ==========");
	            System.out.println("1. Check Account Balance");
	            System.out.println("2. Transfer Money");
	            System.out.println("3. Deposit Money");
	            System.out.println("4. View Transaction History");
	            System.out.println("5. Add New Account");
	            System.out.println("6. Delete Account");
	            System.out.println("7. Withdraw Money");
	            System.out.println("8. Exit");
	            System.out.print("Choose an option (1-8): ");

	            int choice = getValidatedInt(sc);

	            try {
	                con = DriverManager.getConnection(url, user, password);

	                switch (choice) {
	                    case 1 -> checkBalance(sc, con);
	                    case 2 -> transferMoney(sc, con);
	                    case 3 -> depositMoney(sc, con);
	                    case 4 -> viewTransactionHistory(sc, con);
	                    case 5 -> addNewAccount(sc, con);
	                    case 6 -> deleteAccount(sc, con);
	                    case 7 -> withdrawMoney(sc, con);
	                    case 8 -> {
	                        System.out.println("Thank you for using JDBC Bank. Goodbye!");
	                        sc.close();
	                        return;
	                    }
	                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 8.");
	                }
	            } catch (SQLException e) {
	                System.out.println("Database error: " + e.getMessage());
	            } finally {
	                try {
	                    if (con != null && !con.isClosed()) con.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
	    }


	    	private static void checkBalance(Scanner sc, Connection con) throws SQLException {
	    	    int attempts = 0;
	    	    final int MAX_ATTEMPTS = 3;
	    	    boolean validInput = false;
	    	    int id = -1;

	    	    while (attempts < MAX_ATTEMPTS) {
	    	        System.out.print("Enter Account ID to check balance: ");
	    	        if (sc.hasNextInt()) {
	    	            id = sc.nextInt();
	    	            if (id > 0) {
	    	                validInput = true;
	    	                break;
	    	            } else {
	    	                System.out.println("Account ID must be positive.");
	    	            }
	    	        } else {
	    	            System.out.println("Invalid input. Please enter a valid Account ID.");
	    	            sc.next(); // clear invalid token
	    	        }
	    	        attempts++;
	    	    }

	    	    if (!validInput) {
	    	        sc.nextLine(); // clear buffer
	    	        System.out.print("Too many invalid attempts. Cancel operation? (Y/N): ");
	    	        String cancel = sc.nextLine();
	    	        if (cancel.equalsIgnoreCase("Y")) {
	    	            System.out.println("Operation cancelled. Returning to main menu.");
	    	            return;
	    	        } else {
	    	            checkBalance(sc, con); // restart method
	    	            return;
	    	        }
	    	    }

	    	    if (!isAccountExists(con, id)) {
	    	        System.out.println("Account not found.");
	    	        return;
	    	    }

	    	    double balance = getBalance(con, id);
	    	    System.out.println("Account ID: " + id + " → Balance: ₹" + balance);
	    	
	}

		private static void transferMoney(Scanner sc, Connection con) throws SQLException {
	        con.setAutoCommit(false);
	        System.out.print("Enter Sender Account ID: ");
	        int senderId = getValidatedInt(sc);
	        if (!isAccountExists(con, senderId)) {
	            System.out.println("Sender account not found.");
	            return;
	        }

	        System.out.print("Enter Receiver Account ID: ");
	        int receiverId = getValidatedInt(sc);
	        if (!isAccountExists(con, receiverId)) {
	            System.out.println("Receiver account not found.");
	            return;
	        }

	        if (senderId == receiverId) {
	            System.out.println("Sender and Receiver cannot be the same.");
	            return;
	        }

	        double senderBalance = getBalance(con, senderId);

	        int attempts = 0;
	        boolean validAmount = false;
	        double amount = 0;

	        while (attempts < 3) {
	            System.out.print("Enter Amount to Transfer: ₹");
	            amount = getValidatedDouble(sc);
	            if (amount > 0 && amount <= senderBalance) {
	                validAmount = true;
	                break;
	            } else {
	                System.out.println("Invalid transfer amount. Check your balance.");
	                attempts++;
	            }
	        }

	        if (!validAmount) {
	            sc.nextLine();
	            System.out.print("Too many invalid attempts. Would you like to cancel this transaction? (Y/N): ");
	            String cancel = sc.nextLine();
	            if (cancel.equalsIgnoreCase("Y")) {
	                System.out.println("Transaction cancelled. Returning to main menu.");
	                return;
	            } else {
	                System.out.println("You may retry this option from the main menu.");
	                return;
	            }
	        }

	        try {
	            updateBalance(con, senderId, -amount);
	            updateBalance(con, receiverId, amount);
	            logTransaction(con, senderId, "TRANSFER OUT", amount);
	            logTransaction(con, receiverId, "TRANSFER IN", amount);
	            con.commit();
	            System.out.println("\u20B9" + amount + " transferred successfully.");
	        } catch (SQLException e) {
	            con.rollback();
	            System.out.println("Transfer failed: " + e.getMessage());
	        }
	    }

		private static void depositMoney(Scanner sc, Connection con) throws SQLException {
		    int id = -1;
		    final int MAX_ATTEMPTS = 3;
		    int attempts = 0;
		    boolean validInput = false;

		    // Get valid Account ID
		    while (attempts < MAX_ATTEMPTS) {
		        System.out.print("Enter Account ID: ");
		        if (sc.hasNextInt()) {
		            id = sc.nextInt();
		            if (id > 0) {
		                if (isAccountExists(con, id)) {
		                    validInput = true;
		                    break;
		                } else {
		                    System.out.println("Account not found.");
		                }
		            } else {
		                System.out.println("Account ID must be positive.");
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid Account ID.");
		            sc.next(); // Clear invalid input
		        }
		        attempts++;
		    }

		    if (!validInput) {
		        sc.nextLine(); // clear buffer
		        System.out.print("Too many invalid attempts. Cancel deposit? (Y/N): ");
		        String cancel = sc.nextLine();
		        if (cancel.equalsIgnoreCase("Y")) {
		            System.out.println("Deposit cancelled. Returning to main menu.");
		            return;
		        } else {
		            depositMoney(sc, con); // restart method
		            return;
		        }
		    }

		    // Reset for deposit amount
		    attempts = 0;
		    double amount = 0;
		    validInput = false;

		    // Get valid deposit amount
		    while (attempts < MAX_ATTEMPTS) {
		        System.out.print("Enter deposit amount: ");
		        if (sc.hasNextDouble()) {
		            amount = sc.nextDouble();
		            if (amount > 0) {
		                validInput = true;
		                break;
		            } else {
		                System.out.println("Deposit must be greater than 0.");
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid amount.");
		            sc.next(); // clear invalid input
		        }
		        attempts++;
		    }

		    if (!validInput) {
		        sc.nextLine(); // clear buffer
		        System.out.print("Too many invalid attempts. Cancel deposit? (Y/N): ");
		        String cancel = sc.nextLine();
		        if (cancel.equalsIgnoreCase("Y")) {
		            System.out.println("Deposit cancelled. Returning to main menu.");
		            return;
		        } else {
		            depositMoney(sc, con); // restart method
		            return;
		        }
		    }

		    // Proceed with deposit
		    updateBalance(con, id, amount);
		    logTransaction(con, id, "DEPOSIT", amount);
		    System.out.println("Amount of ₹" + amount + " deposited successfully to Account ID: " + id);
		}


		private static void withdrawMoney(Scanner sc, Connection con) throws SQLException {
		    int id = -1;
		    int attempts = 0;
		    boolean validId = false;

		    // Validate account ID with retry mechanism
		    while (!validId && attempts < 3) {
		        System.out.print("Enter Account ID: ");
		        if (sc.hasNextInt()) {
		            id = sc.nextInt();
		            if (id > 0 && isAccountExists(con, id)) {
		                validId = true;
		            } else {
		                System.out.println("Account not found.");
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid Account ID.");
		            sc.next(); // clear invalid token
		        }
		        attempts++;
		    }

		    if (!validId) {
		        sc.nextLine(); // clear buffer
		        System.out.print("Too many invalid attempts. Cancel withdrawal? (Y/N): ");
		        String cancel = sc.nextLine();
		        if (cancel.equalsIgnoreCase("Y")) {
		            System.out.println("Withdrawal cancelled. Returning to main menu.");
		            return;
		        } else {
		            attempts = 0; // reset attempts and retry
		            withdrawMoney(sc, con);
		            return;
		        }
		    }

		    double balance = getBalance(con, id);
		    double amount = -1;
		    attempts = 0;
		    boolean validAmount = false;

		    // Validate withdrawal amount
		    while (!validAmount && attempts < 3) {
		        System.out.print("Enter amount to withdraw: ");
		        if (sc.hasNextDouble()) {
		            amount = sc.nextDouble();
		            if (amount > 0 && amount <= balance) {
		                validAmount = true;
		            } else {
		                System.out.println("Invalid or insufficient balance.");
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid amount.");
		            sc.next(); // clear invalid token
		        }
		        attempts++;
		    }

		    if (!validAmount) {
		        sc.nextLine(); // clear buffer
		        System.out.print("Too many invalid attempts. Cancel withdrawal? (Y/N): ");
		        String cancel = sc.nextLine();
		        if (cancel.equalsIgnoreCase("Y")) {
		            System.out.println("Withdrawal cancelled. Returning to main menu.");
		            return;
		        } else {
		            attempts = 0; // reset and retry
		            withdrawMoney(sc, con);
		            return;
		        }
		    }

		    // Perform withdrawal
		    updateBalance(con, id, -amount);
		    logTransaction(con, id, "WITHDRAW", amount);
		    System.out.println("Amount of ₹" + amount + " withdrawn successfully from Account ID: " + id);
		}


		private static void addNewAccount(Scanner sc, Connection con) throws SQLException {
		    String name = "";
		    int nameAttempts = 0;
		    while (true) {
		        System.out.print("Enter Account Holder Name: ");
		        sc.nextLine(); // Consume newline
		        name = sc.nextLine().trim();

		        if (name.isEmpty()) {
		            nameAttempts++;
		            System.out.println("Account holder name cannot be empty.");
		            if (nameAttempts >= 3) {
		                System.out.print("Too many invalid attempts. Do you want to cancel account creation? (Y/N): ");
		                String cancel = sc.nextLine();
		                if (cancel.equalsIgnoreCase("Y")) {
		                    System.out.println("Account creation cancelled. Returning to main menu.");
		                    return;
		                } else {
		                    nameAttempts = 0; // Reset attempts
		                }
		            }
		        } else {
		            break;
		        }
		    }

		    double deposit = 0;
		    int depositAttempts = 0;
		    while (true) {
		        System.out.print("Enter Initial Deposit: ₹");
		        if (sc.hasNextDouble()) {
		            deposit = sc.nextDouble();
		            if (deposit <=0) {
		                System.out.println("Initial deposit must be greater than ₹0. ");
		                depositAttempts++;
		            } else {
		                break;
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid number.");
		            sc.next(); // Clear invalid input
		            depositAttempts++;
		        }

		        if (depositAttempts >= 3) {
		            sc.nextLine(); // clear buffer
		            System.out.print("Too many invalid attempts. Do you want to cancel account creation? (Y/N): ");
		            String cancel = sc.nextLine();
		            if (cancel.equalsIgnoreCase("Y")) {
		                System.out.println("Account creation cancelled. Returning to main menu...");
		                return;
		            } else {
		                depositAttempts = 0; // Reset attempts
		            }
		        }
		    }

		    PreparedStatement stmt = con.prepareStatement("INSERT INTO accounts(name, balance) VALUES(?, ?)");
		    stmt.setString(1, name);
		    stmt.setDouble(2, deposit);
		    stmt.executeUpdate();

		    // Log transaction if deposit > 0
		    Statement idStmt = con.createStatement();
		    ResultSet rs = idStmt.executeQuery("SELECT LAST_INSERT_ID()");
		    if (rs.next()) {
		        int newAccountId = rs.getInt(1);
		        logTransaction(con, newAccountId, "DEPOSIT", deposit);
		    }

		    System.out.println("Account created successfully.");
		}


    private static void deleteAccount(Scanner sc, Connection con) throws SQLException {
        System.out.print("Enter Account ID to delete: ");
        int id = getValidatedInt(sc);
        if (!isAccountExists(con, id)) {
            System.out.println("Account not found.");
            return;
        }

        PreparedStatement stmt = con.prepareStatement("DELETE FROM accounts WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Account deleted successfully.");
    }

    private static void viewTransactionHistory(Scanner sc, Connection con) throws SQLException {
        System.out.print("Enter Account ID to view transaction history: ");
        int id = getValidatedInt(sc);

        if (!isAccountExists(con, id)) {
            System.out.println("Account not found.");
            return;
        }

        PreparedStatement stmt = con.prepareStatement(
            "SELECT type, amount, timestamp FROM transactions WHERE account_id = ? ORDER BY timestamp DESC");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        System.out.println("\nTransaction History for Account ID: " + id);
        System.out.printf("%-15s %-10s %-25s%n", "Type", "Amount", "Timestamp");
        System.out.println("-------------------------------------------------------");

        boolean found = false;
        while (rs.next()) {
            found = true;
            String type = rs.getString("type");
            double amount = rs.getDouble("amount");
            Timestamp timestamp = rs.getTimestamp("timestamp");
            System.out.printf("%-15s ₹%-9.2f %-25s%n", type, amount, timestamp);
        }

        if (!found) {
            System.out.println("No transactions found.");
        }
    }

    // ======= Helper Methods =======

    private static boolean isAccountExists(Connection con, int accountId) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT id FROM accounts WHERE id = ?");
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    private static double getBalance(Connection con, int accountId) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("balance");
        }
        return 0;
    }

    private static void updateBalance(Connection con, int accountId, double amount) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
        stmt.setDouble(1, amount);
        stmt.setInt(2, accountId);
        stmt.executeUpdate();
    }

    private static void logTransaction(Connection con, int accountId, String type, double amount) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO transactions(account_id, type, amount) VALUES (?, ?, ?)");
        stmt.setInt(1, accountId);
        stmt.setString(2, type);
        stmt.setDouble(3, amount);
        stmt.executeUpdate();
    }

    private static int getValidatedInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getValidatedDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: ");
            sc.next();
        }
        return sc.nextDouble();
    }
    
}
