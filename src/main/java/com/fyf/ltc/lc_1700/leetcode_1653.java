package com.fyf.ltc.lc_1700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1653 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int minimumDeletions(String s) {
		// 动态规划
		// 如果 为 b ， b 数量加 1 不进行操作
		// 如果为 a ，那么需要删除前面的 b 或者删除 a 两个之间的最小值
		// res == > f[0]
		int b = 0, res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				// res 记录 a （f[n]） 的数量  fn = f(n-1) + 1
				res = Math.min(b, res + 1);
			} else {
				++b;
			}
		}
		return res;
	}

}