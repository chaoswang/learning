package com.github.chaoswang.learning.java.collection.queue.blocking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


/**
 * add        ����һ��Ԫ��                     ����������������׳�һ��IIIegaISlabEepeplian�쳣
 * remove   �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
 * element  ���ض���ͷ����Ԫ��             �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
 * offer       ���һ��Ԫ�ز�����true       ��������������򷵻�false
 * poll         �Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
 * peek       ���ض���ͷ����Ԫ��             �������Ϊ�գ��򷵻�null
 * put         ���һ��Ԫ��                      �����������������
 * take        �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ�������
 * @author Administrator
 *
 */
class SearchTask implements Runnable {
	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		this.queue = queue;
		this.keyword = keyword;
	}

	public void run() {
		try {
			boolean done = false;
			while (!done) {
				// ȡ������Ԫ�أ��������Ϊ�գ�������
				File file = queue.take();
				if (file == FileEnumerationTask.DUMMY) {
					// ȡ���������·��룬���������̶߳�����ʱҲ�ܿ�Ľ���
					queue.put(file);
					done = true;
				} else
					search(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
	}

	public void search(File file) throws IOException {
		Scanner in = new Scanner(new FileInputStream(file));
		int lineNumber = 0;
		while (in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyword))
				System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber,
						line);
		}
		in.close();
	}
}
