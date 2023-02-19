package com.fyf.ltc.lc_2400;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2325 {
	
	
	public static void main(String[] args) {
		
	}
	
	public String decodeMessage(String key, String message) {
		StringBuilder ans = new StringBuilder();
		int map[] = new int[26];
		Arrays.fill(map, -1);
		int cnt = 0;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (key.charAt(i) != ' ' && map[index] == -1) {
				map[index] = cnt++;
			}
		}
		
		for (char c : message.toCharArray()) {
			if (c == ' ') {
				ans.append(c);
			} else {
				ans.append((char) ('a' + map[c - 'a']));
			}
		}
		return ans.toString();
	}
	
}