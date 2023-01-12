package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1802 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int maxValue(int n, int index, int maxSum) {
		int left = 1, right = maxSum;
		while (left < right) {
			// 无符号右移 /2
			int mid = (left + right + 1) >>> 1;
			// 二分查找[1,maxSum]数据中最大的 mid
			if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	/**
	 * 求数组总和
	 *
	 * @param x   最大值为 x 的数组
	 * @param cnt 数组的数量
	 *
	 * @return 数组总和
	 */
	private long sum(long x, int cnt) {
		// (x + x - cnt + 1) * cnt /2 ==> ( [起始值 + 结尾值] * 数量 )/2
		//  如果 x< cnt  x 递减后的值有多个 1  (x + 1) * x /2 后 有多余的值需要剔除
		return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
	}
	
	
}