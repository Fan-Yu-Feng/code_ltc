package com.concurrency.ThreadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author FYF @Description
 * @date 2022/3/31
 */
public class executorMain {
  public static void main(String[] args) {
    LiftOff liftOff = new LiftOff();
    for (int i = 0; i < 10; i++) {
      liftOff.run();
      System.out.println(" 当前线程执行：i = " + i);
    }

    // 线程池
    ExecutorService cacha = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      cacha.execute(new LiftOff());
      cacha.shutdown();
    }
    ExecutorService fix = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      fix.execute(new LiftOff());
      fix.shutdown();
    }
    ExecutorService single = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 10; i++) {
      single.execute(new LiftOff());
      single.shutdown();
    }
  }

  @Test
  public void Test() {
    Thread t = new Thread(new LiftOff());
    t.start();
    System.out.println("wait off");
  }
}
