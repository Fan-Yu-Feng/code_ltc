package com.fyf.array;

import java.util.*;

/**
 * @author FYF @Description 两数之和
 * @date 2021/11/23
 */
public class twoSum {
  public static void main(String[] args) {
    int[] arr = new int[] {5};
    int a = 5;
    search(arr, a);
  }

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (right >= left) {
      // 取中位数的处理
      mid = (right - left) / 2 + left;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        return mid;
      }
    }
    return -1;
  }

  // 1
  public int[] twoSumSolution(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if ((nums[i] + nums[j]) == target) return new int[] {i, j};
      }
    }
    return new int[0];
  }

  public synchronized List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    if (nums.length < 2) {
      return lists;
    }
    // 进行排序
    Arrays.sort(nums);
    for (int first = 0; first < nums.length; first++) {
      // 如果连续的数字相同则跳过
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      int third = nums.length - 1;
      int target = -nums[first];
      // !
      for (int second = first + 1; second < nums.length; second++) {
        // 如果连续的数字相同则跳过
        if (second > 0 && nums[second] == nums[second - 1]) {
          continue;
        }
        // 值大于0 则 third--
        while (second < third && (nums[first] + nums[second] + nums[third]) > 0) {
          --third;
        }
        // 如果相同的大小 则退出循环 !
        if (second == third) {
          break;
        }
        if ((nums[first] + nums[second] + nums[third]) == 0) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          lists.add(list);
        }
      }
    }
    return lists;
  }

  // 三数之和
  public int sum(int i, int j, int k) {
    return i + j + k;
  }

  // 216
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int num : nums) {
      if (!hashSet.add(num)) {
        return true;
      }
      hashSet.add(num);
    }
    return false;
  }
  // 350
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums2.length > nums1.length) {
      return intersect(nums2, nums1);
    }
    int[] arr = new int[nums2.length];
    int index = 0;
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    for (int value : nums2) {
      int count = hashMap.getOrDefault(value, 0) + 1;
      hashMap.put(value, count);
    }
    for (int num : nums1) {
      int count = hashMap.getOrDefault(num, 0);
      if (count > 0) {
        arr[index++] = num;
        count--;
        if (count > 0) {
          hashMap.put(num, count);
        } else hashMap.remove(num);
      }
    }
    return Arrays.copyOfRange(arr, 0, index);
  }
  // 121
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int maxPrice = 0, minPrice = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxPrice) {
        maxPrice = prices[i] - minPrice;
      }
    }
    return maxPrice;
  }
}
