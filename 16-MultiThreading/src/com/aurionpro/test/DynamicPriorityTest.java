package com.aurionpro.test;

import com.aurionpro.model.DynamicPriority;

public class DynamicPriorityTest {
    public static void main(String[] args) {
        new DynamicPriority("Thread 1", 4).start();
        new DynamicPriority("Thread 2", 7).start();
        new DynamicPriority("Thread 3", 9).start();
        new DynamicPriority("Thread 4", 1).start();
    }

}
