package com.fyf.ltc.lc_1900;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1819 {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 数组中所有子数组的最大公约数的数量
	 * 1、获取数组中的最大值 max
	 * 2、枚举从 0 到 max 的所有数据 x ，由于公约数最大不超过 max
	 * 3、x 如果为 nums 子数组的公约数 那么答案加一
	 * 4、如何判断 x 为子数组的公约数：枚举 x 公倍数 y，如果 y 在数组中，则计算 y 的最大公约数 g 如果 g == x 那么 x 则为子数组的最大公约数
	 *
	 * @param nums 数组
	 *
	 * @return 数组中所有子数组的最大公约数的数量
	 */
	public int countDifferentSubsequenceGCDs(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt();
		boolean[] flag = new boolean[max + 1];
		int ans = 0;
		for (int x : nums) {
			flag[x] = true;
		}
		for (int x = 1; x <= max; x++) {
			int g = 0;
			for (int y = x; y <= max; y+=x) {
				if (flag[y]) {
					g = gcd(y, g);
					if (g == x) {
						++ans;
						break;
					}
				}
			}
		}
		return ans;
	}
	
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
}