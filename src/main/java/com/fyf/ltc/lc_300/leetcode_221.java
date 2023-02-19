package com.fyf.ltc.lc_300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_221 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int maximalSquare(char[][] matrix) {
		int ans = 0;
		// 数组长度+1 防止越界
		int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i-1][j-1] == '1') {
					// 如果(i,j)是1，那么以他为右下角的最大正方形边长是
					// {dp[i-1][j-1]，上边的高度，左边的高度}这3个中最小的+1。
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					ans = Math.max(dp[i][j], ans);
				}
			}
		}
		return ans * ans;
	}
	
	
}