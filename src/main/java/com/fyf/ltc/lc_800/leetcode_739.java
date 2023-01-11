package com.fyf.ltc.lc_800;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_739 {
	
	
	public static void main(String[] args) {
		int[] ints = dailyTemperatures(new int[]{30,40,50,60});
		System.out.println("ints = " + Arrays.toString(ints));
		
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
		
		int[] ans = new int[length];
		// 单调栈： 小于当前栈的值则入栈
		// 栈不为空，且栈顶元素大于当前数值，出栈当前元素 j 记录 i-j 到 ans[j]中
		Deque<Integer> deque = new ArrayDeque<>();
		// 73,74,75,71,69,72,76,73
		// 栈顶指针
		for (int i = 0; i < length; ++i) {
			int x = temperatures[i];
			while (!deque.isEmpty() && temperatures[deque.peek()] < x) {
				int j = deque.peek();
				ans[j] = i - j;
				deque.pop();
			}
			deque.push(i);
		}
		return ans;
	}
	
}