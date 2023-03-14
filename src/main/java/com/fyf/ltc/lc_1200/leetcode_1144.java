package com.fyf.ltc.lc_1200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1144 {
	
	
	public static void main(String[] args) {
		
	}
	public int movesToMakeZigzag(int[] nums) {
		int[] s = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int left = i > 0 ? nums[i-1] : Integer.MAX_VALUE;
			int right = i < nums.length - 1 ? nums[i+1] : Integer.MAX_VALUE;
			// 修改的次数 为 nums[i] - Math.min(r,l) 如果 nums[i] 已经比当前值小 则不需要修改
			s[i % 2] += Math.max(nums[i] - Math.min(right,left) + 1 ,0);
		}
		return Math.min(s[0], s[1]);
	}
}