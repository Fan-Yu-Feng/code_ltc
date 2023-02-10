package com.fyf.ltc.competition.week331;

import java.util.*;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2559 {
	
	
	public static void main(String[] args) {
		
	}
	
	List<Character> charArr = new ArrayList<>(Arrays.asList('a', 'e', 'o','i','u'));
	public int[] vowelStrings(String[] words, int[][] queries) {
		
		int[] arr = new int[words.length];
		Arrays.fill(arr,0);
		if(charArr.contains(words[0].charAt(0))  && charArr.contains(words[0].charAt(words[0].length() - 1))){
			arr[0] = 1;
		}
		
		for (int i = 1; i < words.length; i++) {
			// 开头和结尾的字符都为元音
			if(charArr.contains(words[i].charAt(0)) && charArr.contains(words[i].charAt(words[i].length() - 1))){
				arr[i] = arr[i-1] + 1;
			}else {
				arr[i] = arr[i-1];
			}
		}
		
		int [] ans = new int[queries.length];
		
		for (int i = 0; i < queries.length; i++) {
			int l = queries[i][0], r =  queries[i][1];
			if(l == 0){
				ans[i] = arr[r];
			}else {
				ans[i] = arr[r] - arr[l -1 ];
			}
		}
		
		return ans;
	}
	
	
}