package com.github.chaoswang.learning.java.collection.queue.blocking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


/**
 * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true       如果队列已满，则返回false
 * poll         移除并返问队列头部的元素    如果队列为空，则返回null
 * peek       返回队列头部的元素             如果队列为空，则返回null
 * put         添加一个元素                      如果队列满，则阻塞
 * take        移除并返回队列头部的元素     如果队列为空，则阻塞
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
				// 取出队首元素，如果队列为空，则阻塞
				File file = queue.take();
				if (file == FileEnumerationTask.DUMMY) {
					// 取出来后重新放入，好让其他线程读到它时也很快的结束
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
