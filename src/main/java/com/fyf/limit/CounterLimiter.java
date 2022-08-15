package com.fyf.limit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author FYF
 * @date 2022/8/15
 */
@Slf4j
public class CounterLimiter {
	
	/**
	 * 计数器的时间间隔
	 */
	private static final long INTERVAL = 1000;
	
	private static long startTime = System.currentTimeMillis();
	
	/**
	 * 每秒最大接受数量
	 */
	private final static long MAX_COUNT = 2;
	
	/**
	 * 累加器
	 */
	private static final AtomicLong ACCUMULATOR = new AtomicLong();
	
	private final static int THREAD_NUM = 2;
	
	private final static ExecutorService POOL = Executors.newFixedThreadPool(THREAD_NUM);
	
	/**
	 * 计数器限流
	 *
	 * @param taskId 任务id
	 * @param turn   轮数
	 *
	 * @return long 负数则限流，否则正常通过
	 */
	private static long tryAcquire(long taskId, int turn) {
		long nowTime = System.currentTimeMillis();
		if (nowTime < startTime + INTERVAL) {
			// 线程安全
			long count = ACCUMULATOR.getAndIncrement();
			if (count <= MAX_COUNT) {
				return count;
			} else {
				return -count;
			}
		} else {
			//	如果是新一轮的时间，
			synchronized (CounterLimiter.class) {
				log.info("新的时间已经到了， taskId:{}, turn:{}", taskId, turn);
				// 在一次判断，防止重复初始化
				if (nowTime > startTime + INTERVAL) {
					ACCUMULATOR.set(0);
					startTime = nowTime;
				}
				return 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		AtomicInteger limitTime = new AtomicInteger(0);
		
		CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
		
		// 每个线程执行的轮数
		final int turns = 5;
		long start = System.currentTimeMillis();
		for (int j = 0; j < THREAD_NUM; j++) {
			POOL.submit(() -> {
				for (int i = 0; i < turns; i++) {
					long taskId = Thread.currentThread().getId();
					
					long index = tryAcquire(taskId, i);
					if (index <= 0) {
						limitTime.getAndIncrement();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 等待所有线程结束
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		float time = (System.currentTimeMillis() - start) / 1000F;
		//输出统计结果
		
		log.info("限制的次数为：" + limitTime.get() +
				         ",通过的次数为：" + (THREAD_NUM * turns - limitTime.get()));
		log.info("限制的比例为：" + (float) limitTime.get() / (float) (THREAD_NUM * turns));
		log.info("运行的时长为：" + time);
		
	}
	
}