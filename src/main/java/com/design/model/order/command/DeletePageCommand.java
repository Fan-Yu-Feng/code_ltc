package com.design.model.order.command;

/**
 * @author FYF @Description 删除页面
 * @date 2022/7/8
 */
public class DeletePageCommand extends Command {
  /** 执行命令 */
  @Override
  public void execute() {
    // 找到页面组
    super.pg.find();
    // 删除页面
    super.pg.delete();
    // 变更计划
    super.pg.plan();
  }
}
