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
}
