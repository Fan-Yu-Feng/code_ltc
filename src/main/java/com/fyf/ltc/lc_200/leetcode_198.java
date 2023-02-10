package com.fyf.ltc.lc_200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_198 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int rob(int[] nums) {
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		int[] arr = new int[nums.length];
		arr[0] = nums[0];
		arr[1] = Math.max(nums[0], nums[1]);
		// 贪心：相邻房间只能拿一间 则 当前房间 x + arr [i-2] | arr [i-1]
		for (int i = 2; i < nums.length; i++) {
			arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
		}
		
		return arr[nums.length - 1];
	}
	
	
}