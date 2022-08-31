package com.fyf.limit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 令牌桶 限速
 * 令牌桶的好处之一就是可以方便地应对 突发出口流量（后端能力的提升）。
 * <p>
 * 比如，可以改变令牌的发放速度，算法能按照新的发送速率调大令牌的发放数量，使得出口突发流量能被处理。
 * Guava是Java领域优秀的开源项目，它包含了Google在Java项目中使用一些核心库，包含集合(Collections)，缓存(Caching)，并发编程库(Concurrency)，常用注解(Common annotations)，String操作，
 * I/O操作方面的众多非常实用的函数。 Guava的 RateLimiter提供了令牌桶算法实现：平滑突发限流(SmoothBursty)和平滑预热限流(SmoothWarmingUp)实现。
 *
 * @author FYF
 */
@Slf4j
public class TokenBucketLimiter {
	/**
	 * 上一次令牌发放时间
	 */
	public long lastTime = System.currentTimeMillis();
	/**
	 * 桶的容量
	 */
	public int capacity = 2;
	/**
	 * 令牌生成速度 /s
	 */
	public int rate = 2;
	/**
	 * 当前令牌数量
	 */
	public AtomicInteger tokens = new AtomicInteger(2);
	
	/**
	 * 返回值说明：
	 *
	 * @param taskId     任务id
	 * @param applyCount 申请令牌数量
	 *
	 * @return false 没有被限制到  true 被限流
	 */
	public synchronized boolean isLimited(long taskId, int applyCount) {
		long now = System.currentTimeMillis();
		// 时间间隔,单位为 ms
		long gap = now - lastTime;
		
		// 计算时间段内的令牌数，可以添加的令牌书
		int reversePermits = (int) (gap * rate / 1000);
		int allPermits = tokens.get() + reversePermits;
		// 当前新的令牌数
		tokens.set(Math.min(capacity, allPermits));
		log.info("tokens {} capacity {} gap {} ", tokens, capacity, gap);
		
		if (tokens.get() < applyCount) {
			// 若拿不到令牌,则拒绝
			log.info("被限流了.." + taskId + ", applyCount: " + applyCount);
			return true;
		} else {
			// 还有令牌，领取令牌
			tokens.getAndAdd(-applyCount);
			lastTime = now;
			
			log.info("剩余令牌.." + tokens);
			return false;
		}
		
	}
	
	/**
	 * 线程池，用于多线程模拟测试
	 */
	private final ExecutorService pool = Executors.newFixedThreadPool(10);
	
	@Test
	public void limitTest() {
		
		// 被限制的次数
		AtomicInteger limited = new AtomicInteger(0);
		// 线程数
		final int threads = 2;
		// 每条线程的执行轮数
		final int turns = 20;
		
		
		// 同步器
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		long start = System.currentTimeMillis();
		for (int i = 0; i < threads; i++) {
			pool.submit(() ->
			{
				try {
					
					for (int j = 0; j < turns; j++) {
						
						long taskId = Thread.currentThread().getId();
						boolean intercepted = isLimited(taskId, 1);
						if (intercepted) {
							// 被限制的次数累积
							limited.getAndIncrement();
						}
						
						Thread.sleep(200);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//等待所有线程结束
				countDownLatch.countDown();
				
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		float time = (System.currentTimeMillis() - start) / 1000F;
		// 输出统计结果
		
		log.info("限制的次数为：" + limited.get() +
				         ",通过的次数为：" + (threads * turns - limited.get()));
		log.info("限制的比例为：" + (float) limited.get() / (float) (threads * turns));
		log.info("运行的时长为：" + time);
	}
	
	
}

