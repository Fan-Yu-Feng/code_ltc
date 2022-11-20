package com.fyf.ltc.lc_800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_799 {
	
	
	public static void main(String[] args) {
		double v = champagneTower(100000009, 33, 17);
		
		System.out.println("v = " + v);
		
	}
	
	
	public static double champagneTower(int poured, int query_row, int query_glass) {
		
		double[][] dp = new double[query_row + 2][query_row + 2];
		// 防止越界 dp 二维数组 下标（1,1） 存储第 0 行的数据
		dp[1][1] = poured;
		
		
		for (int i = 2; i < query_row + 2; ++i) {
			for (int j = 1; j <= i; ++j) {
				// 存储 第 i 行 j 杯的酒杯容量
				dp[i][j] = Math.max(dp[i - 1][j - 1] - 1, 0) / 2 + Math.max(dp[i - 1][j] - 1, 0) / 2;
			}
		}
		return Math.min(dp[query_row + 1][query_glass + 1], 1);
	}
	
}