package com.fyf.ltc.lc_2300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2287 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int rearrangeCharacters(String s, String target) {
		int[] sArr = new int[128];
		int[] tArr = new int[128];
		
		
		for (char c : s.toCharArray()) {
			++sArr[c];
		}
		for (char c : target.toCharArray()) {
			++tArr[c];
		}
		
		int ans = 1000;
		for (char c : target.toCharArray()) {
			ans = Math.min(sArr[c] / tArr[c], ans);
		}
		return ans;
		
	}
}