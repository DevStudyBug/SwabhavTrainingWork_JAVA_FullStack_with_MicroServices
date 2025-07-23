package com.aurionpro.OCP.Solution.FixDeposit.model;

import com.aurionpro.OCP.Violation.FixDeposit.model.FestivalType;

public class FixDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private IFestivalInterest interest;
	
	public FixDeposit(int accountNumber,String name,double principal,IFestivalInterest interest, int duration) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.interest = interest;
		this.duration = duration;
	
	}
	public int getAccountnumber() {
		return accountNumber;
	}
	public String getname() {
		return name;
	}
	public double getprincipal() {
		return principal;
	}
	
	public int getduration() {
		return duration;
	}
	public IFestivalInterest getInterest() {
		return interest;
	}
	
	public double calculateSimpleInterest() {
		double p= getprincipal();
		double r = interest.getInterestRate();
		int n = getduration();
		return (p*n*r)/100;
	}
	
	
}
