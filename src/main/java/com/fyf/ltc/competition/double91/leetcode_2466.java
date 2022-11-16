package com.fyf.ltc.competition.double91;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2466 {
	
	
	public static void main(String[] args) {
		int i = countGoodStrings(3, 3, 2, 1);
		System.out.println("i = " + i);
	}
	
	public static int countGoodStrings(int low, int high, int zero, int one) {
		// 爬楼梯： 最后一步是 zero 和 one
		// 分为两种情况 一种是以 zero 个字符结尾 和 以 one 个字符结尾的情况 f(i) = f(i-one) + f(i-zero)
		int mod = 1000000007;
		
		int[] f = new int[high+1];
		
		// 初始化
		f[0] = 1;
		int res = 0;
		for (int i = 0; i <= high; ++i) {
			if (i >= zero) {
				//	f[i] = f[i] +  f[i-zero];
				f[i] =  f[i-zero];
			}
			
			if (i >= one) {
				f[i] = (f[i] + f[i - one]) % mod;
			}
			
			
			if (i >= low) {
				res = (res + f[i]) % mod;
			}
		}
		
		return res;
	}
	
}