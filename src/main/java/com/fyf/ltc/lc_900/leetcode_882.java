package com.fyf.ltc.lc_900;



import java.util.*;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_882 {
	
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
		int maxMoves = 6;
		int n = 3;
		int i = reachableNodes(arr, maxMoves, n);
		
		System.out.println("i = " + i);
		
		
	}
	
	
	public static int reachableNodes(int[][] edges, int maxMoves, int n) {
		List<int[]>[] g = new List[n];
		Arrays.setAll(g, e -> new ArrayList<>());
		int u, v, cnt;
		// 初始化无向图
		for (int[] edge : edges) {
			u = edge[0];
			v = edge[1];
			cnt = edge[2] + 1;
			// u -> v = cnt v -> u = cnt
			g[u].add(new int[]{v, cnt});
			g[v].add(new int[]{u, cnt});
		}
		
		// 将节点 0 到 各个节点的距离存储到 dist 中 | 扩展：如果求所有节点到各个节点的距离 dist[][];
		int[] dist = new int[n];
		Arrays.fill(dist, 1 << 30);
		dist[0] = 0;
		
		// 优先级队列根据 a[0][*] 从小到大排序
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		// 0-> 0 的距离为 0
		queue.offer(new int[]{0, 0});
		
		// dijkstra 算法算出点 0 到其他各个点的距离
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			// d = 点0到 poll[0] 的最小距离
			int d = poll[0];
			u = poll[1];
			// 计算点u到相邻各个点的距离
			for (int[] next :
					g[u]) {
				v = next[0];
				cnt = next[1];
				// 点 v - > u 的距离是最小的则存储，然后将点 v（u 附近的点） 存储到队列中，下次查看
				if (d + cnt < dist[v]) {
					dist[v] = d + cnt;
					queue.offer(new int[]{dist[v], v});
				}
			}
		}
		int ans = 0;
		// 计算小于 maxMoves 的原始图点的个数
		for (var d : dist) {
			if (d <= maxMoves) {
				++ans;
			}
		}
		// 遍历原始图 计算 通过 u v 节点可以到达的新节点个数
		for (var e : edges) {
			u = e[0];
			v = e[1];
			cnt = e[2];
			// 通过 u v 节点到达新节点的个数
			int a = Math.min(cnt, Math.max(0, maxMoves - dist[u]));
			int b = Math.min(cnt, Math.max(0, maxMoves - dist[v]));
			ans += Math.min(cnt, a + b);
		}
		return ans;
	}
}