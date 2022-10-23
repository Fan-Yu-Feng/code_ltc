package com.fyf.ltc.lc_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/22
 */
public class leetcode_76 {
	
	public static String minWindow(String s, String t) {
		Map<Character, Integer> chars = new HashMap<>();
		Map<Character, Boolean> flag = new HashMap<>();
		
		// 记录 T 的 char 和 个数
		for (int i = 0; i < t.length(); ++i) {
			char c = t.charAt(i);
			// 有数据的 map 默认设置 大于等于0
			chars.put(c, chars.getOrDefault(c, 0) + 1);
			flag.put(c, true);
		}
		
		// 移动滑动窗口，不断更改统计数据
		int cnt = 0, l = 0, min_l = 0, min_size = s.length() + 1;
		for (int r = 0; r < s.length(); ++r) {
			//  如果 T 中 存在 s[r] 的字符
			char c = s.charAt(r);
			if (flag.getOrDefault(c, false)) {
				// 判断此时的 s 的字符串有 t 的字符串 窗口向右移动
				if (chars.get(c) > 0) {
					++cnt;
					chars.put(c, chars.get(c) - 1);
				}else if(chars.get(c) <= 0){
					// 当窗口移动到 flag[c] 为 true 的值 chars[c] 做标记减一
					chars.put(c, chars.get(c) - 1);
				}
			}
			// 如果滑动窗口已经包含了 t 中的所有字符
			// 则尝试左移缩小窗口，在不影响结果的情况下，获得最短子字符串
			while (cnt == t.length()) {
				// 记录最短字符串
				if (r - l + 1 < min_size) {
					// 最左端的窗口位置
					min_l = l;
					// 最右端的窗口位置
					min_size = r - l + 1;
				}
				
				// 当 s[l] 值存在于 t 中， 且该值 + 1 > 1 维护 cnt 状态，反正也记录了当前最短的窗口位置，那就看看后面有没有更短的窗口长度
				if (flag.getOrDefault(s.charAt(l), false) ) {
					if(chars.get(s.charAt(l)) >= 0){
						chars.put(s.charAt(l), chars.get(s.charAt(l)) + 1);
						// cnt 状态改变 跳出循环
						--cnt;
					}else {
						chars.put(s.charAt(l), chars.get(s.charAt(l)) + 1);
					}
				}
				// 尝试向左移动
				++l;
			}
		}
		return min_size > s.length() ? "" : s.substring(min_l, min_l + min_size);
	}
	
	public static void main(String[] args) {
		// "ADOBECODEBANC"
		// "ABC"
		String s = "a";
		String t = "aa";
		String s1 = minWindow(s, t);
		System.out.println("s1 = " + s1);
		
	}
	
	
}