package com.fyf.ltc.lc_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_890 {
	
	
	public static void main(String[] args) {
		String words[] = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
		String pattern = "abb";
		
		List<String> andReplacePattern = findAndReplacePattern(words, pattern);
		System.out.println("andReplacePattern = " + Arrays.toString(new List[]{andReplacePattern}));
		
	}
	
	
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		
		List<String> ans = new ArrayList<>();
		for (String str : words) {
			int length = str.length();
			if (length != pattern.length()) {
				continue;
			}
			if (judgeMap(str, pattern)) {
				ans.add(str);
			}
		}
		return ans;
	}
	
	private static boolean judgeMap(String str, String pattern) {
		int length = pattern.length();
		
		// 双向映射 map
		HashMap<Character, Character> patternMap = new HashMap<>();
		HashMap<Character, Character> wordMap = new HashMap<>();
		
		for (int i = 0; i < length; i++) {
			char key = pattern.charAt(i);
			char value = str.charAt(i);
			if (!patternMap.containsKey(key)) {
				patternMap.put(key, value);
				if (!wordMap.containsKey(value)) {
					wordMap.put(value, key);
				} else {
					return false;
				}
			} else {
				// key-value  value-key
				if (wordMap.getOrDefault(value, '0') != key) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}