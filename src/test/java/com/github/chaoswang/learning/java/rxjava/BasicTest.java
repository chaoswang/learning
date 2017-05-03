package com.github.chaoswang.learning.java.rxjava;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class BasicTest {

	/**
	 * 待补充的作业：
	 * 1.LRU算法
	 * 2.中序表达式
	 * 3.中序转前序、后续
	 * 4.约瑟夫环
	 * 5.两个栈实现队列
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
				.runOn(Schedulers.computation())//根据主机cpu核数选择线程数
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
		//2开始，后面取20个数
		Flowable.range(2, 20)
				.subscribeOn(Schedulers.newThread())
				.filter(x -> Flowable.range(2, x - 2)//2开始，后面取x-2个数
						.filter(y -> x % y == 0)
						.isEmpty()
						.blockingGet())
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testThreadSwitch() throws InterruptedException{
		//1开始，后面取10个数
		Flowable.range(1, 10)
				//第一级处理
				.subscribeOn(Schedulers.computation())
				.map(x -> {
					System.out.println(
							Thread.currentThread().getName() + " " + x
							);
					return x;
				})
				//第二级处理，对第二级来说，第一级是生产者，
				//rx框架帮你做好了第一级线程和第二级线程之间的同步
				.observeOn(Schedulers.computation())//这行注释掉就会退化成单线程
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
	 * 遍历整数数字字符串数组，把每个字符串按它的数值大小重复相应次数后，输出
	 * @throws InterruptedException
	 */
	@Test
	public void testFlatMap() throws InterruptedException{
		String[] strs = {"1","2","3","4"};
		Flowable.fromArray(strs)
				.subscribeOn(Schedulers.newThread())
				.flatMap(s -> Flowable.fromArray(s)//把s再包装成流，才能进行repeat调用，不能直接对s进行repeat
						.repeat(Integer.parseInt(s)))
				.subscribe(System.out::println, Throwable::printStackTrace);
		TimeUnit.SECONDS.sleep(1);
	}
}
