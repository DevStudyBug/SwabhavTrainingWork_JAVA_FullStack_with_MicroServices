package com.aurionpro.Callable.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callabletest {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = Executors.newFixedThreadPool(5);
	 for (int i = 1; i <= 5; i++) {
         Callable<String> task = () -> {
             Thread.sleep(50);
             return "Result from thread: " + Thread.currentThread().getName();
         };
         Future<String> result = service.submit(task);
         System.out.println(result.get());
     }
     service.shutdown();
	
}
}
