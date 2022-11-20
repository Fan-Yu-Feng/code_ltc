package com.fyf.ltc.lc_900;

import java.util.Arrays;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_891 {
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{2, 1, 3, 4};
		int i = sumSubseqWidths(arr);
		System.out.println("i = " + i);
	}
	
	/**
	 * 数组中元素的顺序变换不影响最终的结果
	 * 求子序列宽度也就是 每个区间最大值和最小值之和
	 * 针对每个 A[i] 而言，A[i] 对最终结果的贡献是在子序列的左右两边的时候才有贡献，
	 * 当 A[i] 位于区间中间的时候，不影响最终结果。先对 A[i] 进行排序，排序以后，
	 * 有 i 个数 <= A[i]，有 n - i - 1 个数 >= A[i]。所以 A[i] 会在 2^i 个子序列的右边界出现，2^(n-i-1) 个左边界出现。
	 * 那么 A[i] 对最终结果的贡献是 A[i] * 2^i - A[i] * 2^(n-i-1) 。
	 * 举个例子，[1,4,5,7]，A[2] = 5，那么 5 作为右边界的子序列有 2^2 = 4 个，
	 * 即 [5],[1,5],[4,5],[1,4,5]，5 作为左边界的子序列有 2^(4-2-1) = 2 个，
	 * 即 [5],[5,7]。A[2] = 5 对最终结果的影响是 5 * 2^2 - 5 * 2^(4-2-1) = 10 。
	 * 那么 Ans = SUM{ A[i]*2^i - A[n-i-1] * 2^(n-i-1) }，其中 0 <= i < n。需要注意的是 2^i 可能非常大，
	 * 所以在计算中就需要去 mod 了，而不是最后计算完了再 mod。注意取模的结合律：(a * b) % c = (a % c) * (b % c) % c。
	 */
	public static int sumSubseqWidths(int[] nums) {
		Arrays.sort(nums);
		
		int mod = 1000000007, length = nums.length;
		long  ans = 0;
		int p = 1;
		for (int i = 0; i < length; ++i) {
			ans = (ans + (nums[i] - nums[length - i - 1]) * p) % mod;
			p = ( p * 2) % mod;
		}
		return (int) ans;
	}
	
}