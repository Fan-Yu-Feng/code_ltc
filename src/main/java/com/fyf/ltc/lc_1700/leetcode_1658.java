package com.fyf.ltc.lc_1700;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1658 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minOperations(int[] nums, int x) {
		// 双指针 + 滑动窗口
		int sum = Arrays.stream(nums).sum();
		int n = nums.length;
		int ans = n + 1;
		int lSum = 0, rSum = sum;
		int r = 0;
		for (int l = -1; l < n; l++) {
			if (l != -1) {
				lSum += nums[l];
			}
			while (r < n && rSum + lSum > x ){
				rSum -= nums[r++];
			}
			if(lSum + rSum == x){
				ans = Math.min(ans, (l + 1) + (n - r));
			}
		}
		return  ans > n ? -1 : ans;
	}
	
}