package com.aurionpro.overloading.model;
/*🔹 7. Bill Generator
Create a class Bill with:
 generateBill(String item, int qty)
 generateBill(String item, int qty, double discount)
 generateBill(String item, int qty, double discount, double tax)
Print total bill amount accordingly*/

public class BillGenerator {
	String item;
	int qty , mrp;
	double discount;
	double tax;
	
	public double generateBill(String item, int qty,int mrp) {
		return qty*mrp;
	}
	public double generateBill(String item, int qty, double discount,int mrp) {
		return qty*mrp - discount;
	}
	public double generateBill(String item, int qty,int mrp,double discount, double tax) {
		return qty*mrp+tax-discount;
	}

}
