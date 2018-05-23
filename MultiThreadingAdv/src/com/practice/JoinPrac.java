package com.practice;

public class JoinPrac implements Runnable
{

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			System.err.println( "sync   "+ Thread.currentThread().getName()+"   p"+Thread.currentThread().getPriority() + "  "+i );			
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

	public static void main(String[] args) throws InterruptedException {

		JoinPrac jp = new JoinPrac();
		
		Thread t1 = new Thread(jp);
		Thread t2 = new Thread(jp);
		Thread t3 = new Thread(jp);
		
		
		t1.start();
		t2.start();
		t1.join();
		
		t3.start();
	
	
	}
}
