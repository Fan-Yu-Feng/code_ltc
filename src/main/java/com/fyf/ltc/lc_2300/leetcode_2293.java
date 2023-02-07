package com.fyf.ltc.lc_2300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2293 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int minMaxGame(int[] nums) {
		int n = nums.length;
		while(n > 1){
			n /=2;
			for (int i = 0; i< n ;i++){
				int a  = nums[i << 1], b = nums[i << 1|1];
				nums[i] = i % 2 == 0 ? Math.min(a,b) : Math.max(a,b);
			}
			
		}
		return nums[0];
	}

}