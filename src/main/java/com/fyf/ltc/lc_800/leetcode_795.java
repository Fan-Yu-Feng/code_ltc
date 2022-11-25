package com.fyf.ltc.lc_800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_795 {
	
	
	public static void main(String[] args) {
	int []arr =  {2,1,4,3};
		int left = 2;
		int right = 3;
		int i = numSubarrayBoundedMax(arr, left, right);
		System.out.println("i = " + i);
		
	}
	
	public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
		int length = nums.length;
		int l = -1, r = -1, temp= 0;
		int ans = 0;
		// 滑动窗口 计算窗口中的子数组
		while (++r < length) {
			if (nums[r] > right) {
				l = r;
				temp=0;
				continue;
			} else if(nums[r]>=left){
				temp = (r - l);
			}
			// 当 num[r] < left 时 贡献的子数组与上一个 [left, right] 范围内的数字相同
			ans+=temp;
		}
		return ans;
	}
	
}