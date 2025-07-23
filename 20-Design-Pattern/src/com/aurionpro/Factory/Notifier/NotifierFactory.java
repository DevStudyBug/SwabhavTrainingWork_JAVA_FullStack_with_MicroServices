package com.aurionpro.Factory.Notifier;

public class NotifierFactory {
	public static INotifier getNotifier(String type) {
		switch (type.toLowerCase()) {
		case "email":
		return new EmailNotifier();
		case "sms":
		return new SmsNotifier();
		case "whatsapp":
		return new WhatsappNotifier();

		default:
		throw new IllegalArgumentException("Unknown notifier type: " + type);

		}
	}}
