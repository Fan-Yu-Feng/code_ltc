package com.design.model.factory.singleton.human;

import com.design.model.factory.singleton.AbstractYellowHuman;

/**
 * @author FYF
 * @date 2022/8/6
 */
public class MaleWhiteHuman extends AbstractYellowHuman {
  /** 白人男性 */
  @Override
  public void getSex() {
    System.out.println("白人男性");
  }
}
