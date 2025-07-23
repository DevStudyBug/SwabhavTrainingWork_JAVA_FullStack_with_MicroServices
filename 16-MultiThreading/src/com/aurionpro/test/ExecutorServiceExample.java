package com.aurionpro.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();

		Runnable task1 = () -> System.out.println("task 1 run by : " + Thread.currentThread().getName());
		Runnable task2 = () -> System.out.println("task 2 run by : " + Thread.currentThread().getName());
		Runnable task3 = () -> System.out.println("task 3 run by : " + Thread.currentThread().getName());
		Runnable task4 = () -> System.out.println("task 4 run by : " + Thread.currentThread().getName());
		
		service.submit(task1);
		service.submit(task2);
		service.submit(task3);
		service.submit(task4);
		
		service.shutdown();
	}
}