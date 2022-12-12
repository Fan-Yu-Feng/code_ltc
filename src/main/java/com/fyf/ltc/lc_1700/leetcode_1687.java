package com.fyf.ltc.lc_1700;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1687 {
	
	
	public static void main(String[] args) {
		int[][] boxes = new int[][]{{1, 1}, {2, 1}, {1, 1}};
		int portsCount = 2, maxBoxes = 3, mxaWeight = 3;
		int i = boxDelivering(boxes, portsCount, maxBoxes, mxaWeight);
		System.out.println("i = " + i);
		i = boxDelivering2(boxes, portsCount, maxBoxes, mxaWeight);
		System.out.println("i = " + i);
		i = boxDelivering3(boxes, portsCount, maxBoxes, mxaWeight);
		System.out.println("i = " + i);
		

	}
	
	
	/**
	 * 将所有箱子送到相应码头的 最少行程 次数。
	 * 卡车从 boxes 队列中按顺序取出若干个箱子，但不能违反 maxBoxes 和 maxWeight 限制。
	 * 对于在卡车上的箱子，我们需要 按顺序 处理它们，卡车会通过 一趟行程 将最前面的箱子送到目的地码头并卸货。如果卡车已经在对应的码头，那么不需要 额外行程 ，箱子也会立马被卸货。
	 * 卡车上所有箱子都被卸货后，卡车需要 一趟行程 回到仓库，从箱子队列里再取出一些箱子。
	 *
	 * @param boxes      boxes[i] = [ports i​, weight i] ports​​i 表示第 i 个箱子需要送达的码头， weights i 是第 i 个箱子的重量。
	 * @param portsCount 是码头的数目
	 * @param maxBoxes   卡车运输箱子数量限制
	 * @param maxWeight  重量的限制
	 *
	 * @return 最少行程 次数。
	 */
	public static int boxDelivering2(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		
		// 35/39 个通过测试用例，超出时间限制
		int length = boxes.length;
		long[] ws = new long[length + 1];
		int[] cs = new int[length];
		for (int i = 0; i < length; ++i) {
			int p = boxes[i][0], w = boxes[i][1];
			ws[i + 1] = ws[i] + w;
			if (i < length - 1) {
				cs[i + 1] = cs[i] + (p != boxes[i + 1][0] ? 1 : 0);
			}
		}
		int[] f = new int[length + 1];
		Arrays.fill(f, 1 << 30);
		f[0] = 0;
		
		for (int i = 1; i <= length; ++i) {
			for (int j = Math.max(0, i - maxBoxes); j < i; ++j) {
				if (ws[i] - ws[j] <= maxWeight) {
					// 使用单调队列，在 O(1) 的时间复杂度内获取满足条件的最小值
					f[i] = Math.min(f[i], f[j] + cs[i - 1] - cs[j] + 2);
				}
			}
		}
		return f[length];
	}
	
	public static int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		
		// dp  + 单调队列实现
		int length = boxes.length;
		long[] ws = new long[length + 1];
		int[] cs = new int[length];
		for (int i = 0; i < length; ++i) {
			int p = boxes[i][0], w = boxes[i][1];
			// 记录重量之和，因为是按顺序装载货物，按顺序记录前缀
			ws[i + 1] = ws[i] + w;
			if (i < length - 1) {
				// 记录码头号是否一样
				cs[i + 1] = cs[i] + (p != boxes[i + 1][0] ? 1 : 0);
			}
		}
		// dp
		int[] f = new int[length + 1];
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(0);
		for (int i = 1; i <= length; ++i) {
			// 超过要求的重量|货物数量，则出栈
			while (!q.isEmpty() && (i - q.peekFirst() > maxBoxes || ws[i] - ws[q.peekFirst()] > maxWeight)) {
				// 去除头部数据
				q.pollFirst();
			}
			// 记录当前的形成数量
			if (!q.isEmpty()) {
				// 与上一个码头号是否相同? 1:0  + dp  + 最少两趟
				f[i] = cs[i - 1] + f[q.peekFirst()] - cs[q.peekFirst()] + 2;
			}
			if (i < length) {
				while (!q.isEmpty() && f[q.peekLast()] - cs[q.peekLast()] >= f[i] - cs[i]) {
					// 去除队列尾部数据
					q.pollLast();
				}
				q.offer(i);
			}
		}
		return f[length];
	}
	
	
	// https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/solution/by-tizzi-4ubq/
	public static int boxDelivering3(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		int n = boxes.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1 << 30);
		dp[0] = 0;
		
		for (int i = 1; i <= n; ++i) {
			int sum = 0;
			// j 在 1 ~ maxBoxes 范围内
			for (int j = i; j >= 1 && j >= i - maxBoxes; --j) {
				// 携带箱子总重量
				sum += boxes[j - 1][1];
				if (sum > maxWeight ) {
					// 超出最大重量
					break;
				}
				dp[i] = Math.min(dp[i - 1] + cost(boxes, j, i), dp[i]);
			}
		}
		return dp[n];
	}
	
	/**
	 * 判断 运输 boxes l ~ r 范围内的箱子需要多少躺
	 */
	private static int cost(int[][] boxes, int l, int r) {
		// 初始 ans 为 2 来回一趟路程为2
		int ans = 2, port = boxes[l - 1][0];
		while (++l <= r) {
			if (boxes[l - 1][0] == port) {
				continue;
			}
			// 如果港口不一致则 ans 需要 +1
			++ans;
			port = boxes[l - 1][0];
		}
		return ans;
	}
}