package com.fyf.ltc.lc_1800;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1774 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		// 作者：Tizzi
		// 链接：https://leetcode.cn/problems/closest-dessert-cost/solution/javac-liang-chong-jie-fa-sou-suo-dong-ta-pvwf/
		// 来源：力扣（LeetCode）
		// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		
		boolean[] dp = new boolean[target + 5];
		int ans = Integer.MAX_VALUE;
		//判断只能选基料
		for (int x : baseCosts) {
			if (x > target) {
				ans = Math.min(ans, x);
			} else {
				dp[x] = true;
			}
		}
		for (int x : toppingCosts) {
			//选2次
			for (int i = 0; i < 2; i++) {
				for (int j = target; j >= 0; j--) {
					if (dp[j] && j + x > target) {
						//计算大于的情况
						ans = Math.min(ans, j + x);
					}
					if (j > x) {
						dp[j] |= dp[j - x];
					}
				}
			}
		}
		//ans-target:目前获得与target的差距
		for (int i = 0; i <= ans - target && i <= target; i++) {
			if (dp[target - i]) {
				return target - i;
			}
		}
		return ans;
	}
	
}