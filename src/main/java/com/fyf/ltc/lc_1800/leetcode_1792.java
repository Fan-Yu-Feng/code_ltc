package com.fyf.ltc.lc_1800;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1792 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		
		// 大根堆，维护班级通过率的增量
		Queue<double[]> queue = new PriorityQueue<>((a, b) -> {
			double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
			double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
			return Double.compare(y, x);
		});
		
		for (int[] x : classes) {
			queue.offer(new double[]{x[0], x[1]});
		}
		
		while (extraStudents-- > 0 ){
			double[] poll = queue.poll();
			poll[0]+=1;
			poll[1]+=1;
			queue.offer(poll);
		}
		double ans = 0;
		while (!queue.isEmpty()) {
			double[] poll = queue.poll();
			ans += poll[0] / poll[1];
		}
		return ans / classes.length;
	}
	
}