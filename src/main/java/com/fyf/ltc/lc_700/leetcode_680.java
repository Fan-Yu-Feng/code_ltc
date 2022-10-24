package com.fyf.ltc.lc_700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_680 {
	
	
	public static void main(String[] args) {
		method();
		boolean aba = validPalindrome("abc");
		System.out.println("aba = " + aba);
		
	}
	
	public static void method() {
	}
	
	public static boolean validPalindrome(String s) {
		
		int length = s.length();
		
		int L = 0, R = length - 1;
		while (L <= R){
			if(s.charAt(L) == s.charAt(R)){
				++L;
				--R;
			}else {
				return validPalindrome(s,L + 1,R) || validPalindrome(s,L,R - 1);
			}
		}
		return true;
	}
	
	private static boolean validPalindrome(String s, int L, int R) {
		while(L <= R){
			if(s.charAt(L++)!=s.charAt(R--)){
				return false;
			}
		}
		return true;
	}
}