package com.fyf.ltc.lc_2000;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1945 {
	
	
	public static void main(String[] args) {
		
		int zbax = getLucky("iiii", 1);
		System.out.println("zbax = " + zbax);
	}
	
	
	public static int getLucky(String s, int k) {
		int x = 0;
		// 存储转化为数字后的字符串结果
		StringBuilder sb = new StringBuilder();
		// 初始化刚开始的数字
		for (char c :
				s.toCharArray()) {
			sb.append(c - 'a' + 1);
		}
		// 初始化第一次的数字结果
		for (int i = 0; i < sb.length(); i++) {
			x += sb.charAt(i) - '0';
		}
		s = Integer.toString(x);
		// 如果长度为1 则返回
		if (s.length() == 1) {
			return x;
		}
		//  k -1 大于0 则不断模拟字符串转数字的过程
		while (--k > 0) {
			sb.setLength(0);
			x = 0;
			for (char c :
					s.toCharArray()) {
				sb.append(c - '0');
			}
			
			for (int i = 0; i < sb.length(); i++) {
				x += sb.charAt(i) - '0';
			}
			// 如果长度为1 则返回
			s = Integer.toString(x);
			if (s.length() == 1) {
				return x;
			}
		}
		return x;
	}
	
}