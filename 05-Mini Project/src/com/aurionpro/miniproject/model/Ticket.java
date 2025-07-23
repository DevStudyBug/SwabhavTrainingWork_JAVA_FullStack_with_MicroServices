package com.aurionpro.miniproject.model;

public class Ticket {
	private String customerName;
	private TicketType ticketType;
	private BookingStatus bookingStatus;
	
	public Ticket(String customerName, TicketType ticketType) {
        this.customerName = customerName;
        this.ticketType = ticketType;
        this.bookingStatus = BookingStatus.PENDING;
    }
	
	public void cancelBooking() {
		this.bookingStatus = BookingStatus.CANCELLED;
		
	}
	
	public void confirmBooking() {
		this.bookingStatus = BookingStatus.CONFIRMED;
	}
	
	public void displayTicket() {
		System.out.println("----Display ticket details----\n");
		System.out.println("Customer Name: "+ customerName);
//		System.out.println("Ticket Type: "+ TicketType.values());
		System.out.println("Ticket Type: "+ ticketType);
		System.out.println("Ticket Price: "+ ticketType.getPrice());
		System.out.println("Booking status: "+ bookingStatus);
	}
}
