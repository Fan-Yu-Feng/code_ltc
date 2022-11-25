package com.fyf.ltc.lc_1800;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1742 {
	
	
	public static void main(String[] args) {
		int i = countBalls(1, 10);
		
		System.out.println("i = " + i);
		
	}
	
	
	public static int countBalls(int lowLimit, int highLimit) {
		// 数据范围 <= 10^5 最大数字为 45
		int [] arr = new int [46];
		Arrays.fill(arr,0);
		int tempSum, tempVar;
		for(int i = lowLimit; i<= highLimit; ++i){
			tempSum = 0;
			tempVar= i;
			// 计算每个数字放入哪个盒子中
			while(tempVar!=0){
				tempSum += tempVar % 10;
				tempVar /=10;
			}
			++arr[tempSum];
		}
		int ans=0;
		for(int x: arr){
			ans = Math.max(x,ans);
		}
		return ans;
		
	}
}