package com.github.chaoswang.learning.java.juc.basic;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class ThreadStateTest {
	@Test
	public void testThreadState(){
		ThreadState ts = new ThreadState();
		Thread testThread = new Thread(ts);
		testThread.setName("testThread");
		Assert.assertEquals(Thread.State.NEW, testThread.getState());
		testThread.start();
		Assert.assertEquals(Thread.State.RUNNABLE, testThread.getState());
		
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//testThread线程运行waitForASecond方法
		Assert.assertEquals(Thread.State.TIMED_WAITING, testThread.getState());
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(Thread.State.WAITING, testThread.getState());
		
		
		try {
			ts.notifyNow();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			TimeUnit.MILLISECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//主线程持有锁，其它线程想获得锁，获取不到？？？上面哪怕睡1ms，下面的状态都是TERMINATED
		Assert.assertEquals(Thread.State.BLOCKED, testThread.getState());
		
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(Thread.State.TERMINATED, testThread.getState());
	}
}
