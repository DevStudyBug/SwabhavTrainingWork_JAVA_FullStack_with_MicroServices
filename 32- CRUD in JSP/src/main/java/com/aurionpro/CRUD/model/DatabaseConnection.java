package com.aurionpro.CRUD.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DatabaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/CRUDinJSP";
	private static final String user = "root";
	private static final String pass = "anshika";

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("connection successfully");
		return DriverManager.getConnection(url, user, pass);
		
}
}
