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
	public static String getInnerOrderNo(){
		long snowId = SNOW_INSTANCE.nextId();
		
		Random random = new Random();
		int i = random.nextInt(100);
		String s = String.valueOf(i);
		String s1 = String.valueOf(snowId).substring(2);
		return s.concat(s1);
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