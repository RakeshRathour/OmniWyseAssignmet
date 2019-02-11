package com.omniwyse.task.ReadExcelFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ReadingExcelFormat {

	private static final String attendenceFile = "C:\\Users\\user\\Desktop\\Attendance.xls";

	public static  void main(String[] args) throws IOException {
		// reading file from folder
		FileInputStream fis = new FileInputStream(new File(attendenceFile));
		// return first sheet from workbook sheet
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		workbook.close();

		// geting first work sheet
		HSSFSheet sheet = workbook.getSheetAt(0);

		// iterate through each row using FormululaEvaluator
		FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

		// get each row
		for (Row row : sheet) {
			for (Cell cell : row) {
				
				switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

				// if cell type is String
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + "\t");
					break;
				// if cell type is Numeric
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t");
					break;
				}
			}
			System.out.println("");
		}

	}
}
