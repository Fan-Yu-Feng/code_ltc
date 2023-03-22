package com.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author FYF
 * @since 2023/3/21 12:55
 */
@Data
@EqualsAndHashCode
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
public class ImageWriteData {
	@ExcelProperty(value = "序号", index = 0)
	@ColumnWidth(value = 30)
	private String order;
	@ExcelProperty(value = "类别", index = 1)
	@ColumnWidth(value = 30)
	private String type;
	@ExcelProperty(value = "资产名称", index = 2)
	@ColumnWidth(value = 30)
	private String name;
	@ExcelProperty(value = "数量", index = 3)
	@ColumnWidth(value = 30)
	private String number;
	@ExcelProperty(value = "编号", index = 4)
	@ColumnWidth(value = 30)
	private String typeInfo;
	/**
	 * 如果string类型 必须指定转换器，string默认转换成string
	 */
	@ExcelProperty(value = "图片", index = 5)
	private String string;
	
	/**
	 * 根据文件导出 并设置导出的位置。
	 *
	 * @since 3.0.0-beta1
	 */
	private WriteCellData<Void> writeCellDataFile;
	
}