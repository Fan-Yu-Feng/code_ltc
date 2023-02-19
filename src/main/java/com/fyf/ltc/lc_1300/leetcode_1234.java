package com.fyf.ltc.lc_1300;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1234 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public int balancedString(String s) {
		int[] cnt = new int[4];
		String t = "QWER";
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			cnt[t.indexOf(s.charAt(i))]++;
		}
		int m = n / 4;
		
		if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
			return 0;
		}
		
		int ans = n;
		// 从左往右遍历窗口 将遍历到字符的数量减一，判断窗口外的字符数量不超过 1/4 ，
		// 如果满足就更新答案 然后将窗口右移，直到不满足条件为止
		for (int i = 0, j = 0; i < n; i++) {
			cnt[t.indexOf(s.charAt(i))]--;
			while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
				ans = Math.min(i - j + 1, ans);
				cnt[t.indexOf(s.charAt(j++))]++;
			}
		}
		return ans;
	}
	
}