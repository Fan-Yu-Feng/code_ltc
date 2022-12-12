package com.fyf.ltc.lc_500;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_402 {
	
	
	public static void main(String[] args) {
		String s = removeKdigits("10200", 1);
		
		System.out.println("s = " + s);
	}
	
	/**
	 * 思路和参考：<a href="https://mp.weixin.qq.com/s/L8Uw-x4HuiEb2gdbU_hXzA">参考思路</a>
	 *
	 * @param num 字符串数字
	 * @param k   移除k个数字
	 *
	 * @return 移除数字后的结果
	 */
	public static String removeKdigits(String num, int k) {
		
		// 单调栈存储数字，满足从栈底到栈顶的数字单调递增
		// sb 模拟栈 从栈底到栈顶从小到大排序  底 1 2 3 4 顶
		StringBuilder sb = new StringBuilder();
		// 如果栈不为空、栈顶数字大于当前数字、已经移除的数字个数小于 k，则将栈顶数字出栈，重复该操作直到上述条件不满足（三个条件之一不满足即停止）；
		// 将当前数字入栈。
		int index = 0;
		sb.append(num.charAt(0));
		for (int i = 1; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (sb.length() > 0 &&  sb.charAt(index) > c && k > 0) {
				sb.deleteCharAt(index);
				--index;
				--k;
			}
			sb.append(c);
			index++;
		}
		while (k > 0) {
			sb.deleteCharAt(index);
			--index;
			--k;
		}
		String s = sb.toString().replaceAll("^0+", "");
		
		return s.length() == 0 ? "0" : s;
	}
	
}