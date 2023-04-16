package com.handle.limit;

/**
 * @author FYF
 * @date 2023/4/15
 */

/**
 * 令牌桶限流器
 *
 */
public class TokenBucketLimiterStrategy extends AbstractLimiterStrategy {
	
	/**
	 * lua 脚本路径
	 * 该脚本每次调用 access 仅减少一个令牌 (脚本内觉得的)
	 */
	static final String SCRIPT_FILE_NAME = "lua/Barrel-Token.lua";
	
	// LimiterPolicy 脚本所需参数类
	public TokenBucketLimiterStrategy(LimiterPolicy limiterPolicy) {
		super(limiterPolicy);
	}
	
	@Override
	public String LimiterFilePath() {
		return SCRIPT_FILE_NAME;
	}
}