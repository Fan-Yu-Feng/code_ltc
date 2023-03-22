package com.fyf.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @author FYF
 * @since 2023/3/21 12:55
 */
@Data
@EqualsAndHashCode
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
public class ImageDemoData {
	private File file;
	private InputStream inputStream;
	/**
	 * 如果string类型 必须指定转换器，string默认转换成string
	 */
	@ExcelProperty(converter = StringImageConverter.class)
	private String string;
	private byte[] byteArray;
	/**
	 * 根据url导出
	 *
	 * @since 2.1.1
	 */
	private URL url;
	
	@ExcelIgnore
	@ExcelProperty(value = "序号", index = 0)
	private String order = "0";
	
	@ExcelProperty(value = "系统名称", index = 1)
	@ColumnWidth(value = 30)
	private String systemName;
	
	@ColumnWidth(value = 30)
	@ExcelProperty(value = "二级菜单", index = 2)
	private String secondMenu;
	
	@ColumnWidth(value = 30)
	@ExcelProperty(value = "三级菜单", index = 3)
	private String thirdMenu;
	
	@ColumnWidth(value = 30)
	@ExcelProperty(value = "操作资源", index = 4)
	private String operateResource;
	
	
	
	/**
	 * 根据文件导出 并设置导出的位置。
	 *
	 * @since 3.0.0-beta1
	 */
	private WriteCellData<Void> writeCellDataFile;
	
}