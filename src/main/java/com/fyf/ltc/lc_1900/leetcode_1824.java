package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1824 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minSideJumps(int[] obstacles) {
		// 动态规划
		final int inf = 1 << 30;
		int[] f = {1, 0, 1};
		int ans = inf;
		for (int i = 0; i < obstacles.length; i++) {
			for (int j = 0; j < 3; j++) {
				// obstacles [i] j+ 1 条道路有障碍
				if(j+1 == obstacles[i]){
					f[j] = inf;
					// 只有一条道路有石头
					break;
				}
			}
			// x 需要侧翻
			int x = Math.min(f[0], Math.min(f[1], f[2])) + 1;
			for (int j = 0; j < 3; j++) {
				if (obstacles[i] != j + 1) {
					// 不需要侧翻的路
					f[j] = Math.min(f[j], x);
				}
			}
		}
		return Math.min(f[0], Math.min(f[1], f[2]));
	}

}