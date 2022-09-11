package com.design.model.mediator;

import com.design.model.mediator.manager.Purchase;
import com.design.model.mediator.manager.Sale;
import com.design.model.mediator.manager.Stock;

/**
 * 抽象中介
 *
 * @author FYF
 * @date 2022/9/11
 */
public abstract class AbstractMediator {
	
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;
	
	//构造函数
	public AbstractMediator() {
		purchase = new Purchase(this);
		sale = new Sale(this);
		stock = new Stock(this);
	}
	
	/**
	 * 中介者最重要的方法叫做事件方法，处理多个对象之间的关系
	 *
	 * @param str     srt
	 * @param objects obj
	 */
	public abstract void execute(String str, Object... objects);
	
	
}