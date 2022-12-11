package com.fyf.ltc.lc_500;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_456 {
	
	
	public static void main(String[] args) {
		boolean pattern = find132pattern(new int[]{1, 2});
		
		System.out.println("pattern = " + pattern);
		
	}
	
	/**
	 * 记当前下标为 j，需要寻找小于 j 的下标 i 和大于 j 的下标 k，满足 nums[i] < nums[k] < nums[j]。具体做法如下：
	 * <p>
	 * 如果栈不为空且栈顶元素小于或等于 minArray[j]，则将栈顶元素出栈，重复该操作直到栈为空或栈顶元素大于 minArray[j]；
	 * <p>
	 * 如果栈不为空且栈顶元素小于 nums[j]，则返回 true，否则将 nums[j] 入栈。
	 *
	 * @param nums 数组
	 *
	 * @return 是否有满足132 的子序列
	 */
	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		int[] minArray = new int[n];
		minArray[0] = nums[0];
		// 维护 0~i 范围内的最小元素
		for (int i = 1; i < n; i++) {
			minArray[i] = Math.min(minArray[i - 1], nums[i]);
		}
		Deque<Integer> stack = new ArrayDeque<>();
		for (int j = n - 1; j >= 0; j--) {
			int num = nums[j];
			
			while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
				stack.pop();
			}
			// 栈不为空 && 栈顶元素小于 num 则返回 true
			if (!stack.isEmpty() && stack.peek() < num) {
				return true;
			}
			stack.push(num);
		}
		return false;
	}
}