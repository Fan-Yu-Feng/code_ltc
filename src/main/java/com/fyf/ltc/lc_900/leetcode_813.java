package com.fyf.ltc.lc_900;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_813 {
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{9, 1, 2, 3, 9};
		int k = 3;
		double v = largestSumOfAverages(arr, 3);
		System.out.println("v = " + v);
		
		
	}
	
	public static double largestSumOfAverages(int[] nums, int k) {
		int n = nums.length;
		
		// 保存前缀和 计算 数组 nums 0~i 的和
		double[] prefix = new double[n + 1];
		
		// 数组nums 的长度为 n，那么 dp[n][k] 表示数组 nums 分成 k 个子数组后的最大平均值和，即最大分数。
		// d[i][j] 为 nums 在区间 [0,i-1] 分为j个子数组的最大平均数之和
		double dp[][] = new double[n + 1][k + 1];
		
		// 存储前缀和
		for (int i = 0; i < n; i++) {
			prefix[i + 1] = prefix[i] + nums[i];
		}
		
		// 计算前缀平均数
		// 当 j == 1 时，平均值和的最大值为 dp[i][1]
		for (int i = 1; i < n + 1; i++) {
			dp[i][1] = prefix[i] / i;
		}
		
		
		// 当 j > 1 时 最大平均值和为切分的平均值中的最大值
		// 切分范围为[0,x-1], [x,i-x]
		for (int j = 2; j <= k; j++) {
			for (int i = j; i <= n; i++) {
				for (int x = j - 1; x < i; x++) {
					dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
				}
			}
		}
		return dp[n][k];
	}
	
	public static double largestSumOfAverages2(int[] nums, int k) {
		int n = nums.length;
		double[] prefix = new double[n + 1];
		for (int i = 0; i < n; i++) {
			prefix[i + 1] = prefix[i] + nums[i];
		}
		double[] dp = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = prefix[i] / i;
		}
		for (int j = 2; j <= k; j++) {
			for (int i = n; i >= j; i--) {
				for (int x = j - 1; x < i; x++) {
					dp[i] = Math.max(dp[i], dp[x] + (prefix[i] - prefix[x]) / (i - x));
				}
			}
		}
		return dp[n];
	}
	
}