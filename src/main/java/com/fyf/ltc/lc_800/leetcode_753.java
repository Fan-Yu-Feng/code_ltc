package com.fyf.ltc.lc_800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_753 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	Set<Integer> seen = new HashSet<>();
	StringBuffer ans = new StringBuffer();
	int highest;
	int k;
	
	public String crackSafe(int n, int k) {
		highest = (int) Math.pow(10, n - 1);
		this.k = k;
		dfs(0);
		for (int i = 1; i < n; i++) {
			ans.append('0');
		}
		return ans.toString();
	}
	
	public void dfs(int node) {
		for (int x = 0; x < k; ++x) {
			int nei = node * 10 + x;
			if (!seen.contains(nei)) {
				seen.add(nei);
				dfs(nei % highest);
				ans.append(x);
			}
		}
	}
}