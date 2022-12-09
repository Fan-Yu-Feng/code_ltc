package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1780 {
	
	
	public static void main(String[] args) {
		boolean b = checkPowersOfThree(91);
		System.out.println("b = " + b);
		
	}
	
	public static boolean checkPowersOfThree(int n) {
		//  3 次幂 之和
		if(n == 0){
			return true;
		}
		return (n % 3) < 2 && checkPowersOfThree(n / 3);
	}
	
	

}