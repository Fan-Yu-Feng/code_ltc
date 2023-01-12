package com.fyf.ltc.lc_1900;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1807 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public String evaluate(String s, List<List<String>> knowledge) {
		Map<String, String> dict = new HashMap<>();
		// 设置map
		for (List<String> strArr :  knowledge) {
			dict.put(strArr.get(0),strArr.get(1));
		}
		// key 替换 map
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '('){
				StringBuilder stringBuilder = new StringBuilder();
				while (s.charAt(++i) != ')'){
					stringBuilder.append(s.charAt(i));
				}
				ans.append(dict.getOrDefault(stringBuilder.toString(),"?"));
			}else {
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
	}
	
}