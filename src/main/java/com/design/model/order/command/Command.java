package com.design.model.order.command;

import com.design.model.order.group.CodeGroup;
import com.design.model.order.group.PageGroup;
import com.design.model.order.group.RequirementGroup;
import com.design.model.order.reciver.Receiver;

/**
 * @author FYF @Description
 * @date 2022/7/8
 */
public abstract class Command {

  /** 定义好组 子类可以使用 */
  protected RequirementGroup rg = new RequirementGroup();

  protected PageGroup pg = new PageGroup();
  protected CodeGroup cg = new CodeGroup();

  /** 执行命令 */
  public abstract void execute();


}
