package com.fyf.ltc.lc_1900;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @since 2022/12/6 19:13
 */
public class leetcode_1805 {
	
	public static void main(String[] args) {
		int leet1234code234 = numDifferentIntegers("gi851a851q8510v");
		System.out.println("leet1234code234 = " + leet1234code234);
		
	}
	
	public static int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		for (String str :
				word.split("[a-z]+")) {
			if (str.length() > 0) {
				set.add(str.replaceAll("^0+", ""));
			}
		}
		return set.size();
	}
	
	
	
	
	
	
}