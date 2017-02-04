package com.github.chaoswang.learning.java.juc.interrupt;

public class StopThreadByInterruptWhenThreadIsBlocked extends Thread {
	volatile boolean stop = false;

	public void run() {
		while (!stop) {
			System.out.println("Thread running...");
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
