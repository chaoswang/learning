package com.github.chaoswang.learning.java.juc.threadlocal;

public class EveryThreadHasIndependentCopy implements Runnable{
	//�и����ʣ���Ȼ�����ڶ���̼߳乲��ñ�����ΪɶҪ��id����Ϊstatic�أ�ֱ��private������
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
