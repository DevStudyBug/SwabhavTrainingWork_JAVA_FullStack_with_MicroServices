package com.aurionpro.Supplier.test;

import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
public static void main(String[] args) {
	Supplier<List<String>> productSupplier = () -> List.of(
            "Laptop",
            "Smartphone",
            "Tablet",
            "Headphones",
            "Smartwatch"
    );

    // Fetch the product list
    List<String> products = productSupplier.get();

    // Display the products
    System.out.println("=== Default Product List ===");
    products.forEach(product -> System.out.println("- " + product));
}
}
