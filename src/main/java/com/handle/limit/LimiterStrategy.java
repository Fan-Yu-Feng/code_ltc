package com.handle.limit;

/**
 * 限流器实现接口
 *
 * @author FYF
 * @date 2023/4/15
 */
public interface LimiterStrategy {
	/**,
	 * 返回是否应该通过
	 *
	 * @param key
	 * @return
	 */
	boolean access(String key);
	
}