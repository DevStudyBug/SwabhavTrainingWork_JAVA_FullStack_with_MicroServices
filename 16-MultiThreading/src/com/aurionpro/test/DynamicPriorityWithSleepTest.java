package com.aurionpro.test;

import com.aurionpro.model.DynamicPriorityWithSleep;

public class DynamicPriorityWithSleepTest {

	public static void main(String[] args) {
        new DynamicPriorityWithSleep("Alpha", 5).start();
        new DynamicPriorityWithSleep("Beta", 5).start();
        new DynamicPriorityWithSleep("Gamma", 5).start();
        // new DynamicPriorityExample("Thread 4", 1).start();
    }
}