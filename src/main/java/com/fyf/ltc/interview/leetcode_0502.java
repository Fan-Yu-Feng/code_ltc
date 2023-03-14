package com.fyf.ltc.interview;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_0502 {
	
	
	public static void main(String[] args) {
		
		
		printBin(0.625);
	}
	
	
	public static String printBin(double num) {
		// num 转二进制 str  num 最多只有 6 位
		// 2^6
		StringBuilder stringBuilder = new StringBuilder("0.");
		//
		for (int i = 0; i < 6; i++) {
			num *= 2;
			if (num >= 1) {
				stringBuilder.append("1");
				if (--num == 0) {
					return stringBuilder.toString();
				}
			} else {
				stringBuilder.append("0");
			}
		}
		return "ERROR";
	}
	
}