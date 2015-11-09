package com.github.chaoswang.learning.java.collection.queue.blocking;

import java.io.File;
import java.util.concurrent.BlockingQueue;

class FileEnumerationTask implements Runnable {  
    //��Ԫ�ļ����󣬷��������������������ʾ�ļ��ѱ�������  
    public static File DUMMY = new File("");  
  
    private BlockingQueue<File> queue;  
    private File startingDirectory;  
  
    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {  
        this.queue = queue;  
        this.startingDirectory = startingDirectory;  
    }  
  
    public void run() {  
        try {  
            enumerate(startingDirectory);  
            queue.put(DUMMY);//ִ�е�����˵��ָ����Ŀ¼���ļ��ѱ�������  
        } catch (InterruptedException e) {  
        }  
    }  
  
    // ��ָ��Ŀ¼�µ������ļ���File�������ʽ��������������  
    public void enumerate(File directory) throws InterruptedException {  
        File[] files = directory.listFiles();  
        for (File file : files) {  
            if (file.isDirectory())  
				enumerate(file);  
            else  
                //��Ԫ�ط����β�������������������  
                queue.put(file);  
        }  
    }  
}  