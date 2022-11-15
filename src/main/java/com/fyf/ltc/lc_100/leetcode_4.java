package com.fyf.ltc.lc_100;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_4 {
	
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 3};
		int[] arr2 = new int[]{1, 2, 3};
		double medianSortedArrays = findMedianSortedArrays(arr1, arr2);
		
		System.out.println("medianSortedArrays = " + medianSortedArrays);
		
		
	}
	
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int length1 = nums1.length, length2 = nums2.length;
		int totalLength = length1 + length2;
		if (totalLength % 2 == 1) {
			// 奇数则取数组长度中间的值
			int midIndex = totalLength / 2;
			return getKthElement(nums1, nums2, midIndex + 1);
		} else {
			// 偶数数组的中位数取两者的平均数
			int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
			return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
		}
	}
	
	
	/**
	 * 获取两个数组的中位数
	 *
	 * @param nums1 数组1
	 * @param nums2 数组2
	 * @param k     中位数的数组下标
	 *
	 * @return 中位数
	 */
	public static int getKthElement(int[] nums1, int[] nums2, int k) {
		
		// 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
		int length1 = nums1.length, length2 = nums2.length;
		int index1 = 0, index2 = 0;
		
		while (true) {
			// 边界情况
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				// 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}
			
			// 正常情况
			int half = k / 2;
			// nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
			// nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
			// 获取两个数组的下标 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
			// 这样 pivot 本身最大也只能是第 k-1 小的元素
			int newIndex1 = Math.min(index1 + half, length1) - 1;
			int newIndex2 = Math.min(index2 + half, length2) - 1;
			
			int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
			
			// 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
			// 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
			// 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
			if (pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				// 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}
}