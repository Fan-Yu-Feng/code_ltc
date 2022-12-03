package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1752 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public static boolean check(int[] nums) {
		int len = nums.length;
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] > nums[(i + 1) % len]) {
				++cnt;
			}
		}
		return cnt < 2;
	}
}