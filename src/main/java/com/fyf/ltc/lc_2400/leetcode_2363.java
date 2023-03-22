package com.fyf.ltc.lc_2400;

import java.util.*;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2363 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
		List<List<Integer>> ans = new ArrayList<>();
		
		// hash table
		HashMap<Integer, Integer> map = new HashMap<>();
		

		setMap(items1, map);
		setMap(items2, map);
		
		
		for (Integer key : map.keySet()) {
			ans.add(Arrays.asList(key,map.get(key)));
		}
		ans.sort(Comparator.comparingInt(a -> a.get(0)));
		
		return ans;
	}
	
	private static void setMap(int[][] items1, HashMap<Integer, Integer> map) {
		for (int[] ints : items1) {
			int x = ints[0], y = ints[1];
			map.put(x, map.getOrDefault(x, 0) + y);
		}
	}
	
}