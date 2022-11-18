package com.fyf.ltc.lc_800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_775 {
	
	
	public static void main(String[] args) {
		
	}
	
	public static boolean isIdealPermutation(int[] nums) {
		int length =nums.length;
		int max = -1;
		
		for(int i = 0; i < length -2 ; ++i) {
			// 存在一组 nums[i] > nums[i+2] 那么就是全局倒置 而不是局部倒置 然而局部倒置一定是全局倒置 因此返回 false
			max = Math.max(max, nums[i]);
			if(max > nums[i+2]){
				return false;
			}
		}
		return true;
	}
	public static boolean isIdealPermutation2(int[] nums) {
		int length =nums.length;
		// 只要 i 和 nums[i] 相差大于1 那么出现了全局倒置，而不是局部倒置
		for(int i = 0; i < length ; ++i) {
			if(	Math.abs(nums[i] -i) > 1){
				return false;
			}
		}
		return true;
	}
	
}