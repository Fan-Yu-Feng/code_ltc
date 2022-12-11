package com.fyf.ltc.lc_1800;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1775 {
	
	
	public static void main(String[] args) {
		int []arr1 = new int []{6,6};
		int []arr2 = new int []{1};
		int i = minOperations(arr1, arr2);
		System.out.println("i = " + i);
		
	}
	
	public static int minOperations(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 * 6 < n2 || n2 * 6 < n1) {
			return -1;
		}
		
		int sum1 = Arrays.stream(nums1).sum();
		int sum2 = Arrays.stream(nums2).sum();
		
		// 记录数组各个数字的个数
		int diff = sum2 - sum1;
		
		if (diff == 0) {
			return 0;
		}
		int ans = -1;
		if (diff > 0) {
			ans = getAns(nums1, nums2, diff, ans);
		} else {
			ans = getAns(nums2, nums1, -diff, ans);
		}
		return ans;
	}
	
	/**
	 * 贪心获取结果
	 *
	 * @param nums1 数组1
	 * @param nums2 数组2
	 * @param diff  两数组之和的差距
	 * @param ans   传递答案
	 *
	 * @return 结果
	 */
	private static int getAns(int[] nums1, int[] nums2, int diff, int ans) {
		// nums2> nums1;
		int[] arr1 = new int[6];
		for (int x :
				nums1) {
			// nums[i] = 6 时 只贡献了 0  减少与 nums2 的差距需要记录 6-x 的值
			++arr1[6 - x];
		}
		for (int x :
				nums2) {
			// x= 1 时 贡献为0  需要 x-1
			++arr1[x - 1];
		}
		
		// num1 添加 6-arr1[i] 的数 num2 减少数量
		for (int i = 5; i >= 1; --i) {
			while (arr1[i] > 0 && diff > 0) {
				diff -= i;
				--arr1[i];
				++ans;
			}
		}
		// 初始值是 -1
		return ans + 1;
	}
	
}