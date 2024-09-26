package com.fyf.ltc.lc_600;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_543 {
	
	
	public static void main(String[] args) {
		
	}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


	private int maxDiameter = 0;

	/**
	 * 给你一棵二叉树的根节点，返回该树的 直径 。
	 *
	 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
	 *
	 * 两节点之间路径的 长度 由它们之间边数表示。
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		maxDiameter = 0;
		dfs(root);
		return maxDiameter;
	}


	/**
	 * 在 dfs 方法中，首先检查当前节点 root 是否为空。
	 * 如果为空，则返回 0，表示路径长度为 0。
	 * 否则，递归调用 dfs 方法计算左子树和右子树的最长路径，分别存储在 left 和 right 变量中。
	 * 接下来，更新值 maxDiameter 为当前计算出的最大直径，即 left + right。
	 * 最后，返回当前节点的最长路径长度，即 Math.max(left, right) + 1。
	 * 这个值表示从当前节点出发最长路径长度，包括当前节点本身
	 * @param root
	 * @return
	 */
	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		maxDiameter = Math.max(maxDiameter, left + right);
		return Math.max(left, right) + 1;
	}

}