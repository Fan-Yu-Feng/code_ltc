package com.fyf.ltc.lc_2000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1971 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 寻找途中是否含有路径，可以使用三种方式：并查集、广度优先遍历、深度优先遍历
	 *
	 * @param n           顶点个数
	 * @param edges       图数组
	 * @param source      原点-顶点
	 * @param destination 目标点-顶点
	 *
	 * @return 是否存在原点到目标点的路径
	 */
	public boolean validPathBsf(int n, int[][] edges, int source, int destination) {
		
		ArrayList<Integer>[] list = new ArrayList[n];
		
		boolean[] visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			list[x].add(y);
			list[y].add(x);
		}
		
		// 队列 存放当前广度遍历的顶点
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.offer(source);
		
		// 到自己是可以访问的
		visited[source] = true;
		
		while (!deque.isEmpty()) {
			int x = deque.peek();
			
			deque.pop();
			
			// 顶点在队列中，说明已经访问过顶点了，直接退出循环
			if (x == destination) {
				break;
			}
			
			for (int des :
					list[x]) {
				// 如果该点未访问，则访问该点
				if (!visited[des]) {
					// 未访问的点入栈
					deque.offer(des);
					// 更新访问记录
					visited[des] = true;
				}
			}
		}
		return visited[destination];
	}
	
	
	public boolean validPathDsf(int n, int[][] edges, int source, int destination) {
		
		ArrayList<Integer>[] list = new ArrayList[n];
		
		boolean[] visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			list[x].add(y);
			list[y].add(x);
		}
		
		// 深度遍历
		return dfs(source, destination, visited, list);
	}
	
	private boolean dfs(int source, int destination, boolean[] visited, ArrayList<Integer>[] list) {
		if (source == destination) {
			return true;
		}
		visited[source] = true;
		
		for (int x :
				list[source]) {
			// 深度遍历与x相联结的数据
			if (!visited[x] && dfs(x, destination, visited, list)) {
				return true;
			}
		}
		return false;
	}
	
	
}