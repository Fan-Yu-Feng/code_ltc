package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2373 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int[][] largestLocal(int[][] grid) {
		int n = grid.length;
		int [][] ans = new int[n-2][n-2];
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n-2; j++) {
				for (int k = i; k <= i + 2; k++) {
					for (int l = j; l <= j + 2; l++) {
						ans[i][j] = Math.max(ans[i][j], grid[k][l]);
					}
				}
			}
		}
		
		return ans;
	}
	
	
	

}