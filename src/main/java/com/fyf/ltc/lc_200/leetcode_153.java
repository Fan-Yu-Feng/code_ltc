package com.fyf.ltc.lc_200;

/**
 * @author FYF
 * @date 2022/1/26
 */
public class leetcode_153 {
  public static void main(String[] args) {
    int min = findMin(new int[] {3, 4, 5, 1, 2});
    System.out.println(min);
  }

  static int findMin(int[] nums) {
    int r = nums.length - 1;
    int l = 0, mid = 0;
    while (l < r) {
      mid = l + ((r - l) >> 1);
      // 最小数在右侧，指针右移
      if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else {
        // 最小数在左侧,指针左移
        r = mid;
      }
    }
    return nums[l];
  }
}
