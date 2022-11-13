package com.fyf.ltc.lc_600;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_540 {
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1,1,2,3,3,4,4,8,8};
		int i = singleNonDuplicate(arr);
		System.out.println("i = " + i);
		
		
	}
	
	
	public static int singleNonDuplicate(int[] nums) {
		int length = nums.length;
		
		int left = 0, right = length -1;
		int mid;
		while (left < right){
			mid = left + (right - left) /2;
			// 只有一个数字是1个的
			// 如果 mid 是奇数 判断 mid + 1 位置是否一样 不一样则 指针右移
			if(mid % 2 != 0){
				if(nums[mid] == nums[mid - 1]){
					left= mid + 1;
				}else {
					right = mid;
				}
			}else {
				// 如果 mid 是偶数  判断 mid - 1 位置数据是否一样
				if(nums[mid] == nums[mid + 1]){
					left = mid + 1;
				}else {
					right = mid;
				}
			}
		}
		
		return nums[left];
	}
	public static int singleNonDuplicate2(int[] nums) {
		
		// 解法一简易写法
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (high - low) / 2 + low;
			// 无论mid是奇数还是偶数  mid + 1 和 mid -1 的结果都为 mid ^ 1 （异或）
			if (nums[mid] == nums[mid ^ 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return nums[low];
		
	}
}