package com.github.chaoswang.learning.java.io;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

public class FileOperatorTest {
	
	private final static String testPath = "src"+File.separator+"test"+File.separator+"java"
			+File.separator+"com"+File.separator+"github"+File.separator+"chaoswang"
			+File.separator+"learning"+File.separator+"java"+File.separator+"io"+File.separator;
			
	private final static String testFile1 = testPath +"Demo.txt";
	
	private final static String testFile2 = testPath +File.separator+"copy" +File.separator+ "Demo.txt";
	
	private final static String testFile3 = testPath +File.separator+"Demo.jpg";
	
	private final static String testFile4 = testPath +File.separator+"copy" +File.separator+ "Demo.jpg";
	
	private final static String testFile5 = testPath +File.separator+"Duck.class";
	
//	@Test
	@Ignore
	public void testReadFileByCharacter(){
		FileOperator.writeFileByCharacter(testFile1);
		FileOperator.readFileByCharacter(testFile1);
	}
	
//	@Test
	@Ignore
	public void testCopyFileByBufferedWriter(){
		FileOperator.copyFileByBufferedWriter(testFile1, testFile2);
	}
	
//	@Test
	@Ignore
	public void testReadFileByByte(){
		FileOperator.writeFileByCharacter(testFile1);
		FileOperator.readFileByCharacter(testFile1);
	}
	
//	@Test
	@Ignore
	public void testCopyImageByBufferedWriter(){
		FileOperator.copyImageByBufferedWriter(testFile3, testFile4);
	}
	
//	@Test
	@Ignore
	public void testReadFileBySpecificCharacter(){
		FileOperator.writeFileBySpecificCharacter(testFile1);
		FileOperator.readFileBySpecificCharacter(testFile1);
	}
	
	@Test
//	@Ignore
	public void testReadClassFile(){
		FileOperator.readClassFile(testFile5);
	}
}
