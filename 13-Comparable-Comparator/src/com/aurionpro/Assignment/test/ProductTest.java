package com.aurionpro.Assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.Product.model.Product;
import com.aurionpro.Product.model.SortByCategoryThenPrice;

public class ProductTest {
public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        
        System.out.println("----Enter Product Details----\n");
        
        while (true) {
            try {
                
                String category;
                while (true) {
                    System.out.println("Enter Product Category: ");
                    category = scanner.nextLine().trim();
                    if (category.isEmpty() || !category.matches(".*[a-zA-Z]+.*")) {
                        System.out.println("Category must contain at least one alphabet!\n");
                    } else {
                        break;
                    }
                }

                String name;
                while (true) {
                    System.out.println("Enter Product Name: ");
                    name = scanner.nextLine().trim();
                    if (name.isEmpty() || !name.matches("[a-zA-Z0-9 ]+")) {
                        System.out.println("Name must contain alphabets, numbers, and spaces only!\n");
                    } else {
                        break;
                    }
                }

                double price;
                while (true) {
                    try {
                        System.out.println("Enter Product Price: ");
                        price = Double.parseDouble(scanner.nextLine());
                        if (price <= 0) {
                            throw new IllegalArgumentException("Price must be a positive value!\n");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Price must be a numeric value.\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                list.add(new Product(category, name, price));

                String choice;
                while (true) {
                    System.out.println("Do you want to add another product? (yes/no): ");
                    choice = scanner.nextLine().trim().toLowerCase();
                    if (choice.equals("yes") || choice.equals("no")) {
                        break;
                    }
                    System.out.println("Please enter 'yes' or 'no' only!\n");
                }

                if (choice.equals("no")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        if (list.isEmpty()) {
            System.out.println("No products to sort!!");
            scanner.close();
            return;
        }

        Collections.sort(list, new SortByCategoryThenPrice());

        System.out.println("\n----- Products sorted by Category then Price -----\n");
        System.out.printf("%-15s %-20s %-10s\n", "Category", "Name", "Price");
        System.out.println("---------------------------------------------------");

        for (Product p : list) {
            System.out.println(p);
        }

        scanner.close();
    }
}