package com.aurionpro.OCP.Violation.FixDeposit.model;

public class FixDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;
	
	public FixDeposit(int accountNumber,String name,double principal,FestivalType festival, int duration) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.festival = festival;
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
	public FestivalType getfestival() {
		return festival;
	}
	public int getduration() {
		return duration;
	}
	
	public double getInterestRates() {
		switch (festival) {
		case NEWYEAR :
			return 8.0; 
		case DIWALI:
			return  8.5;
		case HOLI:
			return 7.5;
		case OTHERS:
			return 6.5;
		default:
			System.out.println("Enter Valid Fastival Type!!");
			return 0;
		}
	
		
	}
	public double calculateSimpleInterest() {
		double p= principal;
		double r = getInterestRates();
		int n = duration;
		return (p*n*r)/100;
	}
	
}
