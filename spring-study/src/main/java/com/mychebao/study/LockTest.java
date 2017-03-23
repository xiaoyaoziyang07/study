package com.mychebao.study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private int i = 0;
	private Lock lock = new ReentrantLock();
	
	public void add(){
		lock.lock();
		i++;
		lock.unlock();
	}
	
	public int get(){
		return i;
	}
	
}
