package com.fyf.ltc.lc_1400;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1394 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int findLucky(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int ans = -1;
		for (int x : arr) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for (Integer x : map.keySet()) {
			if (Objects.equals(map.get(x), x)) {
				ans = Math.max(x, ans);
			}
		}
		
		return ans;
	}
	
}