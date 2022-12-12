package com.fyf.ltc.lc_1800;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1774 {
	
	
	public static void main(String[] args) {
		
	}
	
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		// 作者：Tizzi
		// 链接：https://leetcode.cn/problems/closest-dessert-cost/solution/javac-liang-chong-jie-fa-sou-suo-dong-ta-pvwf/
		// 来源：力扣（LeetCode）
		// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		
		boolean[] dp = new boolean[target + 5];
		int ans = Integer.MAX_VALUE;
		//判断只能选基料
		for (int x : baseCosts) {
			if (x > target) {
				ans = Math.min(ans, x);
			} else {
				dp[x] = true;
			}
		}
		for (int x : toppingCosts) {
			//选2次
			for (int i = 0; i < 2; i++) {
				for (int j = target; j >= 0; j--) {
					if (dp[j] && j + x > target) {
						//计算大于的情况
						ans = Math.min(ans, j + x);
					}
					if (j > x) {
						dp[j] |= dp[j - x];
					}
				}
			}
		}
		//ans-target:目前获得与target的差距
		for (int i = 0; i <= ans - target && i <= target; i++) {
			if (dp[target - i]) {
				return target - i;
			}
		}
		return ans;
	}
	
	int ans = Integer.MAX_VALUE;
	
	/**
	 * 计算最接近目标价格的甜点成本
	 *
	 * @param baseCosts    基料价格
	 * @param toppingCosts 辅料价格
	 * @param target       目标价格
	 *
	 * @return 价格
	 */
	public int closestCost2(int[] baseCosts, int[] toppingCosts, int target) {
		for (int x :
				baseCosts) {
			dfs(0, x, toppingCosts, target);
		}
		return ans;
	}
	
	/**
	 * 深度计算选择每种配料之后的价格 一共三种情况：选1个，选2个，不选
	 *
	 * @param x            基料价格
	 * @param sum          总和
	 * @param toppingCosts 辅料价格list
	 * @param target       目标价格
	 */
	private void dfs(int x, int sum, int[] toppingCosts, int target) {
		int a = Math.abs(sum - target), b = Math.abs(ans - target);
		if (a < b) {
			// 当前离 target 价格最小
			ans = sum;
		}
		
		if (sum > target) {
			// 此时 sum 已经大于 target 继续dfs 只会加大与 target 的间隔
			return;
		}
		if (a == b && sum < ans) {
			// 在于target 相差的绝对值相同的情况下，那么 ans 取最小的
			ans = sum;
		}
		for (int i = x; i < toppingCosts.length; ++i) {
			dfs(i + 1, sum + toppingCosts[i], toppingCosts, target);
			dfs(i + 1, sum + toppingCosts[i] * 2, toppingCosts, target);
		}
	}
	
}