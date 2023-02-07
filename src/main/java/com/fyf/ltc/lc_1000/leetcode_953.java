package com.fyf.ltc.lc_1000;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_953 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean isAlienSorted(String[] words, String order) {
		int[] map = new int[26];
		
		for (int i = 0; i < order.length(); i++) {
			map[order.charAt(i) - 'a'] = i;
		}
		
		int wordCount = words.length;
		
		for (int i = 1; i < words.length; i++) {
			if(compare(words[i - 1], words[i], map) > 0){
				return false;
			}
		}
		
		
		return true;
	}
	
	private int compare(String word, String word1, int[] map) {
		int length1 = word.length(), length2 = word1.length();
		int len = Math.min(length1, length2);
		
		for (int i = 0; i < len; i++) {
			int index1 = map[word.charAt(i) - 'a'], index2 = map[word1.charAt(i) - 'a'];
			if (index2 != index1) {
				// 字典序小的在前
				return index1 - index2;
			}
		}
		return length1 - length2;
	}
	
	
}