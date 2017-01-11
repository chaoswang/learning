package com.github.chaoswang.learning.java.tutorial.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleThread implements Runnable {
	private static volatile AtomicLong counter = new AtomicLong(0);
	private static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			// Acquire the lock
			lock.lock();
			long currentCount = counter.incrementAndGet();
			System.out.println("counter = " + currentCount);
		} finally {
			// Release the lock
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < 200; i++) {
			ScheduledExecutorService executor = Executors
					.newSingleThreadScheduledExecutor();
			executor.scheduleAtFixedRate(new SingleThread(), 1, 10,
					TimeUnit.SECONDS);
		}
	}
}
