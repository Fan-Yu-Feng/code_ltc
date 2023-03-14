package com.fyf.ltc.lc_1300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1247 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int minimumSwap(String s1, String s2) {
		// 交换两个字符使得 s1 == s2  否则返回 -1 (s1 s2 的字符串只有 x、y)
		
		// 不相同的字符串记录数量 xyy yxx x:2 y:2 x
		int xy = 0, yx = 0;
		
		
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i), c2 = s2.charAt(i);
			if (c1 == 'x' && c2 == 'y') {
				++xy;
			} else if (c1 == 'y' && c2 == 'x') {
				++yx;
			}
		}
		// 奇数的话则不能够成功交换
		if ((xy + yx) % 2 == 1) {
			return -1;
		}
		// 贪心：交换一次让 xy 或 yx 减 2  交换 2次使 xy 和 yx 各减1
		return xy / 2 + yx / 2 + xy % 2 + yx % 2;
	}
	
	
}