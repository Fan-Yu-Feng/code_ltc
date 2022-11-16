package com.fyf.ltc.competition.week318;

/**
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/total-cost-to-hire-k-workers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2462 {
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1, 5, 4, 2, 9, 9, 9};
		int k = 3;
		
		long l = totalCost(arr, k, 3);
		System.out.println("l = " + l);
		
		
	}
	
	public static long totalCost(int[] costs, int k, int candidates) {
		int length = costs.length;
		
		int ans = 0;
		
		
		for(int i = 0; i < length; i++) {
			if(i >= candidates && i<=length -candidates){
				continue;
			}
			ans+=costs[i];
			
			
			
			
		}
		
		return 0;
	}
	
}