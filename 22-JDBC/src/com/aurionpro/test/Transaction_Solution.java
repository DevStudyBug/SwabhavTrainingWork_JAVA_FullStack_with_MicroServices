package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction_Solution {


    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "anshika";

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            con.setAutoCommit(false); // Begin transaction

            int senderId = 1;  // Anshika
            int receiverId = 2; // Alok
            double transferAmount = 4000;

            // 🔹 Check sender balance (Consistency)
            PreparedStatement checkBalance = con.prepareStatement(
                "SELECT balance FROM accounts WHERE id = ?"
            );
            checkBalance.setInt(1, senderId);
            ResultSet rs = checkBalance.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                if (currentBalance < transferAmount) {
                    throw new RuntimeException("❌ Insufficient funds for withdrawal.");
                }
            } else {
                throw new RuntimeException("❌ Sender account not found.");
            }

            // 🔹 Withdraw from Anshika
            PreparedStatement withdrawStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            withdrawStmt.setDouble(1, transferAmount);
            withdrawStmt.setInt(2, senderId);
            withdrawStmt.executeUpdate();

            // 🔹 Deposit to Alok
            PreparedStatement depositStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            depositStmt.setDouble(1, transferAmount);
            depositStmt.setInt(2, receiverId);
            depositStmt.executeUpdate();

            con.commit(); // 🔐 Durability + Atomicity
            System.out.println("✅ Transaction successful! ₹" + transferAmount + " transferred.");

        } catch (Exception e) {
            System.out.println("⚠ Error: " + e.getMessage());
            try {
                if (con != null) {
                    con.rollback(); // 🔁 Atomicity - rollback on failure
                    System.out.println("⛔ Transaction rolled back.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
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
}
