package com.github.chaoswang.runnable.example.formatter;

public class StringFormatter {
	public static void main(String[] args) {
		String s = String.format("%,d", 100000000);
		System.out.println(s);
	}
}
