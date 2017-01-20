package com.github.chaoswang.runnable.example.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSize {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
		executor.submit(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("heartbeat");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		System.out.println(executor.getPoolSize());
	}
}
