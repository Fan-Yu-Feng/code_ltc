package com.fyf.ltc.lc_300;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_239 {
	
	
	public static void main(String[] args) {
		
		int [] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		int[] ints = maxSlidingWindow(nums, k);
		System.out.println("ints = " + Arrays.toString(ints));
		method();
		
	}
	
	public static void method() {
	}
	
	/**
	 * 滑动窗口最大的值
	 *
	 * @param nums 数组
	 * @param k    滑动窗口长度
	 *
	 * @return 滑动窗口中最大的值
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		// 滑动窗口去除最大值，可以使用基于最大堆的优先队列
		// 1、将 [0,k-1] 的数据存到队列中，并且存入 nums[i] 以及对应的下标加入队列
		// 2、如果优先队列的队列首元素的对应下标 小于等于 i-k（不在滑动窗口内）则将队首元素移除，重复该过程直到优先队列的队首元素对应下标大于 i-k
		// 3、将优先级队列的队首元素赋给 maxArray[i-k+1]
		
		int length = nums.length;
		// 答案的数组大小 为 Len - k + 1
		int []maxArray = new int[length - k + 1];
		
		PriorityQueue<int []> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		
		for(int i = 0; i < k; ++i) {
			priorityQueue.offer(new int[] {nums[i],i});
		}
		maxArray[0] = priorityQueue.peek()[0];
		
		for(int i = k; i < length; ++i) {
			priorityQueue.offer(new int[] {nums[i],i});
			while(priorityQueue.peek()[1]<= i-k){
				priorityQueue.poll();
			}
			maxArray[i - k + 1 ] = priorityQueue.peek()[0];
		}
		return maxArray;
	}
	
}