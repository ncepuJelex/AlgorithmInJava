package com.jel.tech.algorithm;

import java.util.Arrays;

/**
 * 一个数组大小为N,对它排列，使奇数在前，偶数在后，只有O(1)空间使用。
 * @author zhenhua
 * 2017年2月16日
 */
public class OddAndEventSortTest {

	public static void main(String[] args) {
		
		int [] arr = new int[]{1,3,4,6,5,8,9,10,11,13,15,14};
		System.out.println(Arrays.toString(arr));
		oddAndEventSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void oddAndEventSort(int [] arr) {
		int temp = 0;
		int len = arr.length;
		int j = 0;
		
		for(int i=0; i<len;) {
			//运气好的话，前几个可能都是奇数，可以跳过了哈~
			while(arr[i] % 2 == 1) {
				i++;
			}
			/*
			 * 此时，下标为i是第一个偶数，
			 * 从下一项开始遍历，
			 * 要找它后面的第一个奇数
			 */
			for(j=i+1; j<len;) {
				//防止数组越界并且找到的一直是偶数，那就跳过呗，毕竟是要找下标为i后面
				//的第一个【奇数】
				while(j<len&&arr[j] % 2 == 0) {
					j++;
				}
				//防止数组越界异常
				if(j<len) {
					//跳出了上面的while循环，说明此时下标为j的数字为奇数
					//交换下标为i、j的值
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				//数组下标递增，从下一项开始遍历处理
				i++;
				//跳出里层for循环
				break;
			}
			//说明数组后面都是偶数，不用再循环下去了
			//这是代码的38-40行的所产生的效果
			if(j==len) {
				break;
			}
		}
	}
}
