package com.ReetarantLock;

public class ProcessMainClass {

	public static void main(String[] args) {
		ProcessClass pc= new ProcessClass();
		Thread t0 = new Thread(pc,"t0");
		Thread t1 = new Thread(pc,"t1");
		Thread t2 = new Thread(pc,"t2");
		
		
		t0.start();
		t1.start();
		t2.start();
		
	}
}
