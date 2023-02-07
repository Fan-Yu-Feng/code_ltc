package com.fyf.ltc.lc_2300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2299 {
	
	
	public static void main(String[] args) {
		
	}
	
	Set<Character> specials = new HashSet<Character>() {{
		add('!');
		add('@');
		add('#');
		add('$');
		add('%');
		add('^');
		add('&');
		add('*');
		add('(');
		add(')');
		add('-');
		add('+');
	}};
	
	
	
	
	public boolean strongPasswordCheckerII(String password) {
		// 8个字符
		if(password.length() < 8){
			return false;
		}
		boolean smallEngFlag = false, bigEngFlag = false,numFlag = false,specialFlag = false;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(i < password.length() -1 && c == password.charAt(i + 1)){
				return false;
			}
			if(c >= '0' && c <= '9'){
				numFlag =true;
			}
			if(c >= 'a' && c <= 'z'){
				smallEngFlag = true;
			}
			if(c >= 'A' && c <= 'Z'){
				bigEngFlag = true;
			}
			if(specials.contains(c)){
				specialFlag = true;
			}
		}
		
		return smallEngFlag && bigEngFlag && numFlag && specialFlag;
	}
}