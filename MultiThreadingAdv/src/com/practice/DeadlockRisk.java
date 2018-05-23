package com.practice;

public class DeadlockRisk implements Runnable {
	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read() {
		synchronized (resourceA) { // May deadlock here
			System.out.println("read   sync   resorceB   "+ Thread.currentThread().getName());
			synchronized (resourceB) {
				System.out.println("read   sync   resorceB   "+  Thread.currentThread().getName());
				return resourceB.value + resourceA.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resourceB) { // May deadlock here
			
			System.out.println("write   sync   resorceB   "+ Thread.currentThread().getName());
			synchronized (resourceA) {
				
				System.out.println("write  sync   resorceA   "+ Thread.currentThread().getName());
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}
	

	@Override
	public void run() {

		System.err.println( Thread.currentThread().getName());
		read();
		write(1,2);
		
		
	}
	
	
	public static void main(String[] args) {
		DeadlockRisk dl= new DeadlockRisk();
		
		Thread t1= new Thread(dl);
		Thread t2= new Thread(dl);
		Thread t3= new Thread(dl);
		
		
		t1.start();
		t2.start();
		t3.start();
	
	
	
	}

}