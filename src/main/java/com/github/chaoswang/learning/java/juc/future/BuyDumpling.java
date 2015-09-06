package com.github.chaoswang.learning.java.juc.future;

import java.util.concurrent.Callable;

public class BuyDumpling implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("儿子去楼下买饺子，花费3分钟");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
}
