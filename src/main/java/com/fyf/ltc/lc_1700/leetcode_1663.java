package com.fyf.ltc.lc_1700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1663 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public String getSmallestString(int n, int k) {
		StringBuilder ans = new StringBuilder();
		// 答案为 aaa...*z 形式 使用贪心算法
		for (int i = 1; i <= n; i++) {
			int lower = Math.max(1,k - (n - i) * 26);
			k -= lower;
			ans.append((char)('a' + lower -1));
		}
		
		return ans.toString();
	}
}