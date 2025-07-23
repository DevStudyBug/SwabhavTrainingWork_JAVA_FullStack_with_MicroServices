package com.aurionpro.OrderProcessingSystem.model;

public class EmailConformation implements Notifier{

	@Override
	public void send(String message) {
		System.out.println("Email Notification sent :"+message);
		
	}

}
