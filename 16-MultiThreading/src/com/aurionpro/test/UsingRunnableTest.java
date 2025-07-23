package com.aurionpro.test;

import com.aurionpro.model.MyThreadUsingRunnable;
import com.aurionpro.model.MyThreadUsingThreadCLass;

public class UsingRunnableTest {
public static void main(String[] args) {
	Thread thread1 = new Thread(new MyThreadUsingRunnable()) ;
	thread1.start();
	MyThreadUsingRunnable runnablethread = new MyThreadUsingRunnable();
	thread1.run();  // only main will run
	thread1.run();

	
}
}
