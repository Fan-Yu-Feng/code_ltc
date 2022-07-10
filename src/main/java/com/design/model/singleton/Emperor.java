package com.design.model.singleton;

/**
 * @author FYF
 * @Description 单例模式，古代皇帝
 * @date 2022/7/10
 */

public class Emperor {
	private static final Emperor emperor = new Emperor();
	private Emperor(){
	}

	public static Emperor getInstance(){
		return emperor;
	}

	public static void saySomething(){
   		System.out.println("皇帝说点啥");
	}
}