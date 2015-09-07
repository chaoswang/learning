package com.github.chaoswang.learning.java.juc.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class BuyDumplingTest {

	/**
	 * callable + future应用场景
	 */
	@Test
	public void testBoilingDumpling() {
		// 第一种方式
		ExecutorService executor = Executors.newCachedThreadPool();
		BuyDumpling task = new BuyDumpling();
		Future<Integer> result = executor.submit(task);
		executor.shutdown();

		// 第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
		/*
		 * BuyDumpling task = new BuyDumpling(); 
		 * FutureTask<Integer> futureTask = new FutureTask<Integer>(task); 
		 * Thread thread = new Thread(futureTask); 
		 * thread.start();
		 */

		System.out.println("我在烧开水，花费4分钟");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("饺子买好了" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("水烧开了，饺子也买来了，直接下锅");
	}

}
