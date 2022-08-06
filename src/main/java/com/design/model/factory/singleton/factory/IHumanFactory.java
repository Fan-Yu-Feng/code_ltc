package com.design.model.factory.singleton.factory;

import com.design.model.factory.human.Human;

/**
 * 八卦炉生产人类定义
 *
 * @author FYF
 * @date 2022/8/6
 */
public interface IHumanFactory {
  /**
   * 制造一个黄色人种
   *
   * @return Human
   */
  Human createYellowHuman();

  /**
   * 制造一个白色人种
   *
   * @return Human
   */
  Human createWhiteHuman();

  /**
   * 制造一个黑色人种
   *
   * @return Human
   */
  Human createBlackHuman();
}
