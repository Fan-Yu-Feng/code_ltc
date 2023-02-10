package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2319 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean checkXMatrix(int[][] grid) {
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; ++j) {
				if(i == j || i + j == n - 1){
					if(grid[i][j] == 0){
						return false;
					}
				}else {
					if(grid[i][j]!=0){
						return false;
					}
				}
			}
		}
		return true;
	}
	

}