package com.github.chaoswang.learning.java.thread.interrupt;

public class StopThreadBySharedVariable extends Thread{
	volatile boolean stop = false;

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000) && (!stop)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
