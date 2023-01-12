package com.fyf.ltc.lc_300;

import java.util.HashMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_205 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean isIsomorphic(String s, String t) {
		
		HashMap<Character,Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			// 不包含 key
			if(!map.containsKey(s1)){
				// 包含 value 则返回 false
				if(map.containsValue(t1)){
					return false;
				}
				map.put(s1,t1);
			}else {
				// map key-value 映射关系不对 返回 false
				if(map.get(s1) != t1){
					return false;
				}
			}
		}
		return true;
	}
}