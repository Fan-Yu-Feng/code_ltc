package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1750 {
	
	
	public static void main(String[] args) {
		int cabaabac = minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb");
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb(1) = " + cabaabac);
		cabaabac = minimumLength("cabaabac");
		System.out.println("aabccabba = " + cabaabac);
		cabaabac = minimumLength("ca");
		System.out.println("ca = " + cabaabac);
		cabaabac = minimumLength("aabccabba");
		System.out.println("aabccabba = " + cabaabac);
		cabaabac = minimumLength("bbbbbbbbbbbbbbbbbbb");
		System.out.println("bbbbbbbbbbbbbbbbbbb = " + cabaabac);
		
		
	}
	
	public static int minimumLength(String s) {
		int length = s.length();
		
		// 双指针+模拟
		int left = 0, right = length - 1;
		while (left < right) {
			char c = s.charAt(left);
			if (c != s.charAt(right)) {
				// 两边不相等时，边界长度需要调整
				break;
			}
			// 维护双指针
			while (left <= right && s.charAt(left) == c) {
				++left;
			}
			while (left <= right && s.charAt(right) == c) {
				--right;
			}
		}
		return right - left + 1;
	}
	
	
}