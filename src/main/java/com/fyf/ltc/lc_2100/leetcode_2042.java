package com.fyf.ltc.lc_2100;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2042 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public boolean areNumbersAscending(String s) {
		String[] strArr = s.split(" ");
		int pre = 0;
		for (String str : strArr) {
			if (str.charAt(0) <= '9') {
				int x = Integer.parseInt(str);
				if (pre >= x) {
					return false;
				}
				pre = x;
			}
		}
		
		return true;
	}
	
}