package com.fyf.ltc.lc_1600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1590 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minSubarray(int[] nums, int p) {
		int n = nums.length;
		int k = 0, ans = n;
		// 计算前缀和 以及前缀和 mod p 的值
		for (int x : nums) {
			k = (k + x) % p;
		}
		if(k == 0){
			return 0;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int cur = 0;
		for (int i = 0; i < n; i++) {
			// cur 为 前缀和的 mod p 的值
			cur = (cur + nums[i]) % p;
			// 前缀和 mod p 的值 为 (target + k - cur ) mod p == 0 删除 j + 1 ~ i 的子数组使得剩余元素的和mod p 为 0
			int target = (cur - k + p) % p;
			if (map.containsKey(target)) {
				ans = Math.min(ans, i - map.get(target));
			}
			map.put(cur, i);
		}
		return ans == n ? -1 : ans;
	}
}