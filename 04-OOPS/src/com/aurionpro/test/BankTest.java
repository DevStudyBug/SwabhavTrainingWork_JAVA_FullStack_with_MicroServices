package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Bank;

public class BankTest {
	public static void main(String[] args) {
	Scanner scanner =new Scanner(System.in);
	System.out.println("Enter Account number: ");
	String accNo = scanner.nextLine();
	
	System.out.println("Enter account holder name: ");
	String holderName = scanner.nextLine();
	
	System.out.println("Enter amount to deposite: ");
	double depositeAmount = scanner.nextDouble();
	
	System.out.println("Enter amount to withdraw: ");
	double withdrawAmount = scanner.nextDouble();
//	scanner.nextline();
	Bank bank = new Bank();
	
	bank.setaccountNo(accNo);
	bank.setholderName(holderName);

	bank.deposit(depositeAmount);
	bank.withdraw(withdrawAmount);
	System.out.println("Account Details :"+ bank.toString());
	}
}
