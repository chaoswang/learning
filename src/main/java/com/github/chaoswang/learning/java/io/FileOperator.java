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
	
	//按字符写文件
	public static void writeFileByCharacter(String filePath){
		OutputStreamWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			fw.write("test line 1 \r\n");
			fw.write("测试行  2 \r\n");
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
	
	//按字符读文件
	public static void readFileByCharacter(String filePath){
		InputStreamReader fr = null;
		try {
			fr = new FileReader(filePath);
			char[] cbuf = new char[1024];//通常设为1024的倍数
			int index = 0;
			while((index = fr.read(cbuf)) != -1){
				//由于read方法在读到流的末尾前，此方法一直阻塞。所以循环体内实际只会打印一次
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
	
	//使用缓冲区拷贝文件
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
	
	//按字节写文件
	public static void writeFileByByte(String filePath){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write("test line 1 \r\n".getBytes());
			fos.write("测试行  2 \r\n".getBytes());
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
	
	//按字节读文件
	public static void readFileByByte(String filePath){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			byte[] bbuf = new byte[fis.available()];//从此输入流中读取的估计剩余字节数
			int index = 0;
			while((index = fis.read(bbuf)) != -1){
				//由于read方法在读到流的末尾前，此方法一直阻塞。所以循环体内实际只会打印一次
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
			//read方法是一个字节一个字节读
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
	
	//转换流，按指定编码写文件
	public static void writeFileBySpecificCharacter(String filePath){
		OutputStreamWriter fw = null;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
			fw.write("test line 1 \r\n");
			fw.write("测试行  2 \r\n");
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
	
	//按字符读文件
	public static void readFileBySpecificCharacter(String filePath){
		InputStreamReader fr = null;
		try {
			fr = new InputStreamReader(new FileInputStream(filePath), "gbk");
			char[] cbuf = new char[1024];//通常设为1024的倍数
			int index = 0;
			while((index = fr.read(cbuf)) != -1){
				//由于read方法在读到流的末尾前，此方法一直阻塞。所以循环体内实际只会打印一次
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
