package com.handle.limit;

import cn.hutool.core.lang.Validator;
import com.util.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.InputStream;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author FYF
 * @date 2023/4/15
 */
@Slf4j
public abstract class AbstractLimiterStrategy implements LimiterStrategy {
	
	@Autowired
	private RedisService redisService;
	
	// 这里是避免重复读取文件与防止并发问题
	private final static ConcurrentMap<String,String> SCRIPT_MAPPING = new ConcurrentHashMap<>();
	
	//lua 脚本路径
	private String scriptPath;
	
	//lua 脚本所需参数
	private LimiterPolicy limiterPolicy;
	
	//lua 脚本内容
	private String script;
	
	/**
	 * 抽象父类限流器的构造器
	 *
	 * @param scriptPath
	 * @param limiterPolicy 一个参数的封装类
	 */
	public AbstractLimiterStrategy(String scriptPath, LimiterPolicy limiterPolicy) {
		// ServerValidUtils 自己实现的断言
		Validator.validateNotEmpty(scriptPath, "scriptPathv is null");
		this.scriptPath = scriptPath;
		Validator.validateNotEmpty(limiterPolicy,"limiterPolicy Can't NULL");
		this.limiterPolicy = limiterPolicy;
		this.init();
	}
	
	public AbstractLimiterStrategy(LimiterPolicy limiterPolicy) {
		this.scriptPath = this.LimiterFilePath();
		Validator.validateNotEmpty(limiterPolicy,"limiterPolicy Can't NULL");
		this.limiterPolicy = limiterPolicy;
		this.init();
	}
	
	// 这个抽象方法是获取文件路径的
	public abstract String LimiterFilePath();
	
	/**
	 * 初始化限流器脚本内容
	 */
	private void init() {
		String mapScript = SCRIPT_MAPPING.get(this.scriptPath);
		if(StringUtils.isBlank(mapScript)){
			try {
				// 构建获取 lua 脚本的脚本
				//classpath: 扫描的是 resources 目录下的
				// 获取资源
				ResourceScriptSource resourceScriptSource = new ResourceScriptSource(new ClassPathResource(this.scriptPath));
				InputStream inputStream = resourceScriptSource.getResource().getInputStream();
				byte[] scriptBytes = inputStream.readAllBytes();
				SCRIPT_MAPPING.putIfAbsent(this.scriptPath,new String(scriptBytes));
			} catch (Exception e) {
				log.error("init limiter error: The file may not exist", e);
				throw new RuntimeException(e);
			}
		}
		this.script = SCRIPT_MAPPING.get(this.scriptPath);
	}
	
	@Override
	public boolean access(String key) {
		// RedisManager.getJedisPool ().getResource () 是自己内部封装的，重点是获取到 Jedis
		try {
			Long remain = redisService.eval(script, Collections.singletonList(key),limiterPolicy.toParams());
			// 调用 eval 方法，参数分别是：脚本内容、Keys 集合，传入参数集合
			//remain 这个脚本返回的不是剩余数量 (具体看脚本实现)
			log.info("限流器类别:{} | key :{} 限流器内许可数量为:{} ", limiterPolicy.getClass().getSimpleName(), key, remain);
			return remain > 0;
		}catch (Exception e){
			log.error("限流器调用错误",e);
			return false;
		}
	}
	
}
