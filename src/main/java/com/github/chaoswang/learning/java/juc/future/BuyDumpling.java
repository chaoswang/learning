package com.github.chaoswang.learning.java.juc.future;

import java.util.concurrent.Callable;

public class BuyDumpling implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("����ȥ¥������ӣ�����3����");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
}
