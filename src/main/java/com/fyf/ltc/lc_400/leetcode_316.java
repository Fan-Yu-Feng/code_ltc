package com.fyf.ltc.lc_400;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_316 {
	
	
	public static void main(String[] args) {
		removeDuplicateLetters("da");
	}
	
	public static String removeDuplicateLetters(String s) {
		// 记录最后一个char的位置
		int[] lastIndices = new int[26];
		// 记录char 是否存在栈中
		boolean[] used = new boolean[26];
		
		Arrays.fill(lastIndices,-1);
		
		int length =s.length();
		for (int i = 0; i < length; i++) {
			// 记录最后一个char的位置
			lastIndices[s.charAt(i) - 'a'] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		int top = -1;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			int letterIndex = c - 'a';
			if (!used[letterIndex]) {
				
				// 当前字母小于栈中的且不是最后一个字母时可以出栈
				while (sb.length() > 0 && sb.charAt(top) > c && lastIndices[sb.charAt(top) - 'a'] > i) {
					used[sb.charAt(top) - 'a'] = false;
					sb.deleteCharAt(top);
					// 记录  sb 的下标位置
					top--;
				}
				// 入栈 | 当前 sb.charAt(tob) 大于 c
				used[letterIndex] = true;
				sb.append(c);
				top++;
			}
		}
		return sb.toString();
	}
	
}