package com.github.chaoswang.learning.java.thread.interrupt;

public class StopThreadByInterruptFailed extends Thread {
	boolean stop = false;

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
