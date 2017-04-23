package com.github.chaoswang.learning.java.rxjava;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class BasicTest {

	/**
	 * 待补充的作业：
	 * 1.LRU算法
	 * 2.中序表达式
	 * 3.中序转前序、后续
	 * 4.约瑟夫环
	 * 5.两个栈实现队列
	 * 
	 */
	@Test
	public void testMap() throws InterruptedException{
		String[] strs = {"1","2","3","4"};
		Flowable.fromArray(strs)
				.subscribeOn(Schedulers.newThread())
				.map(s -> s + ".")
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testParallel() throws InterruptedException{
		Flowable.range(1, 10)
				.parallel()
				.runOn(Schedulers.computation())
				.map(v -> v * v)
				.sequential()
				.subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testFilter() throws InterruptedException{
		Flowable.range(1, 10)
				.subscribeOn(Schedulers.newThread())
				.filter(x -> x % 2 == 0)
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testFilterPrimeNumber() throws InterruptedException{
		//2开始，后面取20个数
		Flowable.range(2, 20)
				.subscribeOn(Schedulers.newThread())
				.filter(x -> Flowable.range(2, x - 2)//2开始，后面取x-2个数
						.filter(y -> x % y == 0)
						.isEmpty()
						.blockingGet())
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
}
