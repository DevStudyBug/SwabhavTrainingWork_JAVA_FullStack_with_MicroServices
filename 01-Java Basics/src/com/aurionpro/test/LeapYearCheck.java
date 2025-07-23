package com.aurionpro.test;

public class LeapYearCheck {
	public static void main(String []args ) {
		int  year = 1940;
		if((year % 4 ==0 && year % 100 !=0 )|| (year % 400 == 0)){
			System.out.println("year is leap year");
		}else {
			System.out.println("year is not leap year");
		}
	}
}
/*A year is a leap year if

It is divisible by 4, and

Not divisible by 100,

Unless it is also divisible by 400*/
