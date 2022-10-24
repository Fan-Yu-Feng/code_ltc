package com.fyf.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author FYF
 * @version 1.0
 * @date 2022/10/11 18:12
 */

public class exportExcelTest {
	
	
	/**
	 * 根据参数只导出指定列
	 * <p>
	 * 1. 创建excel对应的实体对象 参照{@link DemoData}
	 * <p>
	 * 2. 根据自己或者排除自己需要的列
	 * <p>
	 * 3. 直接写即可
	 *
	 * @since 2.1.1
	 */
	@Test
	public void excludeOrIncludeWrite() {
		
		//UUID生成唯一name
		String name = UUID.randomUUID().toString().replaceAll("-", "") + ".xlsx";
		//实现excel写的操作
		
		//1 设置写入文件夹地址和excel文件名称
		String filename = "D:\\businessdata\\excel\\" + name;
		// 2 调用easyexcel里面的方法实现写操作
		// write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
		EasyExcel.write(filename, DemoData.class)
				.autoCloseStream(true)
				.registerWriteHandler(new ExcelFillCellMergeStrategy())
				.sheet("名字")
				.doWrite(data());
		
	}
	
	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<>();
		
		DemoData data =  getDemoData("解析规则配置");
		list.add(data);
		data =  getDemoData("解析规则配置");
		data.setOperateResource("添加解析规则配置信息");
		list.add(data);
		data =  getDemoData("解析规则配置");
		data.setOperateResource("  更新解析规则配置信息");
		list.add(data);
		data =  getDemoData("解析规则配置");
		data.setOperateResource("  通过Id查询解析规则配置信息");
		list.add(data);
		data =  getDemoData("解析规则配置");
		data.setOperateResource("查询厂商枚举");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setSecondMenu("内部系统调用明细" );
		data.setOperateResource(" 查询内部系统调用明细");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setOperateResource("查询厂商枚举");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setOperateResource("审核状态枚举");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setOperateResource("通过Id查询解析规则配置信息");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setOperateResource("查看文件");
		list.add(data);
		data =  getDemoData("内部系统调用明细");
		data.setOperateResource("查询通用字段枚举");
		list.add(data);
		
		DemoData data2 = new DemoData();
		data2.setSystemName("贷后系统" );
		data2.setSecondMenu("111");
		data2.setThirdMenu("无");
		data2.setOperateResource("查询贷后规则配置信息");
		list.add(data2);
		return list;
	}
	
	private DemoData getDemoData(String msg) {
		DemoData data = new DemoData();
		data.setSystemName("信息识别系统" );
		data.setSecondMenu(msg);
		data.setThirdMenu("无");
		data.setOperateResource("查询解析规则配置信息");
		return data;
	}
	
	
}