package com.aurionpro.Factory.Notifier;

import java.util.Arrays;
import java.util.List;

public class NotifierMain {
	public static void main(String[] args) {
//		List<String> channels = Arrays.asList("email", "sms", "whatsapp");
//
//		for (String channel : channels) {
//			INotifier notifier = NotifierFactory.getNotifier(channel);
//			notifier.send("Offer: Get 20% off on all items ");
//		}
		 INotifier notifier = NotifierFactory.getNotifier("sms");
		  notifier.send("Offer: Get 20% off on all items");
	}
}
