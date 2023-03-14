package com.fyf.ltc.lc_2400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2357 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minimumOperations(int[] nums) {
		// 查找不同正整数的数量
		Set<Integer> set = new HashSet<>();
		for (int x :
				nums) {
			if (x != 0) {
				set.add(x);
			}
		}
		return set.size();
	}
}