package com.fyf.ltc.competition.week331;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2560 {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 打家劫舍: 可以偷取 k 家不相邻的金额，共有 n 种窃取方式，arr[n] ， arr[i] 均记录窃取的最大金额
	 * 返回 arr 中最少的窃取能力
	 *
	 * @param nums
	 * @param k
	 *
	 * @return
	 */
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
}