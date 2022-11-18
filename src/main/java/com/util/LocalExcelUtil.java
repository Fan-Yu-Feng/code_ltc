package com.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author FYF
 * @date 2022/9/22
 */
@Slf4j
public class LocalExcelUtil {
	
	public static void main(String[] args) {
		
		String filePath = "D:\\businessdata\\中智信-捷信消金-蓝海银行无订单表有还款计划表.xlsx";
		String filePath1 = "D:\\工作\\副本恒润-小赢-富民银行项目待删除数据明细.xlsx";
		getExcelRead(filePath1);
		
	}
	
	/**
	 * 大文件数据量的 excel
	 *
	 * @return
	 */
	private static RowHandler createRowHandler() {
		return new RowHandler() {
			
			@Override
			public void handle(int sheetIndex, long rowIndex, List<Object> rowlist) {
				
				String filePath = "D:\\工作\\t_order_info.txt";
				
				String str = "delete from t_order_info where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
				switch(sheetIndex){
					case 0:
						filePath = "D:\\工作\\t_order_info-%s.txt";
						str = "delete from t_order_info where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 1:
						filePath = "D:\\工作\\t_repay_plan_detail-%s.txt";
						str = "delete from t_repay_plan_detail where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 2:
						filePath = "D:\\工作\\t_repay_record-%s.txt";
						str = "delete from t_repay_record where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 3:
						filePath = "D:\\工作\\t_compensate_record-%s.txt";
						str = "delete from t_compensate_record where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					default:
						break;
				}
				log.info("handle :[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
				
				int mod = (int) (rowIndex / 10000);
				
				filePath = String.format(filePath,mod);
				String orderNo = rowlist.get(0).toString();
				String sql = String.format(str,  orderNo);
				try {
					FileUtils.writeStringToFile(new File(filePath), sql, true);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
			@Override
			public void handleCell(int sheetIndex, long rowIndex, int cellIndex, Object value, CellStyle xssfCellStyle) {
				// log.info("handleCell :[{}] [{}] {}, {}", sheetIndex, rowIndex, value,xssfCellStyle);
			}
			
			@Override
			public void doAfterAllAnalysed() {
			
			}
			
			
		};
	}
	/**
	 * 大文件数据量的 excel select
	 *
	 * @return
	 */
	private static RowHandler createRowHandler2() {
		return new RowHandler() {
			
			@Override
			public void handle(int sheetIndex, long rowIndex, List<Object> rowlist) {
				
				String filePath = "D:\\工作\\select-t_order_info.txt";
				
				String str = "select * from t_order_info where  project_no = 'hr-xy-fmyh' and  order_no in ( '1',) '%s' ;\n";
				switch(sheetIndex){
					case 0:
						filePath = "D:\\工作\\select-t_order_info.txt";
						str = "select * from t_order_info where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 1:
						filePath = "D:\\工作\\select-t_repay_plan_detail.txt";
						str = "select * from t_repay_plan_detail where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 2:
						filePath = "D:\\工作\\select-t_repay_record.txt";
						str = "select * from t_repay_record where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					case 3:
						filePath = "D:\\工作\\select-t_compensate_record.txt";
						str = "select * from t_compensate_record where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
						break;
					default:
						break;
				}
				log.info("handle :[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
				
				String orderNo = rowlist.get(0).toString();
				String sql = "'".concat(orderNo).concat("',\n");
				try {
					FileUtils.writeStringToFile(new File(filePath), sql, true);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
			@Override
			public void handleCell(int sheetIndex, long rowIndex, int cellIndex, Object value, CellStyle xssfCellStyle) {
				// log.info("handleCell :[{}] [{}] {}, {}", sheetIndex, rowIndex, value,xssfCellStyle);
			}
			
			@Override
			public void doAfterAllAnalysed() {
			
			}
			
			
		};
	}
	
	
	public static void getExcelRead(String filePath) {
		for(int i = 2; i <= 3 ; ++i) {
			ExcelUtil.readBySax(filePath, i, createRowHandler2());
		}
	}
	
	
	public static void generateSql(String excelPath){
		
		ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\工作\\副本恒润-小赢-富民银行项目待删除数据明细.xlsx"));
		
		// ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\businessdata\\中智信-捷信消金-蓝海银行无订单表有还款计划表.xlsx"));
		
		List<String> sheetNameList = reader.getSheetNames();
		
		String str = "delete from %s where order_no = '%s' and project_no = 'hr-xy-fmyh';\n";
		String sourcePath = "D:\\工作";
		
		// ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		CountDownLatch countDownLatch = new CountDownLatch(sheetNameList.size());
		for (String sheetName :
				sheetNameList) {
			
			// executorService.execute(() -> {
			try {
				ExcelReader sheetReader = ExcelUtil.getReader(FileUtil.file("D:\\工作\\副本恒润-小赢-富民银行项目待删除数据明细.xlsx"), sheetName);
				List<Map<String, Object>> sheetListMap = sheetReader.readAll();
				String filePath = sourcePath.concat(File.separator).concat(sheetName).concat(".txt");
				log.info("start read sheet :{}", sheetName);
				for (Map<String, Object> excelMap :
						sheetListMap) {
					String orderNo = excelMap.get("order_no").toString();
					String sql = String.format(str, sheetName, orderNo);
					try {
						FileUtils.writeStringToFile(new File(filePath), sql, true);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
				log.info(" read sheet end :{}", sheetName);
				log.info(" generate file path  :{}", filePath);
			} catch (Exception e) {
				log.error(e.getMessage());
			} finally {
				countDownLatch.countDown();
			}
			// });
			log.info("finish job");
			try {
				countDownLatch.await();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
	}
	
	
}