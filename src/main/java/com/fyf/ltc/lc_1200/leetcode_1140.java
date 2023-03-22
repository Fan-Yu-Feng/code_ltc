package com.fyf.ltc.lc_1200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1140 {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 	链接：<a href="https://leetcode.cn/problems/stone-game-ii/solution/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-jjax/">...</a>
	 * @param piles
	 * @return
	 */
	public int stoneGameII(int[] piles) {
		int s = 0, n = piles.length;
		int[][] f = new int[n][n + 1];
		for (int i = n - 1; i >= 0; --i) {
			s += piles[i];
			for (int m = 1; m <= i / 2 + 1; ++m) {
				if (i + m * 2 >= n) {
					f[i][m] = s;
				} else {
					int mn = Integer.MAX_VALUE;
					for (int x = 1; x <= m * 2; ++x) {
						mn = Math.min(mn, f[i + x][Math.max(m, x)]);
					}
					f[i][m] = s - mn;
				}
			}
		}
		return f[0][1];
	}
	
	
	
}