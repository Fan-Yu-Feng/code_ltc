package com.design.model.factory.singleton.factory;

import com.design.model.factory.human.Human;
import com.design.model.factory.singleton.human.MaleBlackHuman;
import com.design.model.factory.singleton.human.MaleWhiteHuman;
import com.design.model.factory.singleton.human.MaleYellowHuman;

/**
 * 生产男性的八卦炉
 *
 * @author FYF
 * @date 2022/8/6
 */
public class MaleFactoryI implements IHumanFactory {
  @Override
  public Human createYellowHuman() {
    return new MaleYellowHuman();
  }

  @Override
  public Human createWhiteHuman() {
    return new MaleWhiteHuman();
  }

  @Override
  public Human createBlackHuman() {
    return new MaleBlackHuman();
  }
}
