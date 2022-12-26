package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1781 {
	
	
	public static void main(String[] args) {
		int aabcb = beautySum("aabcb");
		System.out.println("aabcb = " + aabcb);
	}
	
	
	public static int beautySum(String s) {
		int length = s.length(), ans = 0;
		int max;
		for (int i = 0; i < length; ++i) {
			int[] arr = new int[26];
			max = 0;
			for (int j = i; j < length; ++j) {
				int min = length;
				++arr[s.charAt(j) - 'a'];
				max = Math.max(max, arr[s.charAt(j) - 'a']);
				for (int k = 0; k < 26; ++k) {
					if (arr[k] > 0) {
						min = Math.min(min, arr[k]);
					}
				}
				ans += max - min;
			}
		}
		return ans;
	}
	
}