package com.github.chaoswang.learning.java.juc.threadlocal;

public class EveryThreadHasIndependentCopy implements Runnable{
	//有个疑问，既然不想在多个线程间共享该变量，为啥要把id设置为static呢？直接private不行吗？
	private static ThreadLocal<Integer> id = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	public Integer getNextId() {
		id.set(id.get() + 1);
		return id.get();
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++){
			System.out.println(Thread.currentThread() + " getNextId: " + getNextId());
		}
	}
}
