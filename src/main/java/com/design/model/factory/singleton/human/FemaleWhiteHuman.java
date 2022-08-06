package com.design.model.factory.singleton.human;

import com.design.model.factory.singleton.AbstractYellowHuman;

/**
 * @author FYF
 * @date 2022/8/6
 */
public class FemaleWhiteHuman extends AbstractYellowHuman {
	/**
	 * 白人女性
	 */
	@Override
	public void getSex() {
		System.out.println("白人女性");
	}
}