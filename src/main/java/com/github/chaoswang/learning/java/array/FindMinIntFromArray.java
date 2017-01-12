package com.github.chaoswang.learning.java.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinIntFromArray {
	
	//�ҳ���������С��ֵ
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
	
	//��ת��������
	public static int[] reverseArray(int[] objectArray){
		int length = objectArray.length;
		for(int i=0;i<length/2;i++){
			int tmp = objectArray[i];
			objectArray[i] = objectArray[length -1 - i];
			objectArray[length -1 - i] = tmp;
		}
		return objectArray;
	}
	
	//Arrays.asListֻ�ܶԶ����������ת��������ֻ����Integer[]
	public static Integer[] reverseArrayUsingCollection(Integer[] objectArray){
		List<Integer> list = Arrays.asList(objectArray);
		Collections.reverse(list);
		return list.toArray(new Integer[0]);
	}
}
