package com.aurionpro.overloading.model;

public class DiscountCalculator {
double price ;

public double calculateDiscount(double price) {
	price -= price * 0.05;
	System.out.println("price with default discount is: "+ price);
	return price;
}
 public double calculateDiscount(double price, String coupon)
 {
	 if(coupon.equals("SAVE10")) {
		 price -= price*0.1;
		 System.out.println("Price after applying coupon: "+price);
	 }
	return price;
 }

 public void calculateDiscount(double price, String coupon, boolean
		 isMember) {
	 
	 if(coupon.equals("SAVE10")) {
		 price -= price*0.1;
	 }
	 if(isMember) {
		 price -= price*0.05;
	 System.out.println("price after an extra 5% discount for members applied. "+ price);
	 
 }
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