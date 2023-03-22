package com.fyf.ltc.lc_1600;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1599 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		int ans = -1;
		if(boardingCost <= 0){
			return ans;
		}
		
		int wait = 0, i= 0;
		int maxMoney = 0, temp = 0;
		
		while (wait > 0 || i < customers.length){
			wait += i < customers.length ? customers[i] : 0;
			int up = Math.min( wait, 4);
			wait -=up;
			++i;
			temp += up * boardingCost - runningCost;
			if(temp > maxMoney ){
				ans = i;
				maxMoney = temp;
			}
		}
		return ans;
	}
	
}