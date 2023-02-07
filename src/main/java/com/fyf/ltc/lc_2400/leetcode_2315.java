package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2315 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int countAsterisks(String s) {
		
		int count = 0,ans =0;
		for (char c :
				s.toCharArray()) {
			if(c == '|'){
				++count;
			}else if(c == '*' && count % 2 ==0){
				++ans;
			}
		}
		return ans;
	}

}