package com.fyf.ltc.lc_100;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2024/03/10
 */
public class leetcode_80 {
	
	
	public static void main(String[] args) {
		int [] num  = {1,1,1,2,2,3};
		removeDuplicates(num);
		// 	打印num
		Arrays.stream(num).forEach(n -> System.out.print(n + " "));
	}
	
	
	
	public static int removeDuplicates(int[] nums) {
		// 双指针
		if (nums.length < 2) {
			return nums.length;
		}
		int slow = 2, fast = 2;
		while(fast < nums.length) {
			if (nums[slow - 2] != nums[fast]) {
				nums[slow++] = nums[fast];
			}
			fast++;
		}
		return slow;
	}
}