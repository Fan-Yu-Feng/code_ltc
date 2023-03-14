package com.fyf.ltc.lc_1400;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1326 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 有一维的花园，长度为 n(包含0)[0-n]  动态规划版本
	 *
	 * @param n      共有n+1个水龙头
	 * @param ranges N+1 长度的数组表示每个水龙头灌溉的区域为 [i-ranges[i], i + ranges[i]] ;
	 *
	 * @return 开水龙头最少的数量
	 */
	public int minTaps(int n, int[] ranges) {
		int[][] list = new int[n + 1][2];
		
		
		for (int i = 0; i < ranges.length; i++) {
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i + ranges[i]);
			list[i] = new int[]{left, right};
		}
		
		Arrays.sort(list, Comparator.comparingInt(a -> a[0]));
		
		int[] dp = new int[n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for (int[] arr : list) {
			int start = arr[0], end = arr[1];
			
			if (dp[start] == Integer.MAX_VALUE) {
				return -1;
			}
			// dp 动态规划 [0,start] 之间的最小覆盖数量
			for (int j = start; j <= end; j++) {
				dp[j] = Math.min(dp[j], dp[start] + 1);
			}
		}
		return dp[n];
	}
	
	/**
	 * 有一维的花园，长度为 n(包含0)[0-n]  贪心算法版本
	 *
	 * @param n      共有n+1个水龙头
	 * @param ranges N+1 长度的数组表示每个水龙头灌溉的区域为 [i-ranges[i], i + ranges[i]] ;
	 *
	 * @return 开水龙头最少的数量
	 */
	
	public int minTaps2(int n, int[] ranges) {
		// rightMost 记录最右端点
		int[] rightMost = new int[n + 1];
		for (int i = 0; i < ranges.length; i++) {
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i + ranges[i]);
			for (int j = left; j < right; j++) {
				rightMost[j] = Math.max(rightMost[j], right);
			}
			
		}
		
		// last 区间最右端点
		int last = 0, ans = 0;
		// 遍历区间为什么是 N ？ 0 - n-1
		while (last < n) {
			// 贪心
			if (rightMost[last] == 0) {
				return -1;
			}
			last = rightMost[last];
			ans++;
		}
		return ans;
	}
	
	
	public int minTaps3(int n, int[] ranges) {
		// rightMost 记录最右端点
		int[] rightMost = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int r = ranges[i];
			// 记录当前最右终点的最大值
			if(i > r){
				// 对于 i-r 来说 i+r 必然是他的最大值
				rightMost[i - r] =  i + r ;
			}else {
				rightMost[0] = Math.max(rightMost[0], i + r );
			}
		}
		// 当前点的最右终点  | 下一个点的最右终点
		int currRight =0 ,  nextRight = 0;
		int ans = 0;
		
		// 没有遍历到   n  已经到终点了
		for (int i = 0; i < n; i++) {
			nextRight = Math.max(nextRight,rightMost[i]);
			if(currRight == i){
				if(nextRight == i){
					return -1;
				}
				++ans;
				currRight = nextRight;
			}
		}
		return ans;
	}
	
	
}