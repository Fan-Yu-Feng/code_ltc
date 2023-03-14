package com.fyf.ltc.lc_1500;

import java.util.HashMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1487 {
	
	
	public static void main(String[] args) {
	
	}
	
	public String[] getFolderNames(String[] names) {
		
		String[] ans = new String[names.length];
		// 记录元素的最小正整数
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < names.length; i++) {
			String str = names[i];
			if (map.containsKey(str)) {
				// 集合 set 包含路径则说明该路径不唯一需要分两种情况讨论
				// 1、如果该路径不含有括号，那么按最小正整数的路径拼接成唯一路径，同时
				// 2、如果该路径含有括号，且括号前缀有在集合中
				// 3、需要校验该路径是否存在，存在则继续往上增
				Integer orDefault = map.getOrDefault(str, 1);
				String concatStr = str.concat("(" + orDefault + ")");
				while (map.containsKey(concatStr)) {
					++orDefault;
					concatStr = str.concat("(" + orDefault + ")");
				}
				map.put(concatStr, 1);
				// 最小正整数 + 1 操作
				map.put(str, orDefault + 1);
			} else {
				// 初始化该文件路径的最小字符串为 1
				map.put(str, 1);
			}
			ans[i] = str;
		}
		return ans;
	}
	
	
}
