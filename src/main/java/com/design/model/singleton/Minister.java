package com.design.model.singleton;

/**
 * @author FYF
 * @Description 大臣类
 * @date 2022/7/10
 */

public class Minister {

  public static void main(String[] args) {
    //
    for (int i = 0; i< 3; i++) {
		//
		Emperor emperor = Emperor.getInstance();
		Emperor.saySomething();
    }
  }
}