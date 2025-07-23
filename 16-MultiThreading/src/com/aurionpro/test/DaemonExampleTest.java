package com.aurionpro.test;

import com.aurionpro.model.daemonThreadExample;

public class DaemonExampleTest {

	public static void main(String[] args) {
		daemonThreadExample deamonThread = new daemonThreadExample();
        deamonThread.setDaemon(true);
        deamonThread.start();

        System.out.println("Main thread is complete..........");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ended.");
    }
}