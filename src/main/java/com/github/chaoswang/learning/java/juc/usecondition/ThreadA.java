package com.github.chaoswang.learning.java.juc.usecondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadA extends Thread {
	private MyService service;
	
	public ThreadA(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.await();
	}

	public static void main(String[] args) throws InterruptedException{
		MyService service = new MyService();
		ThreadA t1 = new ThreadA(service);
		t1.start();
		Thread.sleep(3000);
		service.signal();
	}

}

class MyService {
	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("await 时间为： " + System.currentTimeMillis());
			condition.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal 时间为: " + System.currentTimeMillis());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

}
