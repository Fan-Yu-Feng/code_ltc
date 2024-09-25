package com.fyf.ltc.lc_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_54 {
	
	
	public static void main(String[] args) {
		
	}


	@Test
	public void test(){
		int[][] matrix = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};
		System.out.println(spiralOrder(matrix));
	}

	/**
	 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		int xLen = matrix[0].length;
		int yLen = matrix.length;
		if (xLen == 1 && yLen == 1) {
			return Collections.singletonList(matrix[0][0]);
		}
		List<Integer> res = new ArrayList<>();
		// 模拟
		int left = 0, right = xLen - 1, top = 0, bottom = yLen - 1;
		while (left <= right && top <= bottom) {

			// 从左到右遍历
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			// top 下移
			top++;
			// 从右上到右下遍历
			for (int i = top ; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}
			right--;
			// 从右下到左下方
			if ( top <= bottom) {
				for (int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
				bottom--;
			}
			// 从左下到左上
			if (left <= right ) {
				for (int i = bottom; i >= top; i--) {
					res.add(matrix[i][left]);
				}
				left++;
			}
		}

		return res;
	}



}