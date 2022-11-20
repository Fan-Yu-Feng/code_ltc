package com.fyf.ltc.competition.week318;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/apply-operations-to-an-array/
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 * 返回结果数组。
 * 注意 操作应当 依次有序 执行，而不是一次性全部执行。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2460 {
	
	
	public static void main(String[] args) {
		method();
		
		int[] arr = new int[]{1, 2, 2, 1, 1, 0};
		int[] arr1 = new int[]{0, 1};
		
		int[] ints = applyOperations(arr);
		for (int x :
				ints) {
			System.out.println("x = " + x);
		}
		
		
	}
	
	public static void method() {
	}
	
	/**
	 * 方法1 使用了额外的空间 O(N) 时间也是 O(N)
	 *
	 * @param nums 数组
	 *
	 * @return 目标数组
	 */
	public static int[] applyOperations(int[] nums) {
		int len = nums.length;
		
		int[] ans = new int[len];
		Arrays.fill(ans, 0);
		for (int i = 0; i < len - 1; ++i) {
			if (nums[i] == nums[i + 1]) {
				nums[i] *= 2;
				nums[++i] = 0;
			}
		}
		int index = -1;
		for (int x :
				nums) {
			if (x != 0) {
				ans[++index] = x;
			}
		}
		return ans;
	}
	
	
	public static int[] applyOperations2(int[] nums) {
		int len = nums.length;
		// 时间复杂度为 O(N) 空间为 O(1)
		int j = 0;
		for (int i = 0; i < len - 1; ++i) {
			if (nums[i] == nums[i + 1]) {
				nums[i] *= 2;
				nums[i + 1] = 0;
			}
			if (nums[i] > 0) {
				nums[j] = nums[i];
				nums[i] = nums[j];
				j++;
			}
		}
		return nums;
	}
}