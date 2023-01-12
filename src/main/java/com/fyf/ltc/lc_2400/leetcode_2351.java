package com.fyf.ltc.lc_2400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2351 {
	
	
	public static void main(String[] args) {
		
	}
	
	public char repeatedCharacter(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()){
			if(set.contains(c)){
				return c;
			}
			set.add(c);
		}
		return s.charAt(0);
	}

}