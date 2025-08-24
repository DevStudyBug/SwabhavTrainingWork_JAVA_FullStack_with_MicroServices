package com.aurionpro.Listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("App Started: Initializing DB Connection...");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App Stopped: Closing DB Connection...");
    }
}