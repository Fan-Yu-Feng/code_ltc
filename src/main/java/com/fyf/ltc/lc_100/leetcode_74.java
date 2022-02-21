package com.fyf.ltc.lc_100;

/**
 * @author FYF @Description
 * @date 2022/1/26
 */
public class leetcode_74 {
  public static void main(String[] args) {
    System.out.println(
        searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 34, 45, 50}}, 13));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 1 && matrix[0].length == 1) {
      return matrix[0][0] == target;
    }
    int row = 0, col = matrix[0].length - 1;
    while (row <= matrix.length - 1 && col >= 0) {
      if (matrix[row][col] < target) {
        row++;
      } else if (matrix[row][col] > target) {
        col--;
      } else return true;
    }
    return false;
  }
}
