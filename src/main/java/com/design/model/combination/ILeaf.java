package com.design.model.combination;

/**
 * @author FYF
 * @date 2022/10/3
 */
public interface ILeaf extends ICorp {
	
	/**
	 * 获得自己的信息
	 *
	 * @return String
	 */
	@Override
	String getInfo();
}
