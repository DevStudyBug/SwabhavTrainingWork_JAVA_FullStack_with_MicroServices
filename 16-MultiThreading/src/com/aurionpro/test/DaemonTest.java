package com.aurionpro.test;

import com.aurionpro.model.DaemonThread;

public class DaemonTest {
	public static void main(String[] args)
    {
        DaemonThread t1 = new DaemonThread("t1");
        DaemonThread t2 = new DaemonThread("t2");
        DaemonThread t3 = new DaemonThread("t3");
   
        t1.setDaemon(true);
        t1.start();
        
        t2.start();

//        t3.setDaemon(true);
        t3.start();        
    }
}

