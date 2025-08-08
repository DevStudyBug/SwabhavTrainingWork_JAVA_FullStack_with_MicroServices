package com.aurionpro.FoodOrderingConsoleApp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerService {

	private static List<OrderItem> cart = new ArrayList<>();

	public static void takeOrder(Scanner sc) {
		while (true) {
			AdminService.viewMenu();
			System.out.print("\nEnter Menu Item ID to add to cart (or 0 to finish): ");
			int itemId;
			try {
				itemId = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.nextLine(); // clear buffer
				continue;
			}
			if (itemId == 0)
				break;

			System.out.print("Enter quantity: ");
			int qty;
			try {
				qty = sc.nextInt();
				if (qty <= 0) {
					System.out.println("Quantity must be greater than 0.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid quantity.");
				sc.nextLine();
				continue;
			}

			MenuItem menuItem = fetchMenuItemById(itemId);
			if (menuItem != null) {
				cart.add(new OrderItem(menuItem, qty));
				System.out.println("Added to cart!");
			} else {
				System.out.println("Invalid item ID.");
			}
		}
	}

	private static MenuItem fetchMenuItemById(int id) {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM menu_items WHERE id = ?")) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new MenuItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	public static void checkout(Scanner sc) {
		if (cart.isEmpty()) {
			System.out.println("Cart is empty!");
			return;
		}

		System.out.println("\n===== YOUR CART =====\n");

		System.out.printf("+----+----------------------+--------+----------+-------------+%n");
		System.out.printf("| %-2s | %-20s | %-6s | %-8s | %-11s |%n", "ID", "Item Name", "Price", "Quantity", "Total");
		System.out.printf("+----+----------------------+--------+----------+-------------+%n");

		double total = 0;
		for (OrderItem item : cart) {
			MenuItem m = item.getItem();
			System.out.printf("| %-2d | %-20s | %6.2f | %8d | %11.2f |%n", m.getId(), m.getName(), m.getPrice(),
					item.getQuantity(), item.getTotal());
			total += item.getTotal();
		}
		System.out.printf("+----+----------------------+--------+----------+-------------+%n");
		System.out.printf("Subtotal: ₹%.2f%n", total);

		System.out.print("\nEnter Coupon Code (SAVE10 or SAVE20 or NONE): ");
		sc.nextLine(); // consume newline
		String coupon = sc.nextLine().toUpperCase();

		double discount = 0;
		if (coupon.equals("SAVE10"))
			discount = 0.10 * total;
		else if (coupon.equals("SAVE20"))
			discount = 0.20 * total;

		double finalAmount = total - discount;
		System.out.printf("Discount Applied: ₹%.2f%n", discount);
		System.out.printf("Final Payable Amount: ₹%.2f%n", finalAmount);

		System.out.print("\nChoose Payment Type (UPI/CASH): ");
		String payment = sc.nextLine().toUpperCase();
		System.out.println("Payment Type: " + payment);

		DeliveryPartner dp = assignRandomPartner();
		if (dp != null) {
			System.out.println("\nYour order will be delivered by:\n");
			System.out.printf("+-----------------------+------------------------+%n");
			System.out.printf("| %-21s | %-22s |%n", "Delivery Partner", "Contact Number");
			System.out.printf("+-----------------------+------------------------+%n");
			System.out.printf("| %-21s | %-22s |%n", dp.getName(), dp.getContact());
			System.out.printf("+-----------------------+------------------------+%n");
		}

		System.out.println("\nThank you for ordering!");
		cart.clear();
	}

	private static DeliveryPartner assignRandomPartner() {
		List<DeliveryPartner> partners = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM delivery_partners")) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				partners.add(new DeliveryPartner(id, name, contact));
			}

			if (!partners.isEmpty()) {
				Random rand = new Random();
				return partners.get(rand.nextInt(partners.size()));
			} else {
				System.out.println("No delivery partners found in database.");
			}

		} catch (SQLException e) {
			System.out.println("SQL Error while assigning delivery partner: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected Error: " + e.getMessage());
		}

		return null;
	}
}