package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FYF
 * @since 2023/3/22 14:15
 */
public class FileUtil {
	
	
	/**
	 * 获取文件目录下的所有文件名
	 *
	 * @param fileDir 文件目录
	 *
	 * @return 文件名 list
	 */
	public static List<String> getFileNameByFileDir(String fileDir) {
		ArrayList<String> files = new ArrayList<String>();
		File file = new File(fileDir);
		File[] tempList = file.listFiles();
		
		assert tempList != null;
		for (File value : tempList) {
			if (value.isFile()) {
				files.add(value.toString());
			}
			// if (value.isDirectory()) {
			// }
		}
		return files;
		
	}
	
}