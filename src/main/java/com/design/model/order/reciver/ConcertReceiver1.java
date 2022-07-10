package com.design.model.order.reciver;

/**
 * @author FYF
 * @Description 具体执行者1
 * @date 2022/7/10
 */

public class ConcertReceiver1 extends Receiver {
	@Override
	public void doSomeThing() {
    System.out.println("具体执行者1做点什么");
	}
}