package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1813 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean areSentencesSimilar(String sentence1, String sentence2) {
		if (sentence2.length() > sentence1.length()) {
			return areSentencesSimilar(sentence2, sentence1);
		}
		
		String[] str1 = sentence1.split(" ");
		String[] str2 = sentence2.split(" ");
		
		int n = str1.length, m = str2.length;
		
		// 双指针:计算 str2 和 str1 中两端的字符串相等的数量，如果刚好等于 str2 数组的长度，则为 true；
		int l = 0, r = 0;
		while (l < str2.length && str2[l].equals(str1[l])) {
			++l;
		}
		// r < m - l 防止重复扫描
		while (r < m - l && str2[m - r - 1].equals(str1[n - r - 1])) {
			++r;
		}
		return l + r == m;
	}
}