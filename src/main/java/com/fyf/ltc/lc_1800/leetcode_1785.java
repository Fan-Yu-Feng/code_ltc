package com.fyf.ltc.lc_1800;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1785 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minElements(int[] nums, int limit, int goal) {
		long sum = Arrays.stream(nums).asLongStream().sum();
		
		long diff = Math.abs(sum - goal);
		// 向上取整 [diff / limit]  整除则为 diff/limit 不整除 则需要 + 1
		return (int) ((diff + limit - 1) / limit);
	}
	
	public int minElements2(int[] nums, int limit, int goal) {
		
		long sum = 0;
		// 运算速度比上面的快
		for (int x : nums) {
			sum += x;
		}
		
		long diff = Math.abs(sum - goal);
		// 向上取整 [diff / limit]  整除则为 diff/limit 不整除 则需要 + 1
		return (int) ((diff + limit - 1) / limit);
	}
	
}