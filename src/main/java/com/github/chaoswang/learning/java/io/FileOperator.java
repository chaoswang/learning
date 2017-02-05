package com.github.chaoswang.learning.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class FileOperator {
	
	//���ַ�д�ļ�
	public static void writeFileByCharacter(String filePath){
		OutputStreamWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			fw.write("test line 1 \r\n");
			fw.write("������  2 \r\n");
			fw.write("test line 3 \r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(filePath + " created.");
	}
	
	//���ַ����ļ�
	public static void readFileByCharacter(String filePath){
		InputStreamReader fr = null;
		try {
			fr = new FileReader(filePath);
			char[] cbuf = new char[1024];//ͨ����Ϊ1024�ı���
			int index = 0;
			while((index = fr.read(cbuf)) != -1){
				//����read�����ڶ�������ĩβǰ���˷���һֱ����������ѭ������ʵ��ֻ���ӡһ��
				System.out.println("current index:"+index);
				System.out.println(new String(cbuf,0,index));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//ʹ�û����������ļ�
	public static void copyFileByBufferedWriter(String srcFilePath, String destFilePath){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			br = new BufferedReader(new FileReader(srcFilePath));
			bw = new BufferedWriter(new FileWriter(destFilePath));
			String readStr = null;
			while((readStr = br.readLine()) != null){
				System.out.println(readStr);
				bw.write(readStr);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//���ֽ�д�ļ�
	public static void writeFileByByte(String filePath){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write("test line 1 \r\n".getBytes());
			fos.write("������  2 \r\n".getBytes());
			fos.write("test line 3 \r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(filePath + " created.");
	}
	
	//���ֽڶ��ļ�
	public static void readFileByByte(String filePath){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			byte[] bbuf = new byte[fis.available()];//�Ӵ��������ж�ȡ�Ĺ���ʣ���ֽ���
			int index = 0;
			while((index = fis.read(bbuf)) != -1){
				//����read�����ڶ�������ĩβǰ���˷���һֱ����������ѭ������ʵ��ֻ���ӡһ��
				System.out.println("current index:"+index);
				System.out.println(new String(bbuf));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyImageByBufferedWriter(String srcFilePath, String destFilePath){
		BufferedInputStream fis = null;
		BufferedOutputStream fos = null;
		try{
			fis = new BufferedInputStream(new FileInputStream(srcFilePath));
			fos = new BufferedOutputStream(new FileOutputStream(destFilePath));
			int index = 0;
			//read������һ���ֽ�һ���ֽڶ�
			while((index = fis.read()) != -1){
				System.out.println(index);
				fos.write(index);
				fos.flush();
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Charset.defaultCharset());
	}
	
	//ת��������ָ������д�ļ�
	public static void writeFileBySpecificCharacter(String filePath){
		OutputStreamWriter fw = null;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
			fw.write("test line 1 \r\n");
			fw.write("������  2 \r\n");
			fw.write("test line 3 \r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(filePath + " created.");
	}
	
	//���ַ����ļ�
	public static void readFileBySpecificCharacter(String filePath){
		InputStreamReader fr = null;
		try {
			fr = new InputStreamReader(new FileInputStream(filePath), "gbk");
			char[] cbuf = new char[1024];//ͨ����Ϊ1024�ı���
			int index = 0;
			while((index = fr.read(cbuf)) != -1){
				//����read�����ڶ�������ĩβǰ���˷���һֱ����������ѭ������ʵ��ֻ���ӡһ��
				System.out.println("current index:"+index);
				System.out.println(new String(cbuf,0,index));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
