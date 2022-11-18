package com.util;

import org.apache.commons.lang3.time.StopWatch;

import java.io.File;

/**
 * @author FYF
 * @since 2022/11/16 15:26
 */
public class ScanFileDirectory {
	
	
	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		
		File file = new File("D:\\");
		
		
		
		stopWatch.stop();
		System.out.println("stopWatch = " + stopWatch.formatSplitTime());
	}
	



}