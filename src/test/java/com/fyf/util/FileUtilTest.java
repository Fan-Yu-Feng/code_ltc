package com.fyf.util;

import com.alibaba.fastjson.JSON;
import com.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FYF
 * @date 2023/3/22
 */
@Slf4j
public class FileUtilTest {
	
	@Test
	public void fileNameTest(){
		String imageDir = "D:\\Desktop\\st\\compressImage";
		List<String> fileListName = FileUtil.getFileNameByFileDir(imageDir);
		Set<String> fileNameSet = new HashSet<>();
		fileNameSet.addAll(fileListName);
		
		log.info(JSON.toJSONString(fileNameSet));
		
	}
}