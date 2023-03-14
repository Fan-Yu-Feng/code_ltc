package com.fyf.ltc.lc_1200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1124 {
	
	
	public static void main(String[] args) {
		
	}
	
	// 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
	//
	// 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
	//
	// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格大于「不劳累的天数」。
	//
	// 请你返回「表现良好时间段」的最大长度。
	public int longestWPI(int[] hours) {
		
		
		int length = hours.length;
		
		int good[] = new int[length], bad [] = new int[length];
		good[0] = hours[0] > 8 ? 1 :0;
		bad[0] = hours[0] > 8 ? 0 :1;
		
		for (int i = 1; i < length; i++) {
			if (hours[i] > 8){
				good[i] = good[i -1] + 1;
			}else {
				bad[i] = bad[i -1 ]+ 1;
			}
		}
		
		
		int left = 0, right = length -1;
		int ans = 0, goodCnt = 0, badCnt = 0;
		while (right < length){
		
		
		}
		
		
		return 0;
	}
}