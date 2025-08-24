package com.aurionpro.Listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionTrackerListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println("New Session Created: " + e.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println("Session Destroyed: " + e.getSession().getId());
    }
}