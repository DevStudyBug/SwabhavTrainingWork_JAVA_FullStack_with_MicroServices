package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter product name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter product price: ");
		double price = scanner.nextDouble();
		
		Product product = new Product();
		product.setid(id);
		product.setname(name);
		product.setprice(price);
		
		System.out.println("Product details "+ product.toString());
		
	}
}
