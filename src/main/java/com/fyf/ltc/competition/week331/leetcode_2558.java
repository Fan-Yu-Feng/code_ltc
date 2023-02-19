package com.fyf.ltc.competition.week331;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2558 {
	
	
	public static void main(String[] args) {
		int arr[] = new int[]{25, 64, 9, 4, 100};
		int k = 4;
		pickGifts(arr, k);
		
	}
	
	
	public static long pickGifts(int[] gifts, int k) {
		
		Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for (int x :
				gifts) {
			queue.add(x);
		}
		
		for (int i = 0; i < k; i++) {
			int x = queue.poll();
			double sqrt = Math.sqrt(x);
			queue.offer((int) sqrt);
		}
		long ans = 0;
		for (Integer x : queue) {
			ans+=x;
		}
		return ans;
	}
	
}