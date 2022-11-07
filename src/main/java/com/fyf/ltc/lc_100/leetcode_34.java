package com.fyf.ltc.lc_100;


import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_34 {
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{5, 7, 7, 8, 8, 10};
		int[] ints = searchRange(arr, 8);
		
		System.out.println("ints = " + JSON.toJSONString(ints));
		method();
		
	}
	
	public static void method() {
	}
	
	public static int[] searchRange(int[] nums, int target) {
		
		int[] ans = new int[]{-1, -1};
		int len = nums.length;
		
		int left = 0, right = len - 1;
		// 进行二分 找到 targer 则记录最左和最右的位置
		int middle;
		// 第一次二分找最左的目标数据数组下标
		while (right >= left && right >= 0 && left < len) {
			middle = left + ((right - left) / 2);
			if (nums[middle] > target) {
				right = middle - 1;
			} else if (nums[middle] < target) {
				left = middle + 1;
			} else if (nums[middle] == target) {
				ans[0] = middle;
				right = middle - 1;
			}
		}
		left = 0;
		right = len - 1;
		// 第二次二分找最右的目标数据数组下标
		while (right >= left && right >= 0 && left < len) {
			middle = left + ((right - left) / 2);
			if (nums[middle] > target) {
				right = middle - 1;
			} else if (nums[middle] < target) {
				left = middle + 1;
			} else if (nums[middle] == target) {
				ans[1] = middle;
				left = middle + 1;
			}
		}
		return ans;
		
	}
	
}