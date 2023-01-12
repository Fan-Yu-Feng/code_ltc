package com.fyf.ltc.lc_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_13 {
	
	static final Map<Character, Integer> SYMBOL_VALUE_MAP = new HashMap<Character, Integer>() {{
		put('I', 1);
		put('V', 5);
		put('X', 10);
		put('L', 50);
		put('C', 100);
		put('D', 500);
		put('M', 1000);
	}};

	
	public int romanToInt(String s) {
		int length = s.length();
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			int value = SYMBOL_VALUE_MAP.get(c);
			if(i == length - 1|| value >= SYMBOL_VALUE_MAP.get(s.charAt(i+1))){
				ans +=value;
			}else {
				ans-=value;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
	
	}

}