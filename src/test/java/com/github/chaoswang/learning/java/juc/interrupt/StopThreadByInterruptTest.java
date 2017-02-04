package com.github.chaoswang.learning.java.juc.interrupt;

import org.junit.Test;

/**
 * http://blog.csdn.net/wxwzy738/article/details/8516253
 * interrupt��interrupted ��isInterrupted ����:
 * http://blog.csdn.net/z69183787/article/details/25076033
 * @author 10094714
 *
 */
public class StopThreadByInterruptTest {

	/**
	 * ��ͼʹ��Thread.interrupt����ֹͣ���̡߳�Thread.sleep()�����ĵ��ã�
	 * Ϊ�̵߳ĳ�ʼ������ֹ�ṩ�˳�ԣ��ʱ�䡣�̱߳����������κ����õĲ�����
	 * 
	 * ������ʹ��Thread.interrupt�����������ж�һ���������е��߳�
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
	 * �ж��߳���õģ������Ƽ��ķ�ʽ�ǣ�ʹ�ù��������shared variable�������źţ������̱߳���ֹͣ�������е�����
	 * �̱߳��������Եĺ˲���һ��������������������ڼ䣩��Ȼ�����������ֹ����
	 * 
	 * ��ȷ�Ͻ�������������volatile ���ͻ򽫶�����һ�з��ʷ���ͬ���Ŀ�/������synchronized blocks/methods���С�
	 * ��ĿǰΪֹһ��˳��!���ǣ����̵߳ȴ�ĳЩ�¼����������������ֻᷢ��ʲô��
	 * ��Ȼ������̱߳����������㲻�ܺ˲鹲�������Ҳ�Ͳ���ֹͣ�������������»ᷢ����
	 * �������Object.wait()��ServerSocket.accept
	 * ()��DatagramSocket.receive()ʱ��������ٳ�һЩ��
	 * 
	 * ������ͨ���޸�volatile�����ж�һ���������е��߳�
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
	 * Thread.interrupt()���������ж�һ���������е��̡߳���һ����ʵ������ɵ��ǣ����߳��ܵ�����ʱ�׳�һ���ж��źţ�
	 * �����߳̾͵����˳�������״̬����ȷ�е�˵������̱߳�Object.wait, Thread.join��Thread.sleep���ַ���֮һ������
	 * ��ô���������յ�һ���ж��쳣��InterruptedException�����Ӷ�������սᱻ����״̬�� 
	 * 
	 * ��ˣ�����̱߳��������ַ�����������ȷ��ֹͣ�̷߳�ʽ�����ù��������������interrupt()��ע�����Ӧ�������ã���
	 * ����߳�û�б���������ʱ����interrupt()���������ã������߳̾ͽ��õ��쳣�����̱߳�������Ԥ���ô����״������
	 * ������������״̬�����κ�һ������У�����̶߳�����鹲�����Ȼ����ֹͣ
	 * 
	 * ������ͨ��Thread.interrupt()�ж�һ�����������߳�
	 */
	@Test
	public void testStopThreadByInterruptWhenThreadIsBlocked() throws Exception {
		StopThreadByInterruptWhenThreadIsBlocked thread = new StopThreadByInterruptWhenThreadIsBlocked();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;// ����߳���������������˱����������̵߳�Ψһ�����ǵ���interrupt
		Thread.sleep(2000);
		System.out.println("Interrupting thread...");
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
	}
}
