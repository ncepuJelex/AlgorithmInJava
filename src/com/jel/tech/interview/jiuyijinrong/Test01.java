package com.jel.tech.interview.jiuyijinrong;

import java.util.Arrays;

/**
 * 随便给定一个字符串，输出出现字符次数最多的那个字符及出现次数
 * @author Jelex.xu
 *	2017年2月14日
 */
public class Test01 {

	public static void main(String[] args) {
		
		String s = "aagsgdsgdbddgdgsuexgcv";
		//把s转换成char类型的数组
		char [] charArray = s.toCharArray();
		System.out.println(charArray);
		
		//对charArray进入asc码排序，即a排序在前，z在后
		Arrays.sort(charArray);
		System.out.println(charArray);
		
		//调用方法处理
		handle(charArray);
	}

	private static void handle(char[] charArray) {
		
		int k = 0; //保存某个字符出现的次数
		char c = charArray[0]; //待比较的字符，初始化为数组中第一个值
		int max = 0; //某个字符出现最多的次数
		char maxChar = charArray[0]; //保存出现最多的次数字符，初始化为数组中第一个值
		int len = charArray.length;
		
		for(int i=0; i<len;) {
			//使用i<len是为了防止出现数组越界异常
			while(i<len && c == charArray[i]) {
				i++; //遍历递增
				k++; //递增当前字符出现的次数
			}
			/*
			 * 如果当前字符出现的次数超过之前出现次数最大值，则
			 * 让当前新出现的次数最大值替代之前的max值，
			 * 把统计字符出现次数的变量重新初始化为0，并
			 * 把当前统计出的出现最多次数的字符变量保存到maxChar中
			 */
			if(max < k) {
				max = k;
				k = 0;
				maxChar = charArray[i-1];
			}
			//否则，只需把统计字符出现次数的变量重新初始化为0
			else {
				k = 0;
			}
			//防止最后一次循环时出现ArrayIndexOutOfBoundsException
			if(i<len) {
				//把下一个不同的字符赋值给当前比较字符
				c = charArray[i];
			}
		}
		//输出出现次数最多的字符次数及该字符(如果有多个并列的字符，只输出第一个)
		System.out.println(max);
		System.out.println(maxChar);
	}
}
