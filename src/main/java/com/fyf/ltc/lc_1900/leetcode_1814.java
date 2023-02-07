package com.fyf.ltc.lc_1900;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1814 {
	
	
	public static void main(String[] args) {
		int i = countNicePairs(new int[]{13, 10, 35, 24, 76});
		System.out.println("i = " + i);
	}
	
	
	public static int countNicePairs(int[] nums) {
		// nums[i] - rev(nunm[i]) = nums[j] - rev(nums[j])
		final int MOD = 1000000007;
		Map<Integer, Integer> count = new HashMap<>();
		int ans = 0;
		
		for (int x : nums) {
			int y = x - getRev(x);
			ans = (ans + count.getOrDefault(y, 0)) % MOD;
			count.put(y, count.getOrDefault(y, 0) + 1);
			
		}
		return ans;
	}
	
	private static int getRev(int x) {
		// StringBuilder sb = new StringBuilder(String.valueOf(x)).reverse();
		// return Integer.parseInt(sb.toString());
		int y = 0;
		while ( x > 0){
			y = y*10 + x%10;
			x/=10;
		}
		return y;
	}
	
}