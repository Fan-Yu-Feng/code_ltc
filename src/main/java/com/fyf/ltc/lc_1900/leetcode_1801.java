package com.fyf.ltc.lc_1900;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1801 {
	
	
	public static void main(String[] args) {
		
		int[][] arr = new int[][]{{26, 7, 0}, {16, 1, 1}, {14, 20, 0}, {23, 15, 1}, {24, 26, 0}, {19, 4, 1}, {1, 1, 0}};
		int numberOfBacklogOrders = getNumberOfBacklogOrders(arr);
		
		System.out.println("numberOfBacklogOrders = " + numberOfBacklogOrders);
		
		
	}
	
	public static int getNumberOfBacklogOrders(int[][] orders) {
		// 双优先队列 大小堆
		// 销售订单 最小堆 从小到大排序
		Queue<int[]> sellOrder = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		// 采购订单-最大堆 从大到小排序
		Queue<int[]> buyOrder = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		
		for (int[] order : orders) {
			int price = order[0], count = order[1], orderType = order[2];
			// 1 为销售订单
			if (orderType == 1) {
				// 当购买订单最大的采购额度大于当前的销售订单时，则相互抵消
				while (count > 0 && !buyOrder.isEmpty() && buyOrder.peek()[0] >= price) {
					int[] peek = buyOrder.poll();
					// 消除最小的采购数量
					int minCount = Math.min(peek[1], count);
					peek[1] -= minCount;
					count -= minCount;
					// 采购订单还有剩余
					if (peek[1] > 0) {
						buyOrder.offer(peek);
					}
				}
				// 销售订单有剩余
				if (count > 0) {
					sellOrder.offer(new int[]{price, count});
				}
			} else {
				while (count > 0 && !sellOrder.isEmpty() && sellOrder.peek()[0] <= price) {
					int[] peek = sellOrder.poll();
					int minCount = Math.min(peek[1], count);
					peek[1] -= minCount;
					count -= minCount;
					if (peek[1] > 0) {
						sellOrder.offer(peek);
					}
				}
				if (count > 0) {
					buyOrder.offer(new int[]{price, count});
				}
			}
		}
		
		int total = 0;
		for (Queue<int[]> pq : Arrays.asList(buyOrder, sellOrder)) {
			while (!pq.isEmpty()) {
				int[] order = pq.poll();
				total = (total + order[1]) % 1000000007;
			}
		}
		return total;
	}
}