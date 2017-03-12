package com.github.chaoswang.learning.java.io;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//定义一个CopyThread类继承Thread类

public class MultiThreadCopy extends Thread {
	private String srcPath;// 原文件地址
	private String destPath;// 目标文件地址
	private int start, end;// start指定起始位置，end指定结束位置

	// 构造CopyThread方法
	public MultiThreadCopy(String srcPath, String destPath, int start, int end) {
		this.srcPath = srcPath;// 要复制的源文件路径
		this.destPath = destPath;// 复制到的文件路径
		this.start = start;// 复制起始位置
		this.end = end;// 复制结束位置
	}

	public void run() {
		try {
			// 创建一个只读的随机访问文件
			RandomAccessFile in = new RandomAccessFile(srcPath, "r");
			// 创建一个可读可写的随机访问文件
			RandomAccessFile out = new RandomAccessFile(destPath, "rw");
			in.seek(start);// 将输入跳转到指定位置
			out.seek(start);// 从指定位置开始写
			FileChannel inChannel = in.getChannel(); // 文件输入通道
			FileChannel outChannel = out.getChannel();// 文件输出通道
			// 锁住需要操作的区域,false代表锁住
			FileLock lock = outChannel.lock(start, (end - start), false);
			// 将字节从此通道的文件传输到给定的可写入字节的outChannel通道。
			inChannel.transferTo(start, (end - start), outChannel);
			lock.release();// 释放锁
	        out.close();// 从里到外关闭文件
			in.close();// 关闭文件

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
