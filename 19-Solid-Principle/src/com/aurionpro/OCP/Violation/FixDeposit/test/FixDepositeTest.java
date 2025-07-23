package com.aurionpro.OCP.Violation.FixDeposit.test;

import com.aurionpro.OCP.Violation.FixDeposit.model.FestivalType;
import com.aurionpro.OCP.Violation.FixDeposit.model.FixDeposit;

public class FixDepositeTest {
public static void main(String[] args) {
	FixDeposit deposit = new FixDeposit(1090092, "Anshika",1000, FestivalType.DIWALI, 2);

	System.out.println("----Customer details-----");
	System.out.println("Name: "+ deposit.getname());
	System.out.println("Account number: "+ deposit.getAccountnumber());
	System.out.println("Principle: " +deposit.getprincipal());
	System.out.println("Festival type: "+ deposit.getfestival());
	System.out.println("Duration: "+ deposit.getduration());
	System.out.println("Simple interest : "+deposit.calculateSimpleInterest());
}
}
