package com.fyf.ltc.lc_700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_633 {
	
	
	public static void main(String[] args) {
		
		boolean b = judgeSquareSum(0);
		System.out.println("b = " + b);
		method();
		
	}
	
	public static boolean judgeSquareSum(int c) {
		if(c == 0){
			return true;
		}
		
		// 整数开根号
		int R = (int) Math.sqrt(c);
		// 在 0~R 的整数范围内，用双指针进行求值
		
		int L = 0;
		while (L < R){
			double v = Math.pow(L, 2) + Math.pow(R, 2);
			if(v < c){
				--L;
			}else if( v > c){
				--R;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public static void method() {
	}
	
}