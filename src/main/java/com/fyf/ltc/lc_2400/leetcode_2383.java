package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2383 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		
		int ans = 0;
		for (int x :
				energy) {
			ans += x;
		}
		ans = initialEnergy - ans >= 0 ? 0 : ans - initialEnergy;
		
		
		
		return ans;
	}
	

}