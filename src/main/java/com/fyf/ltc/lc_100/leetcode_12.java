package com.fyf.ltc.lc_100;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_12 {
	
	
	public static void main(String[] args) {
		
	}
	
	static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	
	public String intToRoman(int num) {
		StringBuilder ans = new StringBuilder();
		int length = VALUES.length;
		for (int i = 0; i < length; i++) {
			String str = SYMBOLS[i];
			// 若 num 大于罗马数字，则将罗马数字拼接到 ans 中，直到数字比当前的还要小
			int value = VALUES[i];
			int count = num / value;
			for (int j = 0; j < count; j++) {
				ans.append(str);
			}
			// 取余
			num %=value;
		}
		return ans.toString();
	}

}