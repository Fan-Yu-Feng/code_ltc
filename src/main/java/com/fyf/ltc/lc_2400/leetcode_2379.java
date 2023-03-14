package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2379 {
	
	
	public static void main(String[] args) {
		
		minimumRecolors("WBBWWBB", 7);
	}
	
	public static int minimumRecolors(String blocks, int k) {
		int W = 0;
		int r = k, n = blocks.length();
		
		int x  = 0;
		while(x < k ){
			if (blocks.charAt(x) == 'W') {
				++W;
			}
			++x;
		}
		int ans = W;
		// 右指针向右移动
		while (r < n) {
			if (blocks.charAt(r) == 'W') {
				++W;
			}
			if(r >= k){
				char c = blocks.charAt(r - k);
				if(c == 'W'){
					--W;
				}
			}
			ans = Math.min(W, ans);
			++r;
		}
		return ans;
	}
	
	
}