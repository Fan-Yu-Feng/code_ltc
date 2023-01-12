package com.fyf.ltc.lc_300;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_208 {
	
	
	public static void main(String[] args) {
		
	}
	
	
}

/**
 * 解法一：基于哈希表的前缀树
 * 本题考查前缀树的实现。在了解前缀树的结构和作用后，其实现是简单而直接的。前缀树问题一般都是在同一棵树上求解。树的根为非前缀，前缀从根的儿子开始。树结点类通常写作Trie。每一个结点的儿子结点数量，与「构成前缀的基本元素的种类数」相关。本题的插入和搜索方法也是一般前缀树的基本方法。
 * <p>
 * insert：从root开始按输入的word的字符依次向下延伸，若无代表次字符的结点，创建之。
 * search：向下寻找word，若找到，则末尾字符处判断是否为单词。因此，Trie类还需维护一个isEnd属性，用以标记到该节点为止的前缀是否为单词。
 * startsWith：向下寻找prefix。某一字符找不到则立即返回false，否则返回true。
 * 其中，2，3动作类似，可以另外给出一个searchPrefix方法，寻找输入的字符串是否在前缀树上，找到则返回最后一个结点，否则返回null。于是2和3就可以通过调用searchPrefix，以一条返回语句完成方法。
 * <p>
 * 时间复杂度：初始化为O(1)，每次操作为O(N)，N为插入或查找的字符串的长度。
 * 空间复杂度：O(N)，N表示Trie结点数量。N基本上等于所有插入字符的长度之和。（说基本上是因为如果插入单词的有部分前缀相同，那么结点数量要减去这些前缀的长度）。
 */
class Trie {
	private HashMap<Character, Trie> childNode;
	private boolean isEnd;
	
	public Trie() {
		this.childNode = new HashMap<>();
		this.isEnd = false;
	}
	
	public void insert(String word) {
		Trie node = this;
		for (char c : word.toCharArray()) {
			if (node.childNode.get(c) == null) {
				node.childNode.put(c, new Trie());
			}
			node = node.childNode.get(c);
		}
		node.isEnd = true;
	}
	
	public boolean search(String word) {
		Trie trie = searchPrefix(word);
		return trie != null && trie.isEnd;
	}
	
	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}
	
	private Trie searchPrefix(String prefix) {
		Trie node = this;
		for (char c : prefix.toCharArray()) {
			if (node.childNode.get(c) == null) {
				return null;
			}
			node = node.childNode.get(c);
		}
		return node;
	}
	
}