package com.fyf.ltc.competition.double91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2465 {
	
	
	public static void main(String[] args) {
	
	
	}
	
	
	public  static int distinctAverages(int[] nums) {
		// 统计最大值和最小值的平均数  1、排序 2、用  set 去重
		Set<Integer> set = new HashSet<>();
		int left = 0, right = nums.length -1;
		Arrays.sort(nums);
		while (left < right){
			set.add(nums[left++] + nums[right--]);
		}
		return set.size();
	}
}