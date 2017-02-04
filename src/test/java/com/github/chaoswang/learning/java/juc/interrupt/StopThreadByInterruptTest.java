package com.github.chaoswang.learning.java.juc.interrupt;

import org.junit.Test;

/**
 * http://blog.csdn.net/wxwzy738/article/details/8516253
 * interrupt、interrupted 、isInterrupted 区别:
 * http://blog.csdn.net/z69183787/article/details/25076033
 * @author 10094714
 *
 */
public class StopThreadByInterruptTest {

	/**
	 * 试图使用Thread.interrupt方法停止该线程。Thread.sleep()方法的调用，
	 * 为线程的初始化和中止提供了充裕的时间。线程本身并不参与任何有用的操作。
	 * 
	 * 期望：使用Thread.interrupt方法并不会中断一个正在运行的线程
	 */
	@Test
	public void testStopThreadByInterruptFailed() throws Exception {
		StopThreadByInterruptFailed thread = new StopThreadByInterruptFailed();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
	}

	/**
	 * 中断线程最好的，最受推荐的方式是，使用共享变量（shared variable）发出信号，告诉线程必须停止正在运行的任务。
	 * 线程必须周期性的核查这一变量（尤其在冗余操作期间），然后有秩序地中止任务。
	 * 
	 * 请确认将共享变量定义成volatile 类型或将对它的一切访问封入同步的块/方法（synchronized blocks/methods）中。
	 * 到目前为止一切顺利!但是，当线程等待某些事件发生而被阻塞，又会发生什么？
	 * 当然，如果线程被阻塞，它便不能核查共享变量，也就不能停止。这在许多情况下会发生，
	 * 例如调用Object.wait()、ServerSocket.accept
	 * ()和DatagramSocket.receive()时，这里仅举出一些。
	 * 
	 * 期望：通过修改volatile变量中断一个正在运行的线程
	 */
	@Test
	public void testStopThreadBySharedVariable() throws Exception {
		StopThreadBySharedVariable thread = new StopThreadBySharedVariable();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;
		Thread.sleep(3000);
		System.out.println("Stopping application...");
	}

	/**
	 * Thread.interrupt()方法不会中断一个正在运行的线程。这一方法实际上完成的是，在线程受到阻塞时抛出一个中断信号，
	 * 这样线程就得以退出阻塞的状态。更确切的说，如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，
	 * 那么，它将接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态。 
	 * 
	 * 因此，如果线程被上述几种方法阻塞，正确的停止线程方式是设置共享变量，并调用interrupt()（注意变量应该先设置）。
	 * 如果线程没有被阻塞，这时调用interrupt()将不起作用；否则，线程就将得到异常（该线程必须事先预备好处理此状况），
	 * 接着逃离阻塞状态。在任何一种情况中，最后线程都将检查共享变量然后再停止
	 * 
	 * 期望：通过Thread.interrupt()中断一个被阻塞的线程
	 */
	@Test
	public void testStopThreadByInterruptWhenThreadIsBlocked() throws Exception {
		StopThreadByInterruptWhenThreadIsBlocked thread = new StopThreadByInterruptWhenThreadIsBlocked();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;// 如果线程阻塞，将不会检查此变量，结束线程的唯一方法是调用interrupt
		Thread.sleep(2000);
		System.out.println("Interrupting thread...");
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
	}
}
