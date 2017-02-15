package com.jel.tech.interview.jiuyijinrong;

import java.util.Arrays;

/**
 * 随便给定一个字符串，输出出现字符次数最多的那个字符及出现次数
 * @author zhenhua
 *
 */
public class Test01 {

	public static void main(String[] args) {
		
		String s = "aagsgdsgdbddgdgsuexgcv";
		
		char [] charArray = s.toCharArray();
		System.out.println(charArray);
		
		Arrays.sort(charArray);
		System.out.println(charArray);
		
		handle(charArray);
	}

	private static void handle(char[] charArray) {
		
		int k = 0;
		char c = charArray[0];
		int max = 0;
		char maxChar = charArray[0];
		int len = charArray.length;
		
//		System.out.println(len);
		for(int i=0; i<len;) {
			while(i<len && c == charArray[i]) {
				i++;
				k++;
			}
			if(max < k) {
				max = k;
				k = 0;
				maxChar = charArray[i-1];
			} else {
				k = 0;
			}
			if(i<len) {
				c = charArray[i];
			}
		}
		System.out.println(max);
		System.out.println(maxChar);
	}
}
