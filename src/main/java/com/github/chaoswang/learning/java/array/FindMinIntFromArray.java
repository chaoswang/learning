package com.github.chaoswang.learning.java.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinIntFromArray {
	
	//找出数组中最小的值
	public static int findMinInt(int[] objectArray){
		int min = objectArray[0];
		for(int element : objectArray){
			if(min > element){
				min = element;
			}
		}
		return min;
	}
	
	
	public static int findMinIntUsingSort(int[] objectArray){
		Arrays.sort(objectArray);
		return objectArray[0];
	}
	
	//反转数组中数
	public static int[] reverseArray(int[] objectArray){
		int length = objectArray.length;
		for(int i=0;i<length/2;i++){
			int tmp = objectArray[i];
			objectArray[i] = objectArray[length -1 - i];
			objectArray[length -1 - i] = tmp;
		}
		return objectArray;
	}
	
	//Arrays.asList只能对对象数组进行转换，参数只能是Integer[]
	public static Integer[] reverseArrayUsingCollection(Integer[] objectArray){
		List<Integer> list = Arrays.asList(objectArray);
		Collections.reverse(list);
		return list.toArray(new Integer[0]);
	}
}
