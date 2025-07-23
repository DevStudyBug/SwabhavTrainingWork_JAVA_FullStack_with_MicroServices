package com.aurionpro.statics.test;



import com.aurionpro.statics.model.ElectricityBillApplication;

public class ElectricityBillApplicationTest {

	public static void main(String[] args) {
		
        ElectricityBillApplication bill = new ElectricityBillApplication(101, 200);
        System.out.println("-----Electricity Bill Application------");
        bill.displayBill(); //non static call using object
        ElectricityBillApplication.displayCurrentRate(); //static call 
        bill.changeCostPerUnit(20);

	}
}
