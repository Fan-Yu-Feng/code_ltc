package com.fyf.ltc.lc_800;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 你可以做一些数量的移动 numMoves :
 *
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * https://leetcode.cn/problems/reach-a-number/
 *
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_724 {
	
	
	public static void main(String[] args) {
		
		
		int i = reachNumber(10);
		System.out.println("i = " + i);
		
	}
	
	public static int reachNumber(int target) {
		
		target = Math.abs(target);
		
		int sum = 0;
		int moves = 0;
		
		while(sum < target){
			sum +=++moves;
		}
		
		return getMinMoveNum(moves,target);
	}
	
	/**
	 * 官方题解
	 *
	 * @param target 目标数字
	 * @return 次数
	 */
	public static int reachNumber2(int target) {
		
		target = Math.abs(target);
		int moves = 0;
		
			while(target > 0){
				target-=++moves;
			}
		
		// 如果目标为偶数 则结果 在 0-move 之间可以获得
		// 如果目标为奇数，则结果在 0 ~ move + 1 | move +2 可以获得
		return target % 2 == 0? moves : moves + 1+ moves%2;
	}
	
	private static int getMinMoveNum(int moves, int target) {
		int remainder = (moves - 1) % 4 + 1;
		if(target % 2 == 0){
			moves += Math.max(3 - remainder, 0);
		}else if (remainder > 2){
			moves += Math.max(5 - remainder, 0);
		}
		return moves;
	}
}