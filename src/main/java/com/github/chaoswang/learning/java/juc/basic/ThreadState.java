package com.github.chaoswang.learning.java.juc.basic;

import java.util.concurrent.TimeUnit;


public class ThreadState implements Runnable{

	public synchronized void waitForASecond() throws InterruptedException{
		TimeUnit.SECONDS.sleep(1);
	}
	
	public synchronized void waitForeverAfter3seconds() throws InterruptedException{
		wait();
	}
	
	public synchronized void notifyNow() throws InterruptedException{
		notify();
	}
	
	@Override
	public void run() {
		try {
			waitForASecond();
			waitForeverAfter3seconds();
			notifyNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
