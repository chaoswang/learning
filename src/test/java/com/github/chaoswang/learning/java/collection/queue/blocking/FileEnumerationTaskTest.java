package com.github.chaoswang.learning.java.collection.queue.blocking;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

public class FileEnumerationTaskTest {

	@Test
	public void testBlockingQueue() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile): ");
		String keyword = in.nextLine();
		in.close();

		final int FILE_QUEUE_SIZE = 10;// �������д�С
		final int SEARCH_THREADS = 100;// �ؼ��������̸߳���

		// ����ArrayBlockingQueue����������
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(
				FILE_QUEUE_SIZE);

		// ֻ����һ���߳�������Ŀ¼
		FileEnumerationTask enumerator = new FileEnumerationTask(queue,
				new File(directory));
		new Thread(enumerator).start();

		// ����100���߳��������ļ�������ָ���Ĺؼ���
		for (int i = 1; i <= SEARCH_THREADS; i++)
			new Thread(new SearchTask(queue, keyword)).start();
	}
}
