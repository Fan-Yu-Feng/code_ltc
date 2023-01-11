package com.fyf.ltc.lc_1900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1832 {
	
	
	public static void main(String[] args) {
		boolean leetcode = checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
		System.out.println("leetcode = " + leetcode);
		
	}
	
	public static boolean checkIfPangram(String sentence) {
		
		int state = 0;
		for (char c :
				sentence.toCharArray()) {
			state |= (1 << c - 'a');
		}
		return state == (1 << 26) - 1;
	}
	
}