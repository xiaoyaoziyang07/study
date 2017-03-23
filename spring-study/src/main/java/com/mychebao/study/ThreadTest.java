package com.mychebao.study;

public class ThreadTest extends Thread {
	
	@Override
    public void run() {
        System.out.println("A" + this.getId());
        B b = new B();
        b.start();
        while (true) {
            try {
            	System.out.println("hhhhhh");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	public static void main(String[] args) {
		Thread thread = new ThreadTest();
		thread.start();
	}
}
 
class B extends Thread {
    public void run() {
        System.out.println("B" + this.getId());
        System.out.println("##########" + Thread.activeCount());
    }
}
