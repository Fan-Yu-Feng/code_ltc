package com.fyf.excel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.fastjson.JSONObject;
import com.dto.ExcelCommonData;
import com.fyf.excel.handle.CustomRowWriteHandler;
import com.util.LocalExcelUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用 java 的easyExcel 实现以下功能：读取两个Excel文件 excel1,excel2，
 * 读取第一列数据用 HashMap<String,True>存储起来，
 * 分别为 set1,set2。读取所有数据后，如果 set1 中的值在 set2 中不存在，
 * 则标记为 true, 回写 excel 文件的时候，如果为 true, 则该行设置为黄色。
 *
 * @author FYF
 * @since 2023/4/20 15:43
 */
public class CompareExcelDataAndWrite {
	
	
	public static void main(String[] args) {
		
		String excelFilePath1 = "D:\\Desktop\\st\\excel\\副本小二班 早期阅读书目统计表.xlsx";
		String excelFilePath2 = "";
		
		List<Object> imageWriteData = LocalExcelUtil.readExcel(excelFilePath1, new ExcelCommonData());
	}
	
	
	@Test
	public void test(){
		String excelFilePath1 = "D:\\Desktop\\st\\excel\\副本小二班 早期阅读书目统计表.xlsx";
		String excelFilePath2 = "D:\\Desktop\\st\\excel\\书目.xls";
		String writeExcelFilePath = "D:\\Desktop\\st\\excel\\excel.xls";
		String writeExcelFilePath2 = "D:\\Desktop\\st\\excel\\excel2.xls";
		
		
		List<ExcelCommonData> imageWriteData = LocalExcelUtil.readExcel(excelFilePath1, new ExcelCommonData());
		
		List<ExcelCommonData> imageWriteData2 = LocalExcelUtil.readExcel(excelFilePath2, new ExcelCommonData());
		
		// 第一列为书名
		Map<String, Boolean> hashMap = new HashMap<>();
		// 第二列为书名
		Map<String, Boolean> hashMap2 = new HashMap<>();
		for (ExcelCommonData element : imageWriteData) {
			System.out.println("JSONObject.toJSONString(element) = " + JSONObject.toJSONString(element));
			hashMap.put(element.getCol0(), false);
		}
		for (ExcelCommonData element : imageWriteData2) {
			System.out.println("JSONObject.toJSONString(element) = " + JSONObject.toJSONString(element));
			hashMap2.put(element.getCol1(), false);
		}
		
		// excel1 判断 excel2 书名项目比对， excel1 不包含 excel2 则标黄 excel1 的数据需要去除《》
		for (ExcelCommonData excelCommonData: imageWriteData) {
			if (hashMap2.containsKey(excelCommonData.getCol0().replaceAll("[《》]", ""))) {
				excelCommonData.setCol9("是");
			}
			System.out.println("JSONObject.toJSONString(excelCommonData) = " + JSONObject.toJSONString(excelCommonData));
		}
		
		// excel2 中的书名在 excel1 中有则标黄
		for (ExcelCommonData excelCommonData: imageWriteData2) {
			if (hashMap.containsKey("《".concat(excelCommonData.getCol1()).concat("》"))) {
				excelCommonData.setCol9("是");
			}
			System.out.println("JSONObject.toJSONString(excelCommonData) = " + JSONObject.toJSONString(excelCommonData));
		}
		
	
		WriteCellStyle headWriteCellStyle = new WriteCellStyle();
		headWriteCellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());

		// 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
		// 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
		
		
		EasyExcel.write(writeExcelFilePath, ExcelCommonData.class)
				.registerWriteHandler(new CustomRowWriteHandler())
				.sheet("模板")
				.doWrite(imageWriteData);
		EasyExcel.write(writeExcelFilePath2, ExcelCommonData.class)
				.registerWriteHandler(new CustomRowWriteHandler())
				.sheet("模板")
				.doWrite(imageWriteData2);
		
	}
	
}