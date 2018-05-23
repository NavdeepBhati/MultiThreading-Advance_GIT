package com.atomicVar;

import java.util.concurrent.atomic.AtomicInteger;

class ProcessingThread implements Runnable {
  private volatile int count;
    private AtomicInteger countAtom = new AtomicInteger();

    @Override
     public void run() {
        for (int i = 1; i < 5; i++) {
        	//System.out.println("run "+ Thread.currentThread().getName());

            processSomething(i);
            System.out.println(" ");
 
            System.out.println("count....................  "+Thread.currentThread().getName()+"           "+ count++);
            System.out.println(" ");

            System.err.println("countAtom................  "+Thread.currentThread().getName() +"           "+countAtom.incrementAndGet());;
        }
    }

    public int getCount() {
    	System.out.println("getCount "+ Thread.currentThread().getName());
        return this.count;
    }

    public int getCountAtom() {
    	System.out.println("getCountAtom "+ Thread.currentThread().getName());
    	return this.countAtom.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}