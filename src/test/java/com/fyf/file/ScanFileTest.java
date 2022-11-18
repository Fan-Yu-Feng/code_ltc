package com.fyf.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author FYF
 * @since 2022/11/16 15:31
 */
@Slf4j
public class ScanFileTest {
	
	
	@Test
	public void scanFile() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<String> list = new ArrayList<>();
		File[] f = getSystem();
		//循环遍历出本机盘符并对指定文件后缀名进行查找在控制台遍历出来
		for (File file : f) {
			log.info(file.getAbsolutePath());
			//查找到某个盘符过后即对本盘符下查找指定文件后缀名的文件
			list = getFileName(file, executorService);
			log.info(" filePath  : {}  file.size() ：{}" ,file.getAbsolutePath(),list.size());
		}
		//打印文件总数
		stopWatch.stop();
		log.info("stopWatch = " + stopWatch.getTime());
		
	}
	
	private File[] getSystem() {
		// File[] file = File.listRoots();
		File[] files = new File[]{new File("D:\\businessdata\\")};
		return files;
	}
	
	private List<String> getFileName(File fileDirectory, ExecutorService executorService) {
		List<String> list = new ArrayList<>();
		
		File[] f = fileDirectory.listFiles();
		CountDownLatch countDownLatch = new CountDownLatch(f.length);
		//判断f数组是否为空
		if (f.length > 0) {
			for (File files : f) {
				if(files.isDirectory()){
					executorService.execute(new Task(files,countDownLatch));
				}
				String fileName = files.getAbsolutePath();
				log.info(" filePath = {}" , fileName);
				list.add(files.getName());
			}
		}
		try {
			countDownLatch.await();
		} catch (Exception e) {
			log.info("e = " + e.getMessage());
		}
		return list;
	}
	
	
}

@Slf4j
class Task implements Runnable {
	private final File file;
	
	private final CountDownLatch countDownLatch;
	
	public Task(File files, CountDownLatch countDownLatch) {
		this.file = files;
		this.countDownLatch = countDownLatch;
	}
	

	
	@Override
	public void run() {
		
		try {
			List<String> list = getFileName(file);
			log.info(" filePath  : {}  file.size() ：{}" ,file.getAbsolutePath(),list.size());
		} catch (Exception e) {
			log.info("e = " + e);
		} finally {
			countDownLatch.countDown();
		}
	}
	
	
	/**
	 * 获取对应盘符下符合要求的文件
	 */
	private List<String> getFileName(File file) {
		List<String> list = new ArrayList<>();
		File[] f = file.listFiles();
		//判断f数组是否为空
		if (f != null && f.length > 0) {
			for (File files : f) {
				if (files.isDirectory()) { //判断是文件夹
					CollectionUtils.addAll(list,getFileName(files));
					
					log.info("start scan file directory :{}" , files.getAbsolutePath());
				} else {
					String fileName = files.getAbsolutePath();
					log.info(" filePath = {}" , fileName);
					list.add(files.getName());
				}
			}
		}
		return list;
	}
	
	
}
