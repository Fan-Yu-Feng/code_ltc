package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1796 {
	
	
	public static void main(String[] args) {
		String s = "dfa12321afd";
		
		int i = secondHighest(s);
		System.out.println("i = " + i);
		
		
	}
	
	public static int secondHighest(String s) {
		int length = s.length();
		// 存储最大值和第二大的值
		int ans = -1,max = -1;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if(s.charAt(i) >='0' && s.charAt(i) <= '9'){
				int x = s.charAt(i) - '0';
				++count;
				if(x > max){
					ans = max;
					max = x;
				}else if(x < max && x > ans){
					ans = x;
				}
			}
		}
		if(count==1){
			return -1;
		}
		return ans;
	}

}