package com.fyf.ltc.lc_100;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_69 {
	
	
	public static void main(String[] args) {
		method();
		int x = mySqrt(4);
		System.out.println("x = " + x);
		
		x = mySqrt(2147483647);
		
		System.out.println("x = " + x);
	}
	
	public static void method() {
	}
	
	public static int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		
		// 使用二分法
		int left = 0, right = x, ans = 0;
		while (left <= right) {
			// 进行二分
			int middle = left + ((right - left) >>  1);
			// 需要考虑数据溢出的情况 为long
			if ((long)middle * middle  <= x) {
				ans = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return ans;
	}
	
	
	/**
	 * 	作者：力扣官方题解
	 * 	链接：https://leetcode.cn/problems/sqrtx/solutions/238553/x-de-ping-fang-gen-by-leetcode-solution/
	 * @param x 数字
	 * @return 平方根
	 */
	public int mySqrt2(int x) {
		int l = 0, r = x, ans = -1;
		// 进行二分查找, 小于等于则 需要对左右指针做 mid +- 1 操作
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if ((long) mid * mid <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}
	

}