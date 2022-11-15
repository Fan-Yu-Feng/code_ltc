package com.fyf.ltc.lc_1800;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-units-on-a-truck
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1710 {
	
	
	public static void main(String[] args) {
		int arr[][] = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3,9}};
		
		int i = maximumUnits(arr, 10);
		
		System.out.println("i = " + i);
		
		
	}
	
	
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, ((o1, o2) -> o2[1] -o1[1]));
		
		int ans = 0;
		
		for (int[] boxType : boxTypes) {
			int unitNum = boxType[0];
			int unitCount = boxType[1];
			if (truckSize > unitNum) {
				ans += unitNum * unitCount;
				truckSize -= unitNum;
			} else {
				ans += truckSize * unitCount;
				break;
			}
		}
		
		return ans;
	}
	
}