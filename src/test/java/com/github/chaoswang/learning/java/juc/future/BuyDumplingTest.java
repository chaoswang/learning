package com.github.chaoswang.learning.java.juc.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class BuyDumplingTest {

	/**
	 * callable + futureӦ�ó���
	 */
	@Test
	public void testBoilingDumpling() {
		// ��һ�ַ�ʽ
		ExecutorService executor = Executors.newCachedThreadPool();
		BuyDumpling task = new BuyDumpling();
		Future<Integer> result = executor.submit(task);
		executor.shutdown();

		// �ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
		/*
		 * BuyDumpling task = new BuyDumpling(); 
		 * FutureTask<Integer> futureTask = new FutureTask<Integer>(task); 
		 * Thread thread = new Thread(futureTask); 
		 * thread.start();
		 */

		System.out.println("�����տ�ˮ������4����");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("���������" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("ˮ�տ��ˣ�����Ҳ�����ˣ�ֱ���¹�");
	}

}
