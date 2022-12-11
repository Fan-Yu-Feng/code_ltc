package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1827 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int minOperations(int[] nums) {
		int ans = 0;
		int length = nums.length;
		if (length == 1) {
			return 0;
		}
		
		for (int i = 0; i < length - 1; i++) {
			if (nums[i + 1] <= nums[i]) {
				ans +=  nums[i] - nums[i+1] + 1;
				nums[i + 1] = nums[i] + 1;
			}
		}
		return ans;
	}
	
	
}