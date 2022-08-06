package com.design.model.factory.singleton.human;

import com.design.model.factory.singleton.AbstractYellowHuman;

/**
 * @author FYF
 * @date 2022/8/6
 */
public class FemaleBlackHuman extends AbstractYellowHuman {
	/**
	 * 黑人女性
	 */
	@Override
	public void getSex() {
		System.out.println("黑人女性");
	}
}