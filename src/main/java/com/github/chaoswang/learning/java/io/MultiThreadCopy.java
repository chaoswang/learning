package com.github.chaoswang.learning.java.io;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//����һ��CopyThread��̳�Thread��

public class MultiThreadCopy extends Thread {
	private String srcPath;// ԭ�ļ���ַ
	private String destPath;// Ŀ���ļ���ַ
	private int start, end;// startָ����ʼλ�ã�endָ������λ��

	// ����CopyThread����
	public MultiThreadCopy(String srcPath, String destPath, int start, int end) {
		this.srcPath = srcPath;// Ҫ���Ƶ�Դ�ļ�·��
		this.destPath = destPath;// ���Ƶ����ļ�·��
		this.start = start;// ������ʼλ��
		this.end = end;// ���ƽ���λ��
	}

	public void run() {
		try {
			// ����һ��ֻ������������ļ�
			RandomAccessFile in = new RandomAccessFile(srcPath, "r");
			// ����һ���ɶ���д����������ļ�
			RandomAccessFile out = new RandomAccessFile(destPath, "rw");
			in.seek(start);// ��������ת��ָ��λ��
			out.seek(start);// ��ָ��λ�ÿ�ʼд
			FileChannel inChannel = in.getChannel(); // �ļ�����ͨ��
			FileChannel outChannel = out.getChannel();// �ļ����ͨ��
			// ��ס��Ҫ����������,false������ס
			FileLock lock = outChannel.lock(start, (end - start), false);
			// ���ֽڴӴ�ͨ�����ļ����䵽�����Ŀ�д���ֽڵ�outChannelͨ����
			inChannel.transferTo(start, (end - start), outChannel);
			lock.release();// �ͷ���
	        out.close();// ���ﵽ��ر��ļ�
			in.close();// �ر��ļ�

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
