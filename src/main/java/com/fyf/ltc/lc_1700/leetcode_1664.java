package com.fyf.ltc.lc_1700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1664 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int waysToMakeFair(int[] nums) {
		int ans = 0;
		//  s1 偶数下标之和    s2 奇数下标之和
		int s1 = 0, s2 = 0;
		for (int i = 0; i < nums.length; i++) {
			s1 += i % 2 == 0 ? nums[i] : 0;
			s2 += i % 2 == 1 ? nums[i] : 0;
		}
		// t1 t2 记录遍历到当前的元素之和
		int t1 = 0, t2 = 0;
		for (int i = 0; i < nums.length; i++) {
			int v = nums[i];
			// 删除下标 i i为偶数时，下标 i 后续的奇数下标变为偶数，偶数下标的值变为偶数
			if (i % 2 == 0) {
				// t2 + s1 -t1 -v（奇数下标之和） == t1 + s2 - t2(偶数下标之和)
				if (s1 - t1 + t2 - v == t1 + s2 - t2) {
					++ans;
				}
			} else {
				// t1 + s2 -t2 -v (奇数) == t2 + s1 - t1 (偶数)
				if (t1 + s2 - t2 - v == t2 + s1 - t1) {
					++ans;
				}
			}
			t1 += i % 2 == 0 ? v : 0;
			t2 += i % 2 == 1 ? v : 0;
		}
		
		
		return ans;
	}
	
	
}