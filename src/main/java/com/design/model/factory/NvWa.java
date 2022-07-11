package com.design.model.factory;

import com.design.model.factory.human.BlackHuman;
import com.design.model.factory.human.Human;
import com.design.model.factory.human.WhiteHuman;
import com.design.model.factory.human.YellowHuman;

/**
 * 女娲类
 *
 * @author FYF
 * @date 2022/7/11
 */
public class NvWa {
	public static void main(String[] args) {
		// 声明阴阳八卦炉
		AbstractHumanFactory YinYangLu = new HumanFactory();
		System.out.println("造白人");
		Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();
		System.out.println("造黄人");
		Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
		System.out.println("造黑人");
		Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
	}
	
}