package com.aurionpro.FoodOrderingConsoleApp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminService {

	public static void viewMenu() {
		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM menu_items")) {

			System.out.println("\n===== MENU ITEMS =====");
			System.out.printf("%-5s %-30s %-10s\n", "ID", "Item Name", "Price (₹)");
			System.out.println("--------------------------------------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				System.out.printf("%-5d %-30s %-10.2f\n", id, name, price);
			}

		} catch (Exception e) {
			System.out.println("Error fetching menu: " + e.getMessage());
		}
	}

	public static void viewCustomers() {
		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM customers")) {

			System.out.println("\n===== REGISTERED CUSTOMERS =====");
			System.out.printf("%-5s %-25s %-15s\n", "ID", "Name", "Mobile");
			System.out.println("------------------------------------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				System.out.printf("%-5d %-25s %-15s\n", id, name, mobile);
			}

		} catch (Exception e) {
			System.out.println("Error fetching customers: " + e.getMessage());
		}
	}

	public static void viewDeliveryPartners() {
		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM delivery_partners")) {

			System.out.println("\n===== DELIVERY PARTNERS =====");
			System.out.printf("%-5s %-25s %-15s\n", "ID", "Partner Name", "Contact");
			System.out.println("------------------------------------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				System.out.printf("%-5d %-25s %-15s\n", id, name, contact);
			}

		} catch (Exception e) {
			System.out.println("Error fetching delivery partners: " + e.getMessage());
		}
	}
}