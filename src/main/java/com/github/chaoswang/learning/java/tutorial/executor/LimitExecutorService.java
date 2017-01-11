package com.github.chaoswang.learning.java.tutorial.executor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LimitExecutorService {
	ExecutorService ex = Executors.newFixedThreadPool(3);
	
	public void test(){
		
		for (int i = 0; i < 10; i++) {
			Callable<Object> c = new ATask(String.valueOf(i));
			TimedFutureTask tft = new TimedFutureTask(c, 1000);
		    Future<?> ft = ex.submit(tft.getCallable());
		    tft.setFuture(ft);
		}
	}
	
	public static void main(String[] args) {
		new LimitExecutorService().test();
	}
}


class ATask implements Callable<Object>{
	String name = null;
	public ATask(String name ){
		this.name = name;
	}
	
	@Override
	public Object call() {
		long start = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Task " + name + " done in "
	                + (System.currentTimeMillis() - start) + "ms");
			
		} catch (InterruptedException e) {
			System.out.println("Task " + name + " aborted after "
	                + (System.currentTimeMillis() - start) + "ms");
//			e.printStackTrace();
		}
		
		return null;
	}
}

class TimedFutureTask{
	static ScheduledExecutorService canceller = Executors
			.newSingleThreadScheduledExecutor();
	Timer cancelTimer;
	Callable<Object> timedCallable;
	Future<?> f;

	public Callable<Object> getCallable() {
		return timedCallable;
	}

	public void setFuture(final Future<?> future) {
		f = future;
	}
	
	public TimedFutureTask(final Callable<Object> callable, final int timeoutMS) {
		timedCallable = new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				cancelTimer = new Timer();
				cancelTimer.schedule(new TimerTask() {
					@Override
					public void run() {
						f.cancel(true);
					}
				}, timeoutMS);
				final Object res = callable.call();
				cancelTimer.cancel();
				return res;
			}
		};
	}
	
}