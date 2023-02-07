package com.fyf.ltc.lc_900;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_888 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int sum1 = Arrays.stream(aliceSizes).sum();
		int sum2 = Arrays.stream(bobSizes).sum();
		
		int diff = sum1 - sum2;
		// sum1 - x + y = sum2 -y + x  -> sum1 -sum2 = 2 (x - y)
		for (int i = 0; i < aliceSizes.length; i++) {
			int x = aliceSizes[i];
			for (int j = 0; j < bobSizes.length; j++) {
				if(2 * (x  -bobSizes[j]) == diff){
					return new int[]{aliceSizes[i], bobSizes[j]};
				}
			}
		}
		
		
		
		return null;
	}
	
}