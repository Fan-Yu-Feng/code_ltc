package com.design.model.order.command;

import com.design.model.order.reciver.Receiver;

/**
 * @author FYF
 * @Description 具体执行命令者1
 * @date 2022/7/10
 */

public class ConcertCommand1 extends Command {

	private Receiver receiver;

	public ConcertCommand1(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		this.receiver.doSomeThing();
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
}