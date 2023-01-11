package com.fyf.ltc.lc_100;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_42 {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 接雨水思路1
	 * 空间换时间，采用两个从左到右和从右到左记录最高高度的数组 leftHeight 和 rightHeight
	 * 则 height[i] 最多能接到的雨水则是 min（leftHeight[i],rightHeight[i]） - height[i]
	 *
	 * @param height 高度边数组
	 *
	 * @return 接到的雨水
	 */
	public int trap(int[] height) {
		int length = height.length;
		int[] leftHeight = new int[length];
		int[] rightHeight = new int[length];
		
		leftHeight[0] = height[0];
		rightHeight[length - 1] = height[length - 1];
		for (int i = 1; i < length; i++) {
			leftHeight[i] = Math.max(height[i], leftHeight[i - 1]);
			
		}
		
		for (int i = length - 2; i >= 0; i--) {
			rightHeight[i] = Math.max(height[i], rightHeight[i + 1]);
		}
		int ans = 0;
		for (int i = 0; i < length; i++) {
			ans += Math.min(rightHeight[i],leftHeight[i]) - height[i];
		}
		
		return ans;
	}
	
}