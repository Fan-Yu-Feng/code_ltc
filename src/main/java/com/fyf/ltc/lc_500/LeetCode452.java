package com.fyf.ltc.lc_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author FYF
 * @version 1.0
 * @date 2022/10/12 15:51
 */
public class LeetCode452 {
	
	public static void main(String[] args) {
		
		int[][] points = new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{3, 4},
				{4, 5},
		};
		int[][] points2 = new int[][]{
				{9, 12},
				{1, 10},
				{4, 11},
				{8, 12},
				{3, 9},
				{6, 9},
				{6, 7}
		};
		int[][] points1 = new int[][]{
				{-2147483646, -2147483645},
				{2147483646, 2147483647}
		};
		
		
		int minArrowShots = findMinArrowShots(points2);
		System.out.println("minArrowShots = " + minArrowShots);
		
	}
	
	public static int findMinArrowShots(int[][] points) {
		
		// 先按第一个数组进行排序
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? 1 : -1;
			}
		});
		
		
		int length = points.length;
		int min = points[0][0], max = points[0][1];
		int ans = 0;
		
		// 不断缩小最小气球的范围
		for (int i = 1; i < length; i++) {
			if (points[i][0] > max) {
				ans++;
				min = points[i][0];
				max = points[i][1];
			} else {
				if (points[i][0] > min) {
					min = points[i][0];
				}
				if (points[i][1] < max) {
					max = points[i][1];
				}
			}
		}
		return ans + 1;
	}
	
	public static int findMinArrowShots2(int[][] points) {
		
		// 先按第一个数组进行排序
		Arrays.sort(points, (o1, o2) -> o1[1] > o2[1] ? 1 : -1);
		
		int pre = points[0][1];
		int ans = 0;
		
		// 不断缩小最小气球的范围
		for (int[] p : points) {
			if(p[0] > pre){
				pre = p[1];
				ans++;
			}
			
		}
		return ans + 1;
	}
}