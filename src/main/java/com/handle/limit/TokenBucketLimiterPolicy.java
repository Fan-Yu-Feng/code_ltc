package com.handle.limit;

/**
 * @author FYF
 * @date 2023/4/15
 */

import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * 令牌桶限流器的执行对象
 */
public class TokenBucketLimiterPolicy implements LimiterPolicy {
	
	/**
	 * 限流时间间隔
	 * (重置桶内令牌的时间间隔)
	 */
	private final long resetBucketInterval;
	/**
	 * 最大令牌数量
	 */
	private final long bucketMaxTokens;
	
	/**
	 * 初始可存储数量
	 */
	private final long initTokens;
	
	/**
	 * 每个令牌产生的时间
	 */
	private final long intervalPerPermit;
	
	/**
	 * 令牌桶对象的构造器
	 * @param bucketMaxTokens 桶的令牌上限
	 * @param resetBucketInterval 限流时间间隔 (单位毫秒)
	 * @param initTokens 初始化令牌数
	 */
	public TokenBucketLimiterPolicy(long bucketMaxTokens, long resetBucketInterval, long initTokens) {
		// 最大令牌数
		this.bucketMaxTokens = bucketMaxTokens;
		// 限流时间间隔
		this.resetBucketInterval = resetBucketInterval;
		// 令牌的产生间隔 = 限流时间 / 最大令牌数
		this.intervalPerPermit = resetBucketInterval / bucketMaxTokens;
		// 初始令牌数
		this.initTokens = initTokens;
	}
	
	public long getResetBucketInterval() {
		return resetBucketInterval;
	}
	
	public long getBucketMaxTokens() {
		return bucketMaxTokens;
	}
	
	public long getInitTokens() {
		return initTokens;
	}
	
	public long getIntervalPerPermit() {
		return intervalPerPermit;
	}
	
	// 这个顺序和脚本取值有关系
	@Override
	public List<String> toParams() {
		List<String > list = Lists.newArrayList();
		list.add(String.valueOf(getIntervalPerPermit()));
		list.add(String.valueOf(System.currentTimeMillis()));
		list.add(String.valueOf(getInitTokens()));
		list.add(String.valueOf(getBucketMaxTokens()));
		list.add(String.valueOf(getResetBucketInterval()));
		return list;
	}
	
}