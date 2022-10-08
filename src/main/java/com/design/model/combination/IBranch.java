package com.design.model.combination;

import java.util.ArrayList;

/**
 * 其他有分支的节点接口
 *
 * @author FYF
 * @date 2022/10/3
 */
public interface IBranch extends ICorp {
	
	/**
	 * 获得信息
	 *
	 * @return String
	 */
	@Override
	String getInfo();
	
	/**
	 * 获得下级信息
	 *
	 * @return ArrayList
	 */
	ArrayList<Object> getSubordinateInfo();
	
	/**
	 * 增加叶子节点信息
	 *
	 * @param corp 分支或树叶
	 */
	void addSubordinate(ICorp corp);
	
}
