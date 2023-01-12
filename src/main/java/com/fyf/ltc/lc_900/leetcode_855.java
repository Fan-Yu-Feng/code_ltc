package com.fyf.ltc.lc_900;

import org.apache.poi.ss.formula.functions.T;

import java.util.TreeSet;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_855 {
	
	
	public static void main(String[] args) {
		
	}
	
	
}

class ExamRoom {
	int n;
	TreeSet<Integer> treeSet;
	
	public ExamRoom(int n) {
		this.n = n;
		treeSet = new TreeSet<>();
	}
	
	public int seat() {
		if (treeSet.size() == 0) {
			treeSet.add(0);
			return 0;
		}
		int pre = treeSet.first(), ans = treeSet.first();
		int idx = 0;
		for (int x :
				treeSet) {
			// 记录最大间距
			if ((x - pre) / 2 > ans) {
				ans = (x - pre) / 2;
				idx = (x + pre) / 2;
			}
			pre = x;
		}
		// 当只有0时，最右边距判断
		int d = n - 1 - treeSet.last();
		if(d > ans){
			ans = d ;
			idx = n-1;
		}
		treeSet.add(idx);
		return idx;
	}
	
	public void leave(int p) {
		treeSet.remove(p);
	}
}

