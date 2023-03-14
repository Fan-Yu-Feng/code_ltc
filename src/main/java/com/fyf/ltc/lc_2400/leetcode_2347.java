package com.fyf.ltc.lc_2400;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2347 {
	
	
	public static final String[] STR = new String[]{"Flush", "Three of a Kind", "Pair", "High Card"};
	
	public static void main(String[] args) {
	
	}
	
	public String bestHand(int[] ranks, char[] suits) {
		
		// 用 set 计算 5 张牌的花色以及牌的数量
		Map<Character,Integer> map = new HashMap<>();
		Map<Integer,Integer> integerMap = new HashMap<>();
		
		
		for (int i = 0; i < ranks.length; i++) {
			map.put(suits[i], map.getOrDefault(suits[i], 0) + 1);
			integerMap.put(ranks[i], integerMap.getOrDefault(ranks[i], 0) + 1);
		}
		
		// 5张相同的花色
		if(map.containsValue(5)){
			return STR[0];
		}
		
		// 三张相同数字以上
		if(integerMap.containsValue(3) || integerMap.containsValue(4) || integerMap.containsValue(5)){
			return STR[1];
		}
		// 两张相同的数字
		if(integerMap.containsValue(2)){
			return STR[2];
		}
		
		// 5张不同的数字
		return STR[3];
	}
	
	
}