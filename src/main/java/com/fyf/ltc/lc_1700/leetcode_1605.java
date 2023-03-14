package com.fyf.ltc.lc_1700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1605 {
	
	
	public static void main(String[] args) {
	
	}
	
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int n = rowSum.length, m = colSum.length;
		
		int matrix [][] = new int[n][m];
		
		int i =0 , j =0;
		while (i <n && i <m){
			int v = Math.min(rowSum[i],colSum[j]);
			matrix[i][j] = v;
			rowSum[i] -=v;
			colSum[j] -=v;
			if(rowSum[i] == 0){
				++i;
			}
			if(colSum[j] == 0){
				++j;
			}
		}
		
		return matrix;
	}
}