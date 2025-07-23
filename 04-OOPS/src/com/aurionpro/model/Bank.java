package com.aurionpro.model;

/*2. Bank Account Access Control:
- Create a class BankAccount with private fields: accountNumber, holderName, balance.
- Provide:
> Getter for balance
> Setter for deposit (add amount)
> Method for withdraw (only if balance is sufficient)
- Create an object and demonstrate deposit, withdraw, and balance check.*/
public class Bank {
	private String accountNo ;
	private String holderName;
	private double balance ;
	
	public String getaccountNo() {
		return accountNo;
	}
	public String getholderName() {
		return holderName;
	}
	public double getbalance() {
		return balance;
	}
	public void setaccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setholderName(String holderName) {
		this.holderName = holderName;
	}
	public void setbalace(double balance) {
		this.balance = balance ;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance +=amount;
			System.out.println("Deposite: "+ amount);
		}
		else {
			System.out.println("insufficient balance!! ");
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0 && amount <=balance) {
			balance-=amount;
			System.out.println("Withdraw :"+ amount);
		}
	}
	
	public String toString() {
        return "Bank { account number=" + accountNo + "', holder name =" + holderName + ", balance =" + balance  + " }";
    }
}

