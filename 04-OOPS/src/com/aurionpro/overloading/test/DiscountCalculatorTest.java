package com.aurionpro.overloading.test;
import com.aurionpro.overloading.model.DiscountCalculator;

public class DiscountCalculatorTest {
public static void main(String[] args) {
	double price = 100;
	String coupon = "SAVE10";
	 DiscountCalculator cal = new  DiscountCalculator();
	 System.out.println("-----------Discount System----------"); 
	 cal.calculateDiscount(price);
	
	 cal.calculateDiscount(price, "SAVE10");
	 cal.calculateDiscount(price, coupon, true);
}
}


/*12. E-Commerce Discount System
Objective: Apply method overloading to calculate discount and final price.
🔹 Requirements:
 Create a class DiscountCalculator with:
o calculateDiscount(double price)
o calculateDiscount(double price, String coupon)
o calculateDiscount(double price, String coupon, boolean
isMember)
🧪 Logic:
 Default discount: 5%
 If coupon is "SAVE10", apply 10%
 If isMember is true, apply an extra 5% discount*/