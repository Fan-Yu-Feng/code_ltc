package com.fyf.ltc.lc_900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_859 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public boolean buddyStrings(String s, String goal) {
		// 长度不同，不为亲密字符串
		if (s.length() != goal.length()) {
			return false;
		}
		
		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char g = goal.charAt(i);
			if (c != g) {
				count[c - 'a'] ++;
			}
			
			
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if(count[i]!=0){
				cnt++;
			}
		}
		return cnt > 2;
		
	}
}