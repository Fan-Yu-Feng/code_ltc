package com.fyf.ltc.lc_100;

/**
 * 一个原本增序的数组被首尾相连后按某个位置断开（如[1,2,2,3,4,5] ! [2,3,4,5,1,2]，在第一
 * 位和第二位断开），我们称其为旋转数组。给定一个值，判断这个值是否存在于这个旋转数组中。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 原本增序 -> 然后旋转 亦可以使用二分查找
 * 此题和 33 题是类似的 {@link leetcode_33}
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_81 {
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
		int[] arr1 = new int[]{4, 5, 6, 7, 0, 1, 2};
		int[] arr2 = new int[]{4, 5, 6, 7, 0, 1, 2};
		method();
		boolean search = search(arr, 0);
		
		System.out.println("search = " + search);
		
		
	}
	
	public static void method() {
	}
	
	
	public static boolean search(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) {
			return false;
		}
		if (length == 1) {
			return nums[0] == target;
		}
		int left = 0, right = length - 1, mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			}
			// 左右指针相等的情况下 无法判断[left,mid] [mid,right] 区间内的值是否有序 因此缩小区间
			if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
				++left;
				--right;
			} else if (nums[mid] >= nums[left]) {
				// 左边区间有序的情况下 判断 target 会落入哪个范围
				if (target >= nums[left] && nums[mid] > target) {
					// 如果 target 在 [left,mid) 内 那么需要往左缩小范围
					right = mid - 1;
				} else {
					// 否则往右缩小范围
					left = mid + 1;
				}
			} else {
				// target 在右边区间的情况下 判断落入哪个范围
				if (target <= nums[length - 1] && target > nums[mid]) {
					// (mid,length -1 ] 区间内有序 且 target 在这个右边的区间内 往右缩小区间
					left = mid + 1;
				} else {
					// 否则 target 不在右边的区间，则需要往左缩小范围
					right = mid - 1;
				}
			}
		}
		return false;
	}
	
}