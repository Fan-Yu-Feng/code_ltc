package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2303 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public double calculateTax(int[][] brackets, int income) {
		double ans = 0;
		int pre = 0;
		for (int x[] :
				brackets) {
			int upper = Math.min(income,x[0]), percent = x[1];
			int tax =Math.max(upper - pre,0)* percent;
			pre =upper;
			ans += tax;
		}
		
		return ans/100.0;
	}

}