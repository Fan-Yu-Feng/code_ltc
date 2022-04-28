package com.concurrency.ThreadPool;

/**
 * @author FYF @Description
 * @date 2022/3/31
 */
public class LiftOff implements Runnable {
  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread.
   *
   * <p>The general contract of the method <code>run</code> is that it may take any action
   * whatsoever.
   *
   * @see Thread#run()
   */
  protected int countDown = 10;

  private final int id = taksCount++;
  private static int taksCount = 0;

  public LiftOff(int countDown) {
    this.countDown = countDown;
  }

  public LiftOff() {
    System.out.println("启动" + id);
  }

  public String status() {
    return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ")";
  }

  @Override
  public void run() {
    while (countDown-- > 0) {
      System.out.println(status());
    }
    long startTime = System.currentTimeMillis();
    Thread.yield();
    long endTime = System.currentTimeMillis();
    System.out.println("转为就绪态时间：" + (endTime - startTime));
  }
}
