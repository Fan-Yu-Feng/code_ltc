package com.fyf.excel.handle;

import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
import com.alibaba.excel.write.handler.context.RowWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

/**
 * @author FYF
 * @since 2023/4/20 19:09
 */
public class CustomRowWriteHandler extends AbstractRowWriteHandler {
	
	@Override
	public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer rowIndex,
	                            Integer relativeRowIndex, Boolean isHead) {
		// System.out.println("当前行: " + rowIndex);
		// short height = 600;
		// row.setHeight(height);
	}
	
	@Override
	public void afterRowDispose(RowWriteHandlerContext context) {
		Cell cell = context.getRow().getCell(9);
		int rowIndex = cell.getRowIndex();
		int cellIndex = cell.getColumnIndex();
		
		System.out.println("当前行: " + rowIndex);
		System.out.println("当前cellIndex: " + cellIndex + "cellValue"+ cell.getStringCellValue());
		
		
		
		// 自定义宽度处理
		
		// 自定义样式处理
		// 当前事件会在 数据设置到poi的cell里面才会回调
		// 判断不是头的情况 如果是fill 的情况 这里会==null 所以用not true
		if ( context.getHead()==null || !context.getHead()) {
			if (cell.getStringCellValue().contains("是")) {
				// 拿到poi的workbook
				Workbook workbook = context.getWriteWorkbookHolder().getWorkbook();
				// 这里千万记住 想办法能复用的地方把他缓存起来 一个表格最多创建6W个样式
				// 不同单元格尽量传同一个 cellStyle
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
				// 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(cellStyle);
				for (int i = 0; i < 9; i++) {
					context.getRow().getCell(i).setCellStyle(cellStyle);
				}
				// 由于这里没有指定dataformat 最后展示的数据 格式可能会不太正确
				// 这里要把 WriteCellData的样式清空， 不然后面还有一个拦截器 FillStyleCellWriteHandler 默认会将 WriteCellStyle 设置到
				// cell里面去 会导致自己设置的不一样（很关键）
			}
		}
	}
	
/*	@Override
	public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
	                            Integer relativeRowIndex, Boolean isHead) {
		System.out.println("row.getCell(9).getStringCellValue().equals(\"是\") = " + row.getCell(9).getStringCellValue().equals("是"));
		if(row.getCell(9).getStringCellValue().equals("是")){
			CellStyle cellStyle = row.getRowStyle();
			
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
			// 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
		}
	}
	*/
	
}