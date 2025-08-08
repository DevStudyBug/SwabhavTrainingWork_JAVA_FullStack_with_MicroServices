package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo {
	public static void main(String[] args) throws Exception {
		// register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo", "root", "anshika");
		System.out.println("connection successfully");

		// Insert operation
		// create statement
		String insertQuery = "insert into students(roll_no,name) values(?,?)";

		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setString(1, "1");
		ps.setString(2, "Anshika");
		int rows = ps.executeUpdate();

		ps.setInt(1, 54);
		ps.setString(2, "alok");
		rows += ps.executeUpdate();
		System.out.println(rows + " Row inserted successfully");

		// Fetch (display) records
		String selectQuery = "select * from students";

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(selectQuery);

		while (rs.next()) {
			System.out.println(rs.getInt("roll_no") + "-" + rs.getString("name"));
		}

		// update
		String updateQuery = "update students set name = ? where roll_no = ?";

		PreparedStatement ps2 = connection.prepareStatement(updateQuery);
		ps2.setString(1, "shreya");
		ps2.setInt(2, 1);
		int updatedRows = ps2.executeUpdate();

		System.out.println(updatedRows + " updated");

		// Delete record
		String deleteQuery = "DELETE FROM students WHERE roll_no = ?";

		PreparedStatement ps3 = connection.prepareStatement(deleteQuery);
		ps3.setInt(1, 54);  // specify the roll_no to delete
		int rowsDeleted = ps3.executeUpdate();

		System.out.println(rowsDeleted + " row(s) deleted successfully");

//		// Delete all records from students table
		String deleteAllQuery = "DELETE FROM students";

		PreparedStatement ps1 = connection.prepareStatement(deleteAllQuery);
		int AllrowsDeleted = ps1.executeUpdate();

		System.out.println(AllrowsDeleted + " rows deleted successfully");

		connection.close();
	}
}
