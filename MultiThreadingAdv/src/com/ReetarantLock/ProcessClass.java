package com.ReetarantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ProcessClass implements Runnable{

	ReentrantLock re = new ReentrantLock();
	
	
	
	
	@Override
	public  void run()  {
		try {
			extracted();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void extracted() throws InterruptedException {
		boolean done = false;
		while (!done) {
			
		
		boolean b=	re.tryLock();
			
		if (b) {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName()+"         "+i);
				}
				
				
			} finally {
				Thread.sleep(500);

				System.out.println("Releases lock....."+Thread.currentThread().getName()  );
				System.out.println(" lock count....."+re.getHoldCount() );
					re.unlock();
					done=true;
		}
			
				
		} else {
			Thread.sleep(500);
			System.out.println("waiting for lock   "+Thread.currentThread().getName());
		}
		
	}
	}
}
