package com.fyf.ltc.lc_1200;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1145 {
	
	public static void main(String[] args) {
		
	}
	
	
	TreeNode tempNode;
	
	/**
	 * 深度遍历节点 x 的父节点、左子树、右子树
	 * 如果三个区域内的节点数量有大于 ( n + 1 )/2 ，那么则返回 true，否则返回 false
	 *
	 * @param root 节点
	 * @param n    节点数量
	 * @param x    x节点
	 *
	 * @return true
	 */
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		find(root, x);
		int leftCount, rightCount;
		// 计算左子树数量
		leftCount = getChildNodeCount(tempNode.left);
		if (leftCount >= (n + 1) / 2) {
			return true;
		}
		
		// 计算右子树数量
		rightCount = getChildNodeCount(tempNode.right);
		if (rightCount >= (n + 1) / 2) {
			return true;
		}
		
		return n - leftCount - rightCount > (n + 1) / 2;
	}
	
	private int getChildNodeCount(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + getChildNodeCount(node.left) + getChildNodeCount(node.right);
	}
	
	private void find(TreeNode root, int x) {
		
		if (tempNode != null || root == null) {
			return;
		}
		
		if (root.val == x) {
			tempNode = root;
			return;
		}
		
		find(root.left, x);
		find(root.right, x);
		
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
