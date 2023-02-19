package com.fyf.ltc.lc_1200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1139 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 类似的题课件 221. 数字为1 的最大正方形
	 * 1、第一步先计算每个网格中横向和竖向连续1的个数。
	 * 2、第二步遍历二维网格，以每一个格子为正方形的右下角，分别找出上边和左边连续1的个数，取最小值作为正方形的边长，然后判断正方形的左边和上边长度是否都大于等于正方形边长，如果都大于等于正方形边长就更新正方形的最大边长，否则缩小正方形的边长，继续判断……。
	 *
	 * @param grid 正方形数组
	 *
	 * @return 最大的正方形面积
	 */
	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		//dp[i][j][0]: (i,j)横向连续1的个数
		//dp[i][j][1]: (i,j)竖向连续1的个数
		int[][][] dp = new int[m + 1][n + 1][2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//如果当前位置是0，就跳过
				if (grid[i - 1][j - 1] == 0) {
					continue;
				}
				//如果是1，我们就计算横向和竖向连续1的个数
				// 1、横向的连续加1 2、竖向的连续加1
				dp[i][j][0] = dp[i][j - 1][0] + 1;
				dp[i][j][1] = dp[i - 1][j][1] + 1;
			}
		}
		//记录正方形的最大长度
		int maxSide = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//沿着当前坐标往上和往左找出最短的距离，暂时看做是正方形的边长(正方形的具体边长
				//还要看上边和左边的长度，所以这里要判断一下)
				int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
				//如果边长小于maxSide，即使找到了也不可能再比maxSide大，所以我们没必要再找，直接跳过，
				if (curSide <= maxSide) {
					continue;
				}
				//curSide可以认为是正方形下边和右边的长度，我们还需要根据正方形上边和左边的长度
				//来确认是否满足正方形的条件
				for (; curSide > maxSide; curSide--) {
					//判断正方形的左边和上边的长度是否大于curSide，如果不大于，我们就缩小正方形
					//的长度curSide，然后继续判断
					if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
						maxSide = curSide;
						//更短的就没必要考虑了，这里直接中断
						break;
					}
				}
			}
		}
		//返回正方形的边长
		return maxSide * maxSide;
	}
	
}