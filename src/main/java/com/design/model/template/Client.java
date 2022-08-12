package com.design.model.template;

import com.design.model.template.hummer.HummerH1Model;
import com.design.model.template.hummer.HummerModel;

/**
 * @author FYF
 * @date 2022/8/11
 */
public class Client {
	
	
	/**
	 * 模板方法模式的优点:
	 * 封装不变部分，扩展可变部分 把认为是不变部分的算法封装到父类实现，而可变部分的则可以通过继承来继续扩展。
	 * 提取公共部分代码，便于维护
	 * 行为由父类控制，子类实现
	 * <p>
	 * 缺点：按照我们的设计习惯，抽象类负责声明最抽象、最一般的事物属性和方法，实现类完成
	 * 具体的事物属性和方法。但是模板方法模式却颠倒了，抽象类定义了部分抽象方法，由子类
	 * 实现，子类执行的结果影响了父类的结果，也就是子类对父类产生了影响，这在复杂的项目
	 * 中，会带来代码阅读的难度，而且也会让新手产生不适感。
	 * <p>
	 * 使用场景
	 * 1、多个子类有共有的方法，并且逻辑基本相同
	 * 2、重要、复杂的算法，可以把核心算法设计未模板方法，周边的相关细节功能则由各个子类实现
	 * 3、重构时，模板方法模式是一个经常使用的模式，把相关的代码抽取到父类中，然后通过钩子函数约束其行为
	 */
	
	public static void main(String[] args) {
		HummerModel h1 = new HummerH1Model();
		
		h1.run();
		
	}
}