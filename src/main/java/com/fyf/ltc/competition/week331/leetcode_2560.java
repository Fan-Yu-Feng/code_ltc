package com.fyf.ltc.competition.week331;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2560 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minCapability(int[] nums, int k) {
		int left = 0, right = (int) 1e9;
		while (left + 1 < right) {
			int mid = (left + right) >>> 1;
			int f0 = 0, f1 = 0;
			for (int x : nums) {
				if (x > mid) {
					f0 = f1;
				} else {
					int tmp = f1;
					f1 = Math.max(f1, f0 + 1);
					f0 = tmp;
				}
			}
			if (f1 >= k) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}
	
	
	public int minCapability2(int[] nums, int k) {
		int n = nums.length;
		int max = 0;
		for (int x : nums) {
			max = Math.max(max, x);
		}
		int l = 0, r = max + 1;
		while (l + 1 < r) {
			int c = l + (r - l) / 2;
			if (check(nums, k, c)) {
				r = c;
			} else {
				l = c;
			}
		}
		return r;
	}
	
	
	/**
	 * 当窃取的最大金额为c时，返回在nums中窃取不相邻的房屋，能窃取的房屋数dp1是否大于等于k
	 *
	 * @param nums 数组
	 * @param k    k
	 * @param c    c
	 * @return boolean
	 */
	private boolean check(int[] nums, int k, int c) {
		int dp0 = 0, dp1 = 0;
		for (int x : nums) {
			if (x > c) {
				dp0 = dp1;
			} else {
				int tmp = dp1;
				dp1 = Math.max(dp1, dp0 + 1);
				dp0 = tmp;
			}
			if (dp1 >= k) {
				return true;
			}
		}
		return false;
	}
	
	
	
}