package com.github.chaoswang.learning.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MultiThreadCopyTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//判断所有线程是否运行完毕
		ArrayList<MultiThreadCopy> list = new ArrayList<MultiThreadCopy>();
		
		// 要复制的源文件路径
		String srcPath = "E:\\tools\\mysql-5.6.13-winx64.zip";
		String destPath = "D:\\迅雷下载\\mysql-5.6.13-winx64.zip";

		// 获得源文件长度
		File f = new File(srcPath);
		long len = f.length();
		int count = 3;// 需要的线程数
		int oneNum = (int) (len / count);// 每个线程负责的文件长度，强制转换成int类型
		// 用for循环处理划分文件的第一部分跟第二部分(循环次数可根据定义的线程数调整)
		for (int i = 0; i < count - 1; i++) {
			// oneNum * i 起始位置， oneNum * (i + 1)要复制数据的长度
			MultiThreadCopy ct = new MultiThreadCopy(srcPath, destPath, oneNum
					* i, oneNum * (i + 1));
			ct.start();
			list.add(ct);
		}

		// 文件长度不能整除的部分放到最后一段处理
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