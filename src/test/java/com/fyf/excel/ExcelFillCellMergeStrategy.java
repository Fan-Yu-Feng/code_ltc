package com.fyf.excel;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Arrays;
import java.util.List;

/**
 * @author FYF
 * @version 1.0
 * @date 2022/10/11 18:44
 */
public class ExcelFillCellMergeStrategy implements CellWriteHandler {
	
	/**
	 * 需要从第几行开始合并，0表示第1行
	 */
	private final static int mergeRowIndex = 0;
	/**
	 * 合并的哪些列，比如为4时，当前行id和上一行id相同则合并前五列
	 */
	private final static List<Integer> mergeColumnIndex = Arrays.asList(1, 2, 3);
	
	public ExcelFillCellMergeStrategy() {
	}
	
	@Override
	public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {
	
	}
	
	@Override
	public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {
		// 隐藏id列
		writeSheetHolder.getSheet().setColumnHidden(0, true);
	}
	

	
	@Override
	public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
		//当前行
		int curRowIndex = cell.getRowIndex();
		//当前列
		int curColIndex = cell.getColumnIndex();
		
		// 大于需要合并的列
		if (curRowIndex > mergeRowIndex) {
			
			if(mergeColumnIndex.contains(curColIndex)){
				mergeWithPrevRow(writeSheetHolder, cell, curRowIndex, curColIndex);
			}
		}
	}
	
	/**
	 * 当前单元格向上合并：当前行的id和上一行的id相同则合并前面（mergeColumnRegion+1）列
	 *
	 * @param writeSheetHolder writeSheetHolder
	 * @param cell             当前单元格
	 * @param curRowIndex      当前行
	 * @param curColIndex      当前列
	 */
	private void mergeWithPrevRow(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {

		// 当前行
		Row curRow = cell.getSheet().getRow(curRowIndex);
		// 上一行
		Row preRow = cell.getSheet().getRow(curRowIndex - 1);
		if (preRow == null) {
			// 获取不到上一行的数据时,使用缓存sheet中的数据
			preRow = writeSheetHolder.getCachedSheet().getRow(curRowIndex - 1);
		}
		if(curRow ==null){
			curRow = writeSheetHolder.getCachedSheet().getRow(curRowIndex);
		}
		
		// 上一行当前列的数据
		Cell preRowCell = preRow.getCell(curColIndex);
		
		// 获取当前行的当前列的数据和上一行的当前列列数据，通过上一行数据是否相同进行合并
		Object curData = cell.getCellTypeEnum() == CellType.STRING ? cell.getStringCellValue() :
				                 cell.getNumericCellValue();
		Object preRowCellData = preRowCell.getCellTypeEnum() == CellType.STRING ? preRowCell.getStringCellValue() :
				                        preRowCell.getNumericCellValue();
		Object preColRowCellData = preRowCellData;
		Object curRowPreColCellData = preRowCellData;
		
		// 当时为第一行时不进行获取上一行的数据，会报空指针异常
		if(curColIndex > 1){
			// 上一行前一列的数据
			Cell preColRowCell = preRow.getCell(curColIndex - 1);
			// 当前行前一列的数据
			Cell curRowPreColCell = curRow.getCell(curColIndex -1 );
			preColRowCellData = preColRowCell.getCellTypeEnum() == CellType.STRING ? preColRowCell.getStringCellValue() :
					                           preColRowCell.getNumericCellValue();
			curRowPreColCellData = curRowPreColCell.getCellTypeEnum() == CellType.STRING ? curRowPreColCell.getStringCellValue() :
					                              curRowPreColCell.getNumericCellValue();
		}
		
		// 比较当前列和前一列的值是否与上一行相同，相同合并当前单元格与上一行
		if (curData.equals(preRowCellData) && preColRowCellData.equals(curRowPreColCellData) ) {
			Sheet sheet = writeSheetHolder.getSheet();
			List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
			boolean isMerged = false;
			for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
				CellRangeAddress cellRangeAddr = mergeRegions.get(i);
				// 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
				if (cellRangeAddr.isInRange(curRowIndex - 1, curColIndex)) {
					sheet.removeMergedRegion(i);
					cellRangeAddr.setLastRow(curRowIndex);
					sheet.addMergedRegion(cellRangeAddr);
					isMerged = true;
				}
			}
			// 若上一个单元格未被合并，则新增合并单元
			if (!isMerged) {
				CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex - 1, curRowIndex, curColIndex,
						curColIndex);
				sheet.addMergedRegion(cellRangeAddress);
			}
		}
	}
	
	
}