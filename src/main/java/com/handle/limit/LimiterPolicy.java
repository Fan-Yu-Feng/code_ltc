package com.handle.limit;

import java.util.List;

/**
 * 限制器脚本所需参数接口
 */
public interface LimiterPolicy {
	
	/**
	 * 转成字符串数组，数组顺序与脚本取参顺序有关
	 * @return
	 */
	List<String> toParams();
	
}