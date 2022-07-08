package com.design.model.order;

import com.design.model.order.command.DeletePageCommand;
import com.design.model.order.group.Group;
import com.design.model.order.group.PageGroup;
import com.design.model.order.group.RequirementGroup;
import com.design.model.order.invoker.Invoker;

/**
 * @author FYF @Description 场景类
 * @date 2022/7/8
 */
public class Client {
  public static void main(String[] args) {
    System.out.println("-------客户要求增加需求-------");
    Group rg = new RequirementGroup();
    rg.find();
    rg.add();
    rg.plan();

    System.out.println("-------客户要求删除页面-------");
    Group pg = new PageGroup();
    pg.find();
    pg.delete();
    pg.plan();
    /*-----------当有了执行者之后的代码*/

    System.out.println("-------当有了执行者之后的代码-------");
    Invoker pm = new Invoker();
    DeletePageCommand deletePageCommand = new DeletePageCommand();

    pm.setCommand(deletePageCommand);
    pm.action();
  }
}
