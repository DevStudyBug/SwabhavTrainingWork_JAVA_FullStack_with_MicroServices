package com.aurionpro.OrderProcessingSystem.model;

public class SMSConformation  implements Notifier {
	@Override
	public void send(String message) {
		System.out.println("SMS Notification sent :" + message);

	}
}
