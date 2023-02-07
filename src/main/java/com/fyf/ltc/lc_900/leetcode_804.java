package com.fyf.ltc.lc_900;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_804 {
	
	
	public static void main(String[] args) {
		
	}
	
	private static final String [] MO_SI_ARR = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	
	public int uniqueMorseRepresentations(String[] words) {
		Set<String> ans = new HashSet<>();
		for(String str : words){
			StringBuilder sb = new StringBuilder();
			for (char c : str.toCharArray()) {
				sb.append(MO_SI_ARR[c- 'a']);
			}
			ans.add(sb.toString());
		}
		return ans.size();
	}
	
	
}