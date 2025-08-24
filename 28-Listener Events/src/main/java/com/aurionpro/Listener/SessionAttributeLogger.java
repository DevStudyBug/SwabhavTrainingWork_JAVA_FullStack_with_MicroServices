package com.aurionpro.Listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeLogger implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("Attribute Added: " + e.getName() + " = " + e.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("Attribute Removed: " + e.getName() + " = " + e.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("Attribute Replaced: " + e.getName() + " = " + e.getValue());
    }
}