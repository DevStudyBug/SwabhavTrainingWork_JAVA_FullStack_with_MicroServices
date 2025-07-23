package com.aurionpro.banking.model;

public interface IAccountOperations {
	void deposit(double amount);
	void withdraw(double amount);
	void checkBalance();

}
