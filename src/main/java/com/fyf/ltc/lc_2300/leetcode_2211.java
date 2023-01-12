package com.fyf.ltc.lc_2300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2211 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int countCollisions(String directions) {
		// 左侧车子方向为 L 和 右侧开车方向为 R 的车子不会相撞
		// 因此需要统计中间没有被停下来的车
		int l = 0, r = directions.length() - 1;
		
		while (l <= r && directions.charAt(l) == 'L') {
			++l;
		}
		while (r >= l && directions.charAt(r) == 'R') {
			--r;
		}
		
		int ans = 0;
		for (int i = l; i <= r; i++) {
			if (directions.charAt(i) == 'L' || directions.charAt(i) == 'R') {
				++ans;
			}
		}
		
		return ans;
	}
	
	
}