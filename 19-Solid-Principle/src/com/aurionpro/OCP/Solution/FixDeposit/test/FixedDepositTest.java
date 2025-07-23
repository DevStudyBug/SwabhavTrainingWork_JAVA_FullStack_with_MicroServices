package com.aurionpro.OCP.Solution.FixDeposit.test;

import com.aurionpro.OCP.Solution.FixDeposit.model.FixDeposit;
import com.aurionpro.OCP.Solution.FixDeposit.model.HoliInterest;

public class FixedDepositTest {
public static void main(String[] args) {
	FixDeposit fd = new FixDeposit(101, "Anshika", 1000, new HoliInterest(), 2);
//	FestivalInterest fI = new FestivalInterest();
//	System.out.println("Simple Interest is : "+ fd.calculateSimpleInterest());
	
	System.out.println("----Customer details-----");
	System.out.println("Name: "+ fd.getname());
	System.out.println("Account number: "+ fd.getAccountnumber());
	System.out.println("Principle: " +fd.getprincipal());
	System.out.println("Duration: "+ fd.getduration());
	System.out.println("Simple interest : "+fd.calculateSimpleInterest());
}
}
