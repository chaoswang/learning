package com.github.chaoswang.learning.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MultiThreadCopyTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//�ж������߳��Ƿ��������
		ArrayList<MultiThreadCopy> list = new ArrayList<MultiThreadCopy>();
		
		// Ҫ���Ƶ�Դ�ļ�·��
		String srcPath = "E:\\tools\\mysql-5.6.13-winx64.zip";
		String destPath = "D:\\Ѹ������\\mysql-5.6.13-winx64.zip";

		// ���Դ�ļ�����
		File f = new File(srcPath);
		long len = f.length();
		int count = 3;// ��Ҫ���߳���
		int oneNum = (int) (len / count);// ÿ���̸߳�����ļ����ȣ�ǿ��ת����int����
		// ��forѭ���������ļ��ĵ�һ���ָ��ڶ�����(ѭ�������ɸ��ݶ�����߳�������)
		for (int i = 0; i < count - 1; i++) {
			// oneNum * i ��ʼλ�ã� oneNum * (i + 1)Ҫ�������ݵĳ���
			MultiThreadCopy ct = new MultiThreadCopy(srcPath, destPath, oneNum
					* i, oneNum * (i + 1));
			ct.start();
			list.add(ct);
		}

		// �ļ����Ȳ��������Ĳ��ַŵ����һ�δ���
		MultiThreadCopy ct = new MultiThreadCopy(srcPath, destPath, oneNum
				* (count - 1), (int) len);
		ct.start();
		list.add(ct);
		
		while(true){
			if(!isFinished(list)){
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
				continue;
			}
			System.out.println("finished, cost:" + (System.currentTimeMillis() - startTime));
			break;
		}
	}
	
	private static boolean isFinished(ArrayList<MultiThreadCopy> list){
		for(MultiThreadCopy t : list){
			if(t.getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
}