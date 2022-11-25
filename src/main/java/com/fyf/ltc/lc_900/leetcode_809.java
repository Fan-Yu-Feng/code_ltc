package com.fyf.ltc.lc_900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_809 {
	
	
	public static void main(String[] args) {
		
		int i = expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
		
		System.out.println("i = " + i);
	}
	
	public static int expressiveWords(String s, String[] words) {
		// 双指针
		int ans = 0;
		for (String word : words) {
			if (checkAns(word, s)) {
				++ans;
			}
		}
		
		return ans;
	}
	
	private static boolean checkAns(String word, String s) {
		
		int sLength = s.length();
		int wordLength = word.length();
		// s 的长度小于 word 则非可扩展的字符串
		if (word.length() > s.length()) {
			return false;
		}
		int sPointer = 0, wordPointer = 0;
		
		while (sPointer < sLength && wordPointer < wordLength) {
			
			if (s.charAt(sPointer) != word.charAt(wordPointer)) {
				return false;
			}
			int cntI = 1, cntJ = 1;
			
			char chI = s.charAt(sPointer), chJ = word.charAt(wordPointer);
			
			// 统计 s 有多少个相同的 char
			while ( ++sPointer < sLength && s.charAt(sPointer) == chI ) {
				++cntI;
			}
			// 统计 word 有多少个相同的 char
			while (++wordPointer < wordLength && word.charAt(wordPointer) == chJ) {
				++cntJ;
			}
			
			// word 相同的字符多余 s 或 word 字符数量小于 s  且 相同字符数量小于3
			if (cntJ > cntI || (cntJ < cntI && cntI < 3)) {
				return false;
			}
		}
		
		return sPointer == sLength && wordPointer == wordLength;
	}
	
}