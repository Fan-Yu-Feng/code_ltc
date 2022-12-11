package com.fyf.ltc.lc_1700;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1691 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int maxHeight(int[][] cuboids) {
		
		int n = cuboids.length;
		// 动态规划 f[n] 表示 长方体 i 为底的时候最大高度
		int[] f = new int[n];
		
		for (int[] x :
				cuboids) {
			Arrays.sort(x);
		}
		
		// 根据 arr[x] 中的 1 2 3 位进行排序
		Arrays.sort(cuboids, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// 边界条件====j  长方体的长宽比 i 长方体的长宽更大
				if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
					f[i] = Math.max(f[i], f[j]);
				}
			}
			// 记录高度
			f[i] += cuboids[i][2];
		}
		return Arrays.stream(f).max().getAsInt();
		
	}
	
}