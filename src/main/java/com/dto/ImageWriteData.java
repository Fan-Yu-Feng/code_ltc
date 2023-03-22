package com.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author FYF
 * @since 2023/3/21 12:55
 */
@Data
@EqualsAndHashCode

@ColumnWidth(10)
@ContentRowHeight(100)
@HeadRowHeight(20)
public class ImageWriteData {
	@ExcelProperty(value = "序号", index = 0)
	@ColumnWidth(10)
	private String order;
	@ExcelProperty(value = "类别", index = 1)
	@ColumnWidth(20)
	private String type;
	@ExcelProperty(value = "资产名称", index = 2)
	@ColumnWidth(20)
	private String name;
	@ExcelProperty(value = "数量", index = 3)
	@ColumnWidth(10)
	private String number;
	@ExcelProperty(value = "编号", index = 4)
	@ColumnWidth(25)
	private String typeInfo;
	
	/**
	 * 根据文件导出 并设置导出的位置。
	 *
	 * @since 3.0.0-beta1
	 */
	
	@ColumnWidth(30)
	@ExcelProperty(value = "图片", index = 5)
	private WriteCellData<Void> writeCellDataFile;
	
	@ExcelProperty(value = "备注", index = 6)
	@ColumnWidth(10)
	private String remark;
}