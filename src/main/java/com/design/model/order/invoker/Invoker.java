package com.design.model.order.invoker;

import com.design.model.order.command.Command;

/**
 * @author FYF @Description
 * @date 2022/7/8
 */
public class Invoker {
  public Command getCommand() {
    return command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  /** 命令 */
  private Command command;

  public void action() {
    this.command.execute();
  }
}
