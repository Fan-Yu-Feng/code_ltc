package com.fyf.ltc.lc_1800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1703 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 题解参考：
	 * <a href="https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/solution/duo-tu-xin-shou-jiao-cheng-yi-bu-bu-dai-6bps4/">...</a>
	 *
	 * @param nums 数组
	 * @param k    k个连续的 1
	 *
	 * @return 移动连续k个1所需要的最少次数
	 */
	public int minMoves(int[] nums, int k) {
		
		List<Integer> pre = new ArrayList<>();
		
		List<Integer> zeros = new ArrayList<>();
		
		pre.add(0);
		
		// 生成 zeros
		generateZeros(nums, zeros);
		
		//第二步：计算第一个窗口的解
		int cost = 0;
		// 在 zeros 上窗口的长度是 k -1 在减去-1得到数组下标
		int left = 0, right = k - 2;
		for (int i = left; i <= right; i++) {
			cost += zeros.get(i) * (Math.min(i + 1, right - i + 1));
		}
		
		int minCost = cost;
		//第三步：开始滑动窗口
		generatePreSum(zeros, pre);
		int i = 1, j = i + k - 2;
		for (; j < zeros.size(); i++, j++) {
			int mid = (i + j) / 2;
			// 滑动窗口：计算窗口中的花费 cost 减去左窗口已经退出的值
			cost -= getRangeSum(i - 1, mid - 1, pre);
			// cost 加上右窗口已经加上的值
			cost += getRangeSum(mid + k % 2, j, pre);
			minCost = Math.min(minCost, cost);
		}
		
		return minCost;
	}
	
	private int getRangeSum(int left, int right, List<Integer> pre) {
		//left和right是zeros上的坐标，返回[left, right]区间内的和，包括两个端点
		return pre.get(right + 1) - pre.get(left);
	}
	
	private void generatePreSum(List<Integer> zeros, List<Integer> pre) {
		for (Integer zero : zeros) {
			// pre[i]代表zeros前i个数的和
			pre.add(pre.get(pre.size() - 1) + zero);
		}
	}
	
	private void generateZeros(int[] nums, List<Integer> zeros) {
		int length = nums.length, i = 0;
		
		// 生成 窗口 i-j 中 将 0 移出该窗口需要的大小
		while (i < length && nums[i] == 0) {
			++i;
		}
		while (i < length) {
			int j = i + 1;
			while (j < length && nums[j] == 0) {
				++j;
			}
			if (j < length) {
				zeros.add(j - i - 1);
			}
			i = j;
		}
	}
	
	
}