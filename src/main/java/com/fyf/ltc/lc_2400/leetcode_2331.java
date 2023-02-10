package com.fyf.ltc.lc_2400;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_2331 {
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean evaluateTree(TreeNode root) {
		if(root!=null && root.val == 2){
			// or
			return evaluateTree(root.left) | evaluateTree(root.right);
		}else if(root!=null && root.val == 3){
			// and
			return evaluateTree(root.left) & evaluateTree(root.right);
		}
		return root.val == 1;
	}
	
	
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
	}
	
	TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
