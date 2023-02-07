package com.fyf.ltc.lc_1900;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1825 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	class MKAverage {
		// 最后 M 个元素 使用队列来获取
		private Queue<Integer> que;
		// loMap表示最小的k个元素的集合，hiMap表示最大的k个元素的集合， midMap表示其他 m - 2k 个元素的集合
		private TreeMap<Integer, Integer> loMap;
		private TreeMap<Integer, Integer> midMap;
		private TreeMap<Integer, Integer> hiMap;
		
		
		private long sum;
		// 分别表示loMap 和 hiMap中的元素个数
		private int loSize, hiSize;
		
		
		private int m, k;
		
		public MKAverage(int m, int k) {
			// TreeMap 元素进行排序
			loMap = new TreeMap<>();
			midMap = new TreeMap<>();
			hiMap = new TreeMap<>();
			que = new ArrayDeque<>();
			this.m = m;
			this.k = k;
			sum = 0;
			loSize = 0;
			hiSize = 0;
		}
		
		/**
		 * 添加元素
		 * 1、元素需要先进队列里 que
		 * 2、队列元素的数量大于 m ，保持队列的长度为 m 剔除队列的首个元素，同时，更新 loMap、hiMap、midMap、loSize、hiSize、midSize、sum
		 * 3、如果hiMap 元素数量大于 k，则将最小的元素转移到 midMap 中 要更新 loSize 和 sum
		 * 4、如果 loMap 元素数量大于 k。则将最大的元素转移到 midMap 中 要更新 hiSize 和 sum
		 * 5、如果 loMap 元素数量小于 k 且 midMap 不为空，则需要将 midMap 中最小的元素转移到loMap 中，（需更新loSize和sum）
		 * 6、如果hiMap中元素个数小于k且 midMap不为空，则需要将midMap中最大的元素转移到hiMap中（需更新hiSize和sum）
		 */
		public void addElement(int num) {
			que.offer(num);
			if (loMap.isEmpty() || num <= loMap.lastKey()) {
				loMap.merge(num, 1, Integer::sum);
				++loSize;
			} else if (hiMap.isEmpty() || num >= hiMap.firstKey()) {
				hiMap.merge(num, 1, Integer::sum);
				++hiSize;
			} else {
				midMap.merge(num, 1, Integer::sum);
				sum += num;
			}
			if (que.size() > m) {
				int x = que.poll();
				if (loMap.containsKey(x)) {
					if (loMap.merge(x, -1, Integer::sum) == 0) {
						loMap.remove(x);
					}
					--loSize;
				} else if (hiMap.containsKey(x)) {
					if (hiMap.merge(x, -1, Integer::sum) == 0) {
						hiMap.remove(x);
					}
					--hiSize;
				} else {
					if (midMap.merge(x, -1, Integer::sum) == 0) {
						midMap.remove(x);
					}
					sum -= x;
				}
			}
			
			// 维护 treeMap 长度不超过 k
			while (loSize > k) {
				int x = loMap.lastKey();
				if (loMap.merge(x, -1, Integer::sum) == 0) {
					loMap.remove(x);
				}
				midMap.merge(x, 1, Integer::sum);
				sum += x;
				--loSize;
			}
			while (hiSize > k) {
				int x = hiMap.firstKey();
				if (hiMap.merge(x, -1, Integer::sum) == 0) {
					hiMap.remove(x);
				}
				midMap.merge(x, 1, Integer::sum);
				sum += x;
				--hiSize;
			}
			
			// 如果 midMap 不为空 且 hiMap、loMap 长度小于k 进行维护
			while (loSize < k && !midMap.isEmpty()) {
				Integer x = midMap.firstKey();
				if (midMap.merge(x, -1, Integer::sum) == 0) {
					midMap.remove(x);
				}
				sum -= x;
				loMap.merge(x, 1, Integer::sum);
				++loSize;
			}
			while (hiSize < k && !midMap.isEmpty()) {
				Integer x = midMap.lastKey();
				if (midMap.merge(x, -1, Integer::sum) == 0) {
					midMap.remove(x);
				}
				sum -= x;
				hiMap.merge(x, 1, Integer::sum);
				++hiSize;
			}
			
			
		}
		
		
		public int calculateMKAverage() {
			// 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中
			if (que.size() < m) {
				return -1;
			}
			
			return (int) (sum / (m - 2 * k));
		}
	}
}