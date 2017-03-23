package com.mychebao.study;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RandomTest {

	private static int count = 100000;

	public static void main(String[] args) {

		// poolTask();
		threadTask();
	}

	public static void poolTask() {
		long t1 = System.currentTimeMillis();
		final List<Integer> list = new LinkedList<>();
		ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 50, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(count));
		final Random r = new Random();
		for (int i = 0; i < count; i++) {
			tp.execute(new Runnable() {

				@Override
				public void run() {
					list.add(r.nextInt());
				}
			});
		}
		tp.shutdown();
		try {
			tp.awaitTermination(50, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - t1);
		System.out.println(list.size());
	}

	public static void threadTask() {
		long t1 = System.currentTimeMillis();
		final List<Integer> list = new LinkedList<>();
		final Random r = new Random();
		for (int i = 0; i < count; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					list.add(r.nextInt());
				}
			};
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() - t1);
		System.out.println(list.size());
	}

}
