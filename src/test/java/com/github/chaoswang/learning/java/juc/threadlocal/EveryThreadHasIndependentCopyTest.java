package com.github.chaoswang.learning.java.juc.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * http://blog.csdn.net/lufeng20/article/details/24314381
 * http://www.cnblogs.com/alphablox/archive/2013/01/20/2869061.html
 * @author 10094714
 *
 */
public class EveryThreadHasIndependentCopyTest {

	@Test
	public void testGetNextId(){
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 3; i++){
			executorService.execute(new EveryThreadHasIndependentCopy());
			System.out.println("************* execute" + i + " *************"); 
		}
		executorService.shutdown(); 
		System.out.println("************* shutdown *************"); 
	}
}
