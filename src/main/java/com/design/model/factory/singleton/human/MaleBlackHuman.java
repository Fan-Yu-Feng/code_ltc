package com.design.model.factory.singleton.human;

import com.design.model.factory.singleton.AbstractYellowHuman;

/**
 * @author FYF
 * @date 2022/8/6
 */
public class MaleBlackHuman extends AbstractYellowHuman {
  /** 黑人男性 */
  @Override
  public void getSex() {
    System.out.println("黑人男性");
  }
}
