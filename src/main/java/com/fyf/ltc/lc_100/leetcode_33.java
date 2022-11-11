package com.fyf.ltc.lc_100;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_33 {
	
	
	public static void main(String[] args) {
		int []arr = new int[] {4,5,6,7,0,1,2};
		int []arr1 = new int[] {4,5,6,7,0,1,2};
		int []arr2 = new int[] {4,5,6,7,0,1,2};
		method();
		int search = search(arr, 0);
		System.out.println("search = " + search);
		
		
	}
	
	public static void method() {
	}
	
	
	public static int search(int[] nums, int target) {
		int length = nums.length;
		
		int left = 0, right = length - 1, mid;
		// 进行二分查找
		while (left <= right) {
			mid = left + (right - left) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (nums[0] <= nums[mid]) {
				if (nums[mid] > target && target>= nums[0]) {
					//	刚好在有序的区间
					right = mid - 1;
				} else {
					//	在无序的区间，进行收敛
					left = mid + 1;
				}
			} else {
				// 局部有序和无序
				if (target > nums[mid] && nums[length - 1] >= target) {
					//	刚好在有序的区间
					left = mid + 1;
				} else {
					//	在无序的区间，进行收敛
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
}