package com.fyf.ltc.lc_1700;

import java.util.HashMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1624 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int maxLengthBetweenEqualCharacters(String s) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		int ans = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			} else {
				int x = map.get(c);
				ans = Math.max(ans, i - x - 1);
				
			}
		}
		return ans;
	}
	
}