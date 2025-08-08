package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transactions_Violation {
	public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcdemo"; // Replace with your DB

        String user = "root";

        String password = "anshika";
 
        Connection con = null;
 
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);
 
            // Start transaction

            con.setAutoCommit(false);
 
            // Withdraw from Alice

            PreparedStatement withdrawStmt = con.prepareStatement(

                "UPDATE accounts SET balance = balance - ? WHERE id = ?"

            );

            withdrawStmt.setDouble(1,5000);

            withdrawStmt.setInt(2, 1);

            withdrawStmt.executeUpdate();
 
            // Simulate error: uncomment to test rollback

            // if (true) throw new RuntimeException("Simulated Error");
 
            // Deposit to Bob

            PreparedStatement depositStmt = con.prepareStatement(

                "UPDATE accounts SET balance = balance + ? WHERE id = ?"

            );

            depositStmt.setDouble(1, 5000);

            depositStmt.setInt(2, 2);

            depositStmt.executeUpdate();
 
            // Commit transaction

            con.commit();

            System.out.println("✅ Transaction successful! ₹5000 transferred.");
 
        } catch (Exception e) {

            System.out.println("⚠ Error: " + e.getMessage());

            try {

                if (con != null) {

                    con.rollback();

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
