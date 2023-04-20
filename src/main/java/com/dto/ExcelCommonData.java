package com.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author FYF
 * @since 2023/3/21 12:55
 */
@Data
@EqualsAndHashCode

@ColumnWidth(20)
@ContentRowHeight(20)
@HeadRowHeight(20)
public class ExcelCommonData {
	@ExcelProperty(value = "书名", index = 0)
	@ColumnWidth(40)
	private String col0;
	@ExcelProperty(value = "班级", index = 1)
	@ColumnWidth(20)
	private String col1;
	@ExcelProperty(value = "年龄段", index = 2)
	@ColumnWidth(20)
	private String col2;
	@ExcelProperty(value = "主题/题材", index = 3)
	@ColumnWidth(10)
	private String col3;
	@ExcelProperty(value = "体裁/文体", index = 4)
	@ColumnWidth(25)
	private String col4;
	@ExcelProperty(value = "培养能力", index = 5)
	@ColumnWidth(25)
	private String col5;
	
	@ExcelProperty(value = "形式/材质", index = 6)
	@ColumnWidth(25)
	private String col6;
	@ExcelProperty(value = "数量", index = 7)
	@ColumnWidth(25)
	private String col7;
	
	@ExcelProperty(value = "备注", index = 8)
	@ColumnWidth(25)
	private String col8;
	
	
	@ExcelProperty(value = "是否有书", index = 9)
	@ColumnWidth(25)
	private String col9;
	
}