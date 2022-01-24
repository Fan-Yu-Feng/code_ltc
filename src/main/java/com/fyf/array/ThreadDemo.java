package com.fyf.array;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author FYF @Description
 * @date 2021/11/24
 */
public class ThreadDemo extends twoSum implements Runnable {

  public void run() {
    System.out.println("MyThread run!");
  }

  public static void main(String[] args) {
    ThreadDemo threadDemo = new ThreadDemo();
    Thread thread = new Thread(threadDemo, "thread");
  }

  public void AbstractQueuedSynchronizerDemo() {
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
  }
}
