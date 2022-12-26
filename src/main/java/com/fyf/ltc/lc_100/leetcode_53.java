package com.fyf.ltc.lc_100;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_53 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int maxSubArray(int[] nums) {
		/*
		1、拆分为以 i 数组下标的数字结尾的子序列状态最大和为多少
		 */
		int length = nums.length;
		int[] dp = new int[length];
		int ans = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < length; i++) {
			if (dp[i - 1] <= 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
	
	public int maxSubArray2(int[] nums) {
		// 前缀和
		int ans = nums[0], pre = 0;
		for (int num : nums) {
			pre = Math.max(pre + num, pre);
			ans = Math.max(ans, pre);
		}
		return ans;
	}
	
}