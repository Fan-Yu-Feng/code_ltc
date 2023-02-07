package com.fyf.ltc.lc_1700;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1669 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	//  Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode() {
		}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode ans = list1;
		
		// 指向下表为 a 的前一个节点
		for (int i = 0; i < a; i++) {
			list1 = list1.next;
		}
		
		ListNode temp = list1;

		// temp 指向了 b
		for (int i = 0; i < b - a + 1;   i++) {
			temp = temp.next;
		}
		
		// list1 指向 list2的下一个节点
		list1.next = list2;
		
		// list2 指向了尾部
		while (list2.next!=null){
			list2 = list2.next;
		}
		
		list2.next = temp.next;
		
		return ans;
	}
	
	
}