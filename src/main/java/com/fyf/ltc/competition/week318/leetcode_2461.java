package com.fyf.ltc.competition.week318;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * <p>
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2461 {
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1,5,4,2,9,9,9};
		int k = 3;
		
		long l = maximumSubarraySum(arr, k);
		System.out.println("l = " + l);
		
		
	}
	
	public static long maximumSubarraySum(int[] nums, int k) {
		int length = nums.length;
		
		HashMap<Integer, Integer> map =new HashMap<>();
		// 测试用例数据 超过 int 的数据大小
		long ans = 0,temp = 0;
		for(int i = 0; i < k; i++) {
			map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
			temp+=nums[i];
		}
		
		if(map.size()==k){
			ans = Math.max(ans,temp);
		}
		
		// 滑动窗口解法：滑动窗口 记录最大值

		for(int i = k; i < length; i++) {
			// 右指针右移
			map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
			temp+=nums[i];
			
			
			// i-k 位置在滑动窗口汇总出现重复的次数
			Integer times = map.get(nums[i-k]);
			
			// 左指针左移
			if(times == 1){
				map.remove(nums[i - k]);
			}else {
				map.put(nums[i - k], times - 1);
			}
			// 维护滑动窗口数据
			temp-=nums[i-k];
			if(map.size() == k){
				ans = Math.max(ans,temp);
			}
			
			
		}
		return ans;
	}
	
	
}