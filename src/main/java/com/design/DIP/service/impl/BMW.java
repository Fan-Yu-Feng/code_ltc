package com.design.DIP.service.impl;

import com.design.DIP.service.ICar;

/**
 * @author FYF @Description 宝马车
 * @date 2022/4/28
 */
public class BMW implements ICar {
  @Override
  public void run() {
    System.out.println("开宝马");
  }
}
