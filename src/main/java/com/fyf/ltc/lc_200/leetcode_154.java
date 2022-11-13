package com.fyf.ltc.lc_200;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_154 {
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,1,3};
		
		int min = findMin(arr);
		System.out.println("min = " + min);
	}
	
	/**
	 * 	类似 153
	 */
	public static int findMin(int[] nums) {
		int len = nums.length;
		
		int left = 0, right = len - 1, mid;
		
		// 最小值 为 left  指针指向的数据 因此边界不为 left<= right
		while (left < right) {
			mid = left + (right - left) / 2;
			// 判断最小值在右边区间 则指针右移，否则左移
			if(nums[mid] > nums[right]){
				left = mid + 1;
			}else if(nums[mid] < nums[right]) {
				right = mid;
			}else {
				// 如果 mid 和 right 指向的数据相等 无法判断最小值在哪个区间 因此需要指针左移一位
				right--;
			}
		}
		return nums[left];
	}
	
}