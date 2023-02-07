package com.fyf.ltc.lc_1900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1817 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] log : logs) {
			int id = log[0], times = log[1];
			map.putIfAbsent(id, new HashSet<>());
			map.get(id).add(times);
		}
		int[] ans = new int[k];
		for (Integer key : map.keySet()) {
			Set<Integer> set = map.get(key);
			ans[set.size()-1]++;
		}
		return ans;
	}
	
}