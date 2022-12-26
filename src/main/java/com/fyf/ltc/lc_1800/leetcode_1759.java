package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1759 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int countHomogenous(String s) {
		char pre = s.charAt(0);
		long ans = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (pre == s.charAt(i)) {
				++count;
			} else {
				ans += (count * (count + 1) / 2);
				count = 1;
				pre = s.charAt(i);
			}
		}
		ans += (count * (count + 1) / 2);
		
		return (int) ans % 1000000007;
	}
	
}