package com.aurionpro.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<Double> random =()-> Math.random();
		System.out.println("random number is "+ random.get());
		
		Supplier<LocalDate> currentdate = ()-> LocalDate.now();
		System.out.println("Todays date: "+ currentdate.get());
		
		Supplier<LocalTime> currentTime = ()-> LocalTime.now();
		System.out.println("time is "+ currentTime.get());
		
		Supplier<LocalDateTime> DT = ()-> LocalDateTime.now();
		System.out.println("Date and time : "+ DT.get());
	}
}
