package com.fyf.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * @author FYF
 * @version 1.0
 * @date 2022/10/11 18:17
 */
public class DemoData {
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
	
	
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * 忽略这个字段
	 */
	@ExcelIgnore
	private String ignore;
	
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public String getSecondMenu() {
		return secondMenu;
	}
	
	public void setSecondMenu(String secondMenu) {
		this.secondMenu = secondMenu;
	}
	
	public String getThirdMenu() {
		return thirdMenu;
	}
	
	public void setThirdMenu(String thirdMenu) {
		this.thirdMenu = thirdMenu;
	}
	
	public String getOperateResource() {
		return operateResource;
	}
	
	public void setOperateResource(String operateResource) {
		this.operateResource = operateResource;
	}
	
	public String getIgnore() {
		return ignore;
	}
	
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
}