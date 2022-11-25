package com.fyf.ltc.lc_900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_878 {
	
	
	public static void main(String[] args) {
		int i = nthMagicalNumber(1000000000,
				40000,
				40000);
		System.out.println("i = " + i);
		
	}
	static final int MOD = 1000000007;
	
	public static int nthMagicalNumber(int n, int a, int b) {
		// 左右指针
		long left = Math.min(b, a);
		// 求最小公倍数
		long commonMultiple = lcm(a, b);
		long right = n * commonMultiple;
		long mid,cnt;
		while(left<=right){
			mid = left + (right-left)/2;
			// a 的公倍数 个数 + b 的公倍数个数 - ab 共同的公倍数个数
			cnt = mid / a + mid / b - mid / commonMultiple;
			if(cnt < n ){
				left = mid+ 1;
			}else {
				right = mid - 1;
			}
		}
		return (int) ((1 + right) % MOD);
	}
	
	/**
	 * 最小公倍数
	 */
	static int lcm(int a, int b){
		
		return a*b/gcd(a, b);
	}
	
	/**
	 * 求 a 和 b 最小公约数
	 *
	 * @param a 数字a
	 * @param b b
	 *
	 * @return 最小公约数
	 */
	private static int gcd(int a, int b) {
		//总是将较小的数放在b中
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(b == 0){
			return a;
		}
		else{
			return gcd(b, a%b);
		}
	}
	
	
}