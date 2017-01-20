package com.github.chaoswang.runnable.example.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class GetActiveThread {
	public static void main(String[] args) {
		final ThreadGroup tg = new ThreadGroup("workers");

		ThreadFactory tf = new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(tg, r);
			}
		};

		ExecutorService excutor = Executors.newCachedThreadPool(tf);
		for (int i = 0; i < 2; i++) {
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					int count = 0;
					for (int j = 0; j < 5; j++) {
						System.out.println(Thread.currentThread().getName()
								+ ": " + count++);
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
		}
		excutor.shutdown();

		for (int j = 0; j < 10; j++) {
			System.out.println("activeCount:" + tg.activeCount());// ,
																	// future:"+future.get());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
