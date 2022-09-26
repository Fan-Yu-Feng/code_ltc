package com.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/9/22
 */
@Slf4j
public class LocalExcelUtil {
	
	public static void main(String[] args) {
		ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\businessdata\\中智信-捷信消金-蓝海银行无订单表有还款计划表.xlsx"));
		List<Map<String, Object>> listMap = reader.readAll();
		StringBuilder sb = new StringBuilder("delete from t_repay_plan_detail where project_no = 'zzx-jxxj-lhyh'" +
				                                     "and order in ( ");
		for (Map<String, Object> excelMap:
		     listMap) {
			
			String repayDetailId = excelMap.get("有还款计划,无订单").toString();
			sb.append("'").append(repayDetailId).append("',");
		}
		sb.append(");");
		log.info(sb.toString());
	}
	
}