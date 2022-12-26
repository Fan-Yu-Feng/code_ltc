package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1754 {
	
	
	public static void main(String[] args) {
		
	}
	
	public String largestMerge(String word1, String word2) {
		// 模拟
		StringBuilder sb = new StringBuilder();
		
		while (word1.length() + word2.length() > 0) {
			if(word1.compareTo(word2)>0){
				sb.append(word1.charAt(0));
				word1 = word1.substring(1);
			}else {
				sb.append(word2.charAt(0));
				word2 = word2.substring(1);
			}
		}
		return sb.toString();
	}
	
}