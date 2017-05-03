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
	
	@Test
	public void testParallel() throws InterruptedException{
		Flowable.range(1, 10)
				.parallel()
				.runOn(Schedulers.computation())//��������cpu����ѡ���߳���
				.map(v -> v * v)
				.sequential()
				.subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testFilter() throws InterruptedException{
		Flowable.range(1, 10)
				.subscribeOn(Schedulers.newThread())
				.filter(x -> x % 2 == 0)
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testFilterPrimeNumber() throws InterruptedException{
		//2��ʼ������ȡ20����
		Flowable.range(2, 20)
				.subscribeOn(Schedulers.newThread())
				.filter(x -> Flowable.range(2, x - 2)//2��ʼ������ȡx-2����
						.filter(y -> x % y == 0)
						.isEmpty()
						.blockingGet())
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testThreadSwitch() throws InterruptedException{
		//1��ʼ������ȡ10����
		Flowable.range(1, 10)
				//��һ������
				.subscribeOn(Schedulers.computation())
				.map(x -> {
					System.out.println(
							Thread.currentThread().getName() + " " + x
							);
					return x;
				})
				//�ڶ��������Եڶ�����˵����һ���������ߣ�
				//rx��ܰ��������˵�һ���̺߳͵ڶ����߳�֮���ͬ��
				.observeOn(Schedulers.computation())//����ע�͵��ͻ��˻��ɵ��߳�
				.map(x -> {
					System.out.println(
							Thread.currentThread().getName() + " " + x
							);
					return x;
				})
				.subscribe((x) -> System.out.println(
						Thread.currentThread().getName() + " " + x + " main task"
						) , Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	/**
	 * �������������ַ������飬��ÿ���ַ�����������ֵ��С�ظ���Ӧ���������
	 * @throws InterruptedException
	 */
	@Test
	public void testFlatMap() throws InterruptedException{
		String[] strs = {"1","2","3","4"};
		Flowable.fromArray(strs)
				.subscribeOn(Schedulers.newThread())
				.flatMap(s -> Flowable.fromArray(s)//��s�ٰ�װ���������ܽ���repeat���ã�����ֱ�Ӷ�s����repeat
						.repeat(Integer.parseInt(s)))
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
}
