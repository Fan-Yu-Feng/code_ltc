package com.fyf.ltc.lc_1300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1250 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean isGoodArray(int[] nums) {
		int g = 0;
		for (int x : nums) {
			g = gcd(x, g);
		}
		return g == 1;
	}
	
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	

}