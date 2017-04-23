package com.github.chaoswang.learning.java.rxjava;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class BasicTest {

	/**
	 * ���������ҵ��
	 * 1.LRU�㷨
	 * 2.������ʽ
	 * 3.����תǰ�򡢺���
	 * 4.Լɪ��
	 * 5.����ջʵ�ֶ���
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
