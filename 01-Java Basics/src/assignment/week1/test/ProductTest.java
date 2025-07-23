package assignment.week1.test;

import java.util.Scanner;

import assignment.week1.model.Product;

public class ProductTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter number of product: ");
	int size = scanner.nextInt();
	scanner.nextLine();
	Product[] products = new Product[size];
	
	for (int i = 0; i < size ; i++) {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        int price = scanner.nextInt();
        scanner.nextLine();  

        products[i] = new Product(name, price);
	}

    // Display products with price < ₹1000
	System.out.println("\nProducts with price less than ₹ 1000 is :");
    for (Product product : products) {
        if (product.price < 1000) {
            System.out.println(product.name + " price is ₹ " + product.price);
        }
    }

    scanner.close();
}
}
