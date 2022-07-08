package com.design.model.order.command;

/**
 * @author FYF @Description 新增需求
 * @date 2022/7/8
 */
public class AddRequirementCommand extends Command {
  /** 执行命令 */
  @Override
  public void execute() {
    // 找到需求组
    super.rg.find();
    // 添加需求
    super.rg.add();
    // 变更计划
    super.rg.plan();
  }
}
