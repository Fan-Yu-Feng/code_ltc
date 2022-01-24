package com.fyf.ltc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FYF @Description
 * @date 2022/1/21
 */
public class leetcode_46 {
  static LinkedList<Integer> temp = new LinkedList<>();
  static List<List<Integer>> list = new LinkedList<>();

  public static void main(String[] args) {
    List<List<Integer>> permute = permute(new int[] {1, 2, 3});
    System.out.println(permute);
  }

  public static List<List<Integer>> permute(int[] nums) {
    // 数组的全排列
    int len = nums.length;
    // nums[i] 的全排列
    for (int i = 0; i < len; i++) {
      temp.add(nums[i]);
      dfs(i, nums);
      temp.clear();
    }
    return list;
  }

  public static void dfs(int cur, int[] nums) {
    if (temp.size() == nums.length) {
      list.add(new LinkedList<>(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == cur) {
        continue;
      }
      temp.add(nums[i]);
      dfs(i, nums);
      temp.remove(temp.size() - 1);
    }
  }
}
