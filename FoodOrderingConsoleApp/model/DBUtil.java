package com.aurionpro.FoodOrderingConsoleApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/food_ordering_advanced";
	private static final String USER = "root";
	private static final String PASS = "anshika"; 

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}