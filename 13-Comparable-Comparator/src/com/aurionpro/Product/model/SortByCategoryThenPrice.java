package com.aurionpro.Product.model;

import java.util.Comparator;

public class SortByCategoryThenPrice implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		int categoryCompare = p1.category.compareTo(p2.category);
//		SortBy Category A-Z then price in ascending
		return (categoryCompare==0)? Double.compare(p1.price, p2.price) : categoryCompare;
	}

}
