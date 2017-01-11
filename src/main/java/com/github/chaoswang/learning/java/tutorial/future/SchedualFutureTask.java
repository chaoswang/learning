package com.github.chaoswang.learning.java.tutorial.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SchedualFutureTask {
	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(5);
		List<Future<String>> futureList = es.invokeAll(Arrays.asList(new Task1(), new Task2()));
		
		
	    System.out.println(futureList.get(0).get());
	    System.out.println(futureList.get(1).get());
		
	}
}

class Task1 implements Callable<String> {
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(5);
		return "1000 * 5";
	}
}

class Task2 implements Callable<String> {
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		int i = 3;
		if (i == 3)
			throw new RuntimeException("Its Wrong");
		return "1000 * 2";
	}
}

