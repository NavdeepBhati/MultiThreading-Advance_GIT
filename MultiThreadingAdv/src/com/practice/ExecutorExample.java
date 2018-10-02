package com.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample   implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {

		
		int j=0;
		for (int i = 0; i < 100; i++) {

			j=j+1;
		//Thread.sleep(100);
		System.out.println(j);
		}
		System.err.println(Thread.currentThread().getName());
		return j;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService es= Executors.newFixedThreadPool(2);
		
		Future future=es.submit(new ExecutorExample());
		Future future2=es.submit(new ExecutorExample());
		Future future3=es.submit(new ExecutorExample());
		Future future4=es.submit(new ExecutorExample());
		Future future5=es.submit(new ExecutorExample());
		
		System.out.println(future.get()  +"   "+ Thread.currentThread().getName());
		System.out.println(future2.get() +"   "+ Thread.currentThread().getName());
		System.out.println(future3.get() +"   "+ Thread.currentThread().getName());
		System.out.println(future4.get() +"   "+ Thread.currentThread().getName());
		System.out.println(future5.get() +"   "+ Thread.currentThread().getName());
		System.out.println("Done");
		
		
		
	}

}
