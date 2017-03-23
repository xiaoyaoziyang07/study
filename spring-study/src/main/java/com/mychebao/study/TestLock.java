package com.mychebao.study;

public class TestLock {

	public static void main(String args[]) throws InterruptedException{
		Runnable task = new Task();
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
//		t1.join();
		t2.start();
//		t2.join();
	}
}

class Task implements Runnable {
	
	private LockTest o = new LockTest();
	
	@Override
	public void run(){
		for(int i=0;i<100000;i++){
			o.add();
			System.out.println(Thread.currentThread().getName() + "=======" + o.get());
		}
	}
}