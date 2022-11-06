package com.fyf.ltc.week318;

import org.bouncycastle.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_6229 {
	
	
	public static void main(String[] args) {
		method();
		
		int arr[] =new int[] {1,2,2,1,1,0};
		int arr1[] =new int[] {0,1};
		
		int[] ints = applyOperations(arr1);
		for (int x :
		     ints) {
			System.out.println("x = " + x);
		}
	}
	
	public static void method() {
	}
	
	
	public static int[] applyOperations(int[] nums) {
		int len = nums.length;
		
		int []ans  =new int[len];
		
		if(nums[0]==nums[1]){
			nums[0]+=nums[0];
		}
		for(int i = 1; i < len - 1 ; i++) {
			if(nums[i] == nums[i+1]){
				nums[i] = nums[i] * 2;
			}else {
				nums[i] = 0;
			}
		}
		int left =0;
		for (int num : nums) {
			if (num != 0) {
				ans[left++] = num;
			}
			
		}
		while (left<len){
			ans[left++]=0;
		}
		
		return ans;
	}
}