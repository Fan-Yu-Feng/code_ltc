package com.fyf.ltc.lc_2100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2032 {
	
	
	public static void main(String[] args) {
		
	}
	
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		int[] s1 = get(nums1), s2 = get(nums2), s3 = get(nums3);
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= 100; ++i) {
			if (s1[i] + s2[i] + s3[i] > 1) {
				ans.add(i);
			}
		}
		return ans;
	}
	
	private int[] get(int[] nums) {
		int[] s = new int[101];
		for (int num : nums) {
			s[num] = 1;
		}
		return s;
	}
	
	
}