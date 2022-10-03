package com.design.model.combination;

import java.util.ArrayList;

/**
 * 其他有分支的节点接口
 *
 * @author FYF
 * @date 2022/10/3
 */
public interface IBranch {
	
	/**
	 * 获得信息
	 *
	 * @return String
	 */
	String getInfo();
	
	/**
	 * 增加数据节点，例如研发部下设的研发一组
	 *
	 * @param branch 数据节点
	 */
	void add(IBranch branch);
	
	/**
	 * 增加叶子节点
	 *
	 * @param leaf 叶子节点
	 */
	void add(ILeaf leaf);
	
	/**
	 * 获得下级信息
	 *
	 * @return ArrayList
	 */
	ArrayList<Object> getSubordinateInfo();
}
