package com.aurionpro.miniproject.model;

import java.util.Scanner;

public class TicketBookingSystem {

//	public void 
	public static void main(String [] args ) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("----- Welcome to Ticket Booking System -----\n");
		System.out.println("Enter user name: ");
		String username = scanner.nextLine();
		
		System.out.println("select ticket type:\n"
				+ "REGULAR (500 ₹)\n"
				+ "VIP (1000 ₹)\n"
				+ "PREMIUM (2000 ₹)");
		
		String select = scanner.nextLine().toUpperCase();
		
		TicketType type = TicketType.valueOf(select);
		
		Ticket ticket = new Ticket (username,type) ;
		
		System.out.println("Booking is created with pending status\nDo you want to CONFIRM or CANCEL the booking?(C for Confirm, X for Cancel):  ");
		String action = scanner.nextLine();
		
		switch(action.toUpperCase()) {
		case "C":
			ticket.confirmBooking();
			break;
		case "X":
			ticket.cancelBooking();
			break;
		default :
			System.out.println("Invalid Choice! Enter correct choice ");
		}
		
//		System.out.println("------Ticket details-----");
		ticket.displayTicket();
		scanner.close();
		
	}
}







// pending choose kiya to again option ana chhaiye c or x krna h ky 
// back jane ka option insert krna h 
// booking cancel se pehle booking msg chhaiye 

/*
Mini Project:
Title: Ticket Booking System using Enum
Concepts Used:
 enum for TicketType and BookingStatus
 switch-case
 Object creation
 Basic input/output

The Ticket Booking System mini-project simulates a real-world ticket reservation platform
using Java and the concept of enum. The system allows a user to 

book a ticket by selecting a
TicketType—REGULAR, VIP, or PREMIUM—each associated with a predefined price
using an enum with fields and methods.

A second enum, BookingStatus, tracks whether a
ticket is PENDING, CONFIRMED, or CANCELLED, ensuring clear and consistent state
management. The user is prompted to enter their name, choose a ticket type, and confirm or
cancel the booking. Based on the input, 
the system updates the ticket status and displays the
complete ticket information including the customer's name, selected ticket type, price, and
booking status. This project demonstrates how enum can be used effectively to model
constant values, control program flow, and build clean, maintainable, and type-safe code for
real-world applications like event or movie ticketing systems.

Project Overview:

 A TicketType enum: DIFFERENT PRICES for Regular, VIP, and PREMIUM tickets.
 A BookingStatus enum: PENDING, CONFIRMED, CANCELLED
 A Ticket class: holds ticket info, calculates price.
 A TicketBookingSystem class with main(): simulate booking and status display */




