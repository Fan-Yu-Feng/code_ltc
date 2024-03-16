package com.fyf.ltc.lc_1300;



import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1210 {
	
	
	public static void main(String[] args) {
		
	}
	
	private static final int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	
	
	/**
	 * <a href="https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/solution/huan-zai-if-elseyi-ge-xun-huan-chu-li-li-tw8b/">题解链接</a>
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n^2)
	 *  )
	 *
	 * @param grid
	 *
	 * @return
	 */
	public int minimumMoves(int[][] grid) {
		List<int[]> queue = new ArrayList<>();
		int n = grid.length;
		boolean[][][] vis = new boolean[n][n][2];
		vis[0][0][0] = true;
		queue.add(new int[]{0, 0, 0});
		for (int step = 1; !queue.isEmpty(); step++) {
			var tem = queue;
			queue = new ArrayList<>();
			for (var t : tem) {
				for (var d : DIRS) {
					int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
					// 蛇的方向如果是垂直的  (x + 0) (y + 1) 水平 (x + 1) (y + 0)
					int x2 = x + s, y2 = y + (s ^ 1);
					// 前面判断是否越界， 后面判断是否可以通过
					if (x2 < n && y2 < n && !vis[x][y][s] &&
							    grid[x][y] == 0 && grid[x2][y2] == 0 && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
						if (x == n - 1 && y == n - 2) {
							// 此时蛇头一定在( n -1 , n-1)
							return step;
						}
						vis[x][y][s] = true;
						queue.add(new int[]{x, y, s});
						
					}
				}
				
			}
			
		}
		
		
		return -1;
	}
	
}