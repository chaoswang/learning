package com.github.chaoswang.runnable.example.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class BlockingQueueTake {
	public static void main(String[] args) throws Exception{
		Runner t = new Runner();
	    for (int i = 0; i < 50; i++) {
	      t.queue.add(i);
	    }
	    System.out.println(("Number of items in queue: " + t.queue.size()));
	    
	    Thread t1 = new Thread(t);
	    t1.start();
	    Thread.sleep(1000);
	    t1.interrupt();
	    t1.join();
	    System.out.println(("Number of items in queue: " + t.queue.size()));
	    System.out.println(("Joined t1. Finished"));
	}
}

class Runner implements Runnable{
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
	AtomicLong count = new AtomicLong(0);
	
	@Override
	public void run() {
		try {
			while(true){
				queue.take();
				System.out.println("Took item " + count.incrementAndGet());
				long start = System.currentTimeMillis();
				while((System.currentTimeMillis() - start) < 100){
//					System.out.println("Runner yield");
					Thread.yield();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}