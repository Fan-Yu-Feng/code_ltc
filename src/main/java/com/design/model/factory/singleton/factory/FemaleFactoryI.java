package com.design.model.factory.singleton.factory;

import com.design.model.factory.human.Human;
import com.design.model.factory.singleton.human.FemaleBlackHuman;
import com.design.model.factory.singleton.human.FemaleWhiteHuman;
import com.design.model.factory.singleton.human.FemaleYellowHuman;

/**
 * 生产女性的八卦炉
 * @author FYF
 * @date 2022/8/6
 */
public class FemaleFactoryI implements IHumanFactory {
	@Override
	public Human createYellowHuman() {
		return new FemaleYellowHuman();
	}
	
	@Override
	public Human createWhiteHuman() {
		return new FemaleWhiteHuman();
	}
	
	@Override
	public Human createBlackHuman() {
		return new FemaleBlackHuman();
	}
}