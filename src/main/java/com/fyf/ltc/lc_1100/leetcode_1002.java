package com.fyf.ltc.lc_1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1002 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public List<String> commonChars(String[] words) {
		List<String> ans = new ArrayList<>();
		
		int[] map = new int[26];
		Arrays.fill(map,Integer.MAX_VALUE);
		
		for (String word : words) {
			int[] count = new int[26];
			for (char c : word.toCharArray()) {
				++count[c - 'a'];
			}
			// 获取最小共有的字符
			for (int i = 0; i < 26; i++) {
				map[i] = Math.min(count[i],map[i]);
			}
			
		}
		
		for (int i = 0; i < 26; i++) {
			int count = map[i];
			for (int j = 0; j < count; j++) {
				ans.add(String.valueOf((char)('a' + i)));
			}
		}
		return ans;
	}

}