package com.fyf.ltc.lc_2200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2180 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	public int countEven(int num) {
		int y = num /10, x = num %10;
		int ans = y * 5 -1;
		int ySum = 0;
		while (y!=0){
			ySum +=y%10;
			y/=10;
		}
		// 如果 ySum 为偶数 各个数字之和为 x /2 + 1;
		if(ySum % 2 == 0){
			ans += x /2 + 1;
		}else {
			ans += (x + 1) /2;
		}
		return ans;
	}

}