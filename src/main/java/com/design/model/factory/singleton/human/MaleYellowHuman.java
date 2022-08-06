package com.design.model.factory.singleton.human;

import com.design.model.factory.singleton.AbstractYellowHuman;

/**
 * @author FYF
 * @date 2022/8/6
 */
public class MaleYellowHuman extends AbstractYellowHuman {
  /** 黄人男性 */
  @Override
  public void getSex() {
    System.out.println("黄人男性");
  }
}
