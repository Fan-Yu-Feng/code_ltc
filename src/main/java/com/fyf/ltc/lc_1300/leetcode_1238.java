package com.fyf.ltc.lc_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1238 {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 参考 89 题 格雷编码
	 * <a href="https://leetcode.cn/problems/gray-code/">格雷编码</a>
	 * @param n
	 * @param start
	 * @return
	 */
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i <  1 << n ; i++) {
			ans.add(i ^ (i >> 1) ^ start);
		}
		return ans;
	}
	

}