package com.fyf.ltc.lc_1700;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1673 {
	
	
	public static void main(String[] args) {
		int[] ints = mostCompetitive(new int[]{3, 5, 2, 6}, 2);
		
		for (int i = 0; i < ints.length; i++) {
			System.out.println("i = " + ints[i]);
		}
		
	}
	
	
	/**
	 * 找出长度为k且最具竞争力的子序列
	 *
	 * @param nums 数组
	 * @param k    长度k
	 *
	 * @return 子序列数组
	 */
	public static int[] mostCompetitive(int[] nums, int k) {
		int n = nums.length;
		
		int[] ans = new int[k];
		// 记录出栈个数
		int remove = n - k;
		Deque<Integer> deque = new ArrayDeque<>(n);
		for (int i = 0; i < n; i++) {
			int x = nums[i];
			while (!deque.isEmpty() && deque.peek() > x && remove > 0){
				deque.pop();
				--remove;
			}
			deque.push(x);
		}
		
		while (--remove >= 0){
			deque.pop();
		}
		
		for (int i = k -1 ; i >= 0; i--) {
			ans[i] = deque.pop();
		}
		return ans;
	}
	
}