package com.fyf.ltc.lc_2400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2309 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public String greatestLetter(String s) {
		
		Set<Character> set = new HashSet<>();
		for (char c :
				s.toCharArray()) {
			set.add(c);
		}
		
		for (int i = 26; i >= 0; --i){
			if(set.contains((char)('a' + i)) && set.contains((char)('A' + i))){
				return String.valueOf((char)('A' + i));
			}
		}
		
		return "";
	}
	
}