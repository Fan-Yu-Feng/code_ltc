package com.fyf.ltc.lc_1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1233 {
	
	
	public static void main(String[] args) {
		
	}
	
	public List<String> removeSubfolders(String[] folder) {
		List<String> ans = new ArrayList<>();
		Arrays.sort(folder);
		String pre = "//";
		ans.add(pre);
		for (String s : folder) {
			if (!s.startsWith(pre)) {
				ans.add(s);
				pre = s + '/';
			}
		}
		ans.remove("//");
		return ans;
	}
	
}