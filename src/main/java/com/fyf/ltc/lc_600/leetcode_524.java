package com.fyf.ltc.lc_600;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_524 {
	
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("ale");
		arrayList.add("apple");
		arrayList.add("monkey");
		arrayList.add("plea");
		
	
		String sdsa = findLongestWord(	"abpcplea", arrayList);
		System.out.println("sdsa = " + sdsa);
		
		method();
		
	}
	
	public static String findLongestWord(String s, List<String> dict) {
		// 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
		// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
		
		// 解题思路：1、首先对 dict 进行排序：（1）对字母序号按升序排序。（2）如果首字母一样，则根据字符串的长度进行倒序
		dict.sort((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o2.length() - o1.length();
			}
			return o1.compareTo(o2);
		});
		
		// 2、双指针 i,j 分别指向 s[i], dict[x][j],
		// a.当 s[i] != dictionary[x][j]，我们使 i 指针右移，直到找到 s 中第一位与 dictionary[x][j] 对得上的位置，然后当 i 和 j 同时右移，匹配下一个字符；
		// b.重复步骤 a，直到整个 dictionary[x] 被匹配完。
		
		//  时间复杂度 O(mlog{m} + m*n)O(mlogm+m∗n) 空间复杂度：O(\log{m})O(logm)
		
		int i, j, len = s.length();
		for (String str:
		     dict) {
			i = 0;
			j = 0;
			int strLen = str.length();
			while(i < len && j < strLen){
				// 由于 str 字符串是 s 的子序列，因此在 s 中可以找到所有的 子字符串
				if(s.charAt(i) == str.charAt(j)){
					j++;
				}
				i++;
			}
			// 匹配到的第一个字符串就是最长且字母序最小的 ans
			if(j==strLen){
				return str;
			}
		}
		return "";
	}
	
	public static void method() {
	}
	
}