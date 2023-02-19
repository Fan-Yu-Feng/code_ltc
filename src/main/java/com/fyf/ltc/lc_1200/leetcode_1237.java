package com.fyf.ltc.lc_1200;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1237 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		
		int x = 0, y = 1000;
		List<List<Integer>> ans = new ArrayList<>();
		while (x< 1001 &&  y> -1) {
			int res = customfunction.f(x, y);
			if (res < z) {
				++x;
			} else if (res > z) {
				--y;
			} else {
				ans.add(Arrays.asList(x++, y--));
			}
		}
		return ans;
	}
	
	
}

class CustomFunction {
	// Returns f(x, y) for any given positive integers x and y.
	// Note that f(x, y) is increasing with respect to both x and y.
	// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
	public int f(int x, int y) {
		return 0;
	}
}