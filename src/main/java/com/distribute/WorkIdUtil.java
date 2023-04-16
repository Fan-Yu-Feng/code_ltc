package com.distribute;

import java.util.Random;

/**
 * @author FYF
 * @since 2022/12/28 17:49
 */
public class WorkIdUtil {
	
	private static final SnowflakeDistributeId SNOW_INSTANCE = SnowflakeDistributeId.getInstance();
	
	public static long getSnowId(){
		return SNOW_INSTANCE.nextId();
	}
	
	public static Long getLongInnerOrderNo(){
		long snowId = getSnowId();
		Random random = new Random();
		int i = random.nextInt(9) + 1;
		String randStr = String.valueOf(i);
		String snowStr = String.valueOf(snowId).substring(2);
		return Long.valueOf(randStr.concat(snowStr));
	}
	
}