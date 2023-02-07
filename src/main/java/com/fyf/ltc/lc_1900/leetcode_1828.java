package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1828 {
	
	
	public static void main(String[] args) {
		int[][] points = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
		int[][] queries = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
		
		int[] ints = countPoints(points, queries);
		for (int x : ints) {
			System.out.println("x = " + x);
		}
	}
	
	public static int[] countPoints(int[][] points, int[][] queries) {
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] arr = queries[i];
			double x = arr[0], y = arr[1], r = arr[2];
			int ans = 0;
			for (int[] p : points) {
				double p1 = p[0], p2 = p[1];
				if ((Math.pow((x - p1), 2) + Math.pow((y - p2), 2)) <= r * r) {
					++ans;
				}
			}
			res[i] = ans;
		}
		return res;
	}
	
}