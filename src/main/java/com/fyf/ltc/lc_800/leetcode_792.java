package com.fyf.ltc.lc_800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_792 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 二分查找法
	 *
	 * @param s     字符串s
	 * @param words 字符串数组
	 *
	 * @return 子序列个数
	 */
	public static int numMatchingSubseq(String s, String[] words) {
		
		List<Integer>[] pos = new List[26];
		
		for (int i = 0; i < 26; ++i) {
			pos[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < s.length(); ++i) {
			pos[s.charAt(i) - 'a'].add(i);
		}
		
		int ans = words.length;
		
		for (String t : words) {
			// t 的长度大于 s  则说明不是子序列
			if (t.length() > s.length()) {
				continue;
			}
			int p = -1;
			for (int i = 0; i < t.length(); ++i) {
				// t[i] 与 s[p] 匹配时，指针加速右移
				char c = t.charAt(i);
				// 若不存在 或 当前指针 p 小于 s[c- 'a'] 的最大值时（说明i指向的字符小于当前指针p ） t 不是 s 的子序列
				if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
					--ans;
					break;
				}
				p = getChildStrStatus(pos[c - 'a'], p);
			}
		}
		return ans;
	}
	
	
	private static int getChildStrStatus(List<Integer> pos, int p) {
		int left = 0, right = pos.size() - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (pos.get(mid) > p) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return pos.get(left);
	}
	
}