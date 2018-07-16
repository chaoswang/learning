package com.github.chaoswang.learning.java.juc.basic;

public class ThreadTest extends Thread {
	boolean stop = false;
	int value = 0;

	public void run() {
		while (!stop) {
			value++;
		}
	}

	public static void main(String[] args) throws Exception{
		ThreadTest t = new ThreadTest();
		t.start();
		Thread.sleep(2000);
		for(int i=0;i<10000;i++){
			t.stop = true;
		}
		System.out.println("value =" + t.value);
		Thread.sleep(2000);
		System.out.println("value =" + t.value);

	}
}
