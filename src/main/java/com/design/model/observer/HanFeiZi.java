package com.design.model.observer;

/**
 * 被观察的角色
 *
 * @author FYF
 * @version 1.0
 * @date 2022/10/9 12:45
 */
public class HanFeiZi implements IHanFeiZi {
	
	private boolean isHavingBreakfast = false;
	private boolean isHavingFun = false;
	
	@Override
	public void haveBreakfast() {
		System.out.println("韩非子:开始吃饭了...");
		this.isHavingBreakfast = true;
	}
	
	@Override
	public void haveFun() {
		System.out.println("韩非子:开始娱乐了...");
		this.isHavingFun = true;
	}
	
	
	public boolean isHavingBreakfast() {
		return isHavingBreakfast;
	}
	
	public void setHavingBreakfast(boolean havingBreakfast) {
		isHavingBreakfast = havingBreakfast;
	}
	
	public boolean isHavingFun() {
		return isHavingFun;
	}
	
	public void setHavingFun(boolean havingFun) {
		isHavingFun = havingFun;
	}
}