package com.github.chaoswang.runnable.example.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuteThread {
	ExecutorService threads;
	
	public ExecuteThread(int poolSize) {
		threads = Executors.newFixedThreadPool(poolSize);
	}
	
	public void createThread(){
		threads.execute(new PrintTask());
		
	}
	
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		ExecuteThread t1 = new ExecuteThread(3);
		t1.createThread();
		t1.createThread();
		for (int i = 0; i <= 5; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("The cirrent Thread is " + t.getName()
					+ " and thread ID is " + t.getId());
		}
	}
	
	class PrintTask implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("PrintTask heartbeat");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out
						.println("The current Thread is "
								+ Thread.currentThread().getName()
								+ " and thread ID is "
								+ Thread.currentThread().getId());
			}
		}
	}
}
