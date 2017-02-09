package com.github.chaoswang.runnable.example.java8.lambda;

public class StringFunctionImpl {
	public String getString(StringFunction s){
		return s.apply("functional programming.");
	}
	
	public static void main(String[] args) {
		//before java8
		StringFunctionImpl impl = new StringFunctionImpl();
		String returnStr = impl.getString(new StringFunction(){

			@Override
			public String apply(String s) {
				return s.toUpperCase();
			}
			
		});
		System.out.println(returnStr);
		
		//java 8
		System.out.println(impl.getString((s) -> s.toUpperCase()));
	}
}
