package com.omniwyse.task.ReadExcelFormat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadSpecificData {
	private final static String attendence = "C:\\Users\\user\\Desktop\\Attendance.xls";

	public static void main(String[] args) throws IOException {
		try {

			// accessing file
			FileInputStream fileInput = new FileInputStream(attendence);
			// creating workbook object
			HSSFWorkbook wb = new HSSFWorkbook(fileInput);
			// creating work sheet object
			HSSFSheet sheet = wb.getSheetAt(0);
			// creating object for row/records iteration
			Iterator<Row> row = sheet.iterator();
			while (row.hasNext()) {
				Row rows = row.next();
				// creating object for cell/column object
				Iterator<Cell> cell = rows.cellIterator();
				while (cell.hasNext()) {
					Cell cells = cell.next();
					if (cells.getCellType() == Cell.CELL_TYPE_STRING
							|| (cells.getCellType() == Cell.CELL_TYPE_NUMERIC)) {
						// Filtering Required Data based on Days, Employee Code,
						// Shift, InTime and Out
						// Time
						if ((rows.getCell(2) != null) && cells.getStringCellValue().equalsIgnoreCase("Days")
								|| cells.getStringCellValue().equalsIgnoreCase("Employee Code:-")
								|| cells.getStringCellValue().equalsIgnoreCase("Shift")
								|| cells.getStringCellValue().equalsIgnoreCase("In Time")
								|| cells.getStringCellValue().equalsIgnoreCase("Out Time")) {
							// Creating New Cell Iterator Object for Printing
							// Data
							Iterator<Cell> selectedRowCells = rows.cellIterator();
							// Printing Row Data
							while (selectedRowCells.hasNext()) {
								Cell selectedCell = selectedRowCells.next();

								if (selectedCell.getCellType() == Cell.CELL_TYPE_STRING) {
									String str = selectedCell.getStringCellValue();
									System.out.print(String.format("%1$-15s", str));

								}
								if ((selectedCell.getCellType() == Cell.CELL_TYPE_NUMERIC)) {
									Double value = selectedCell.getNumericCellValue();
									// formating Double to String
									String Str = "" + value;
									System.out.print(String.format("%1$-15s", Str));

								}

							}
							System.out.println();
							// for Printing Name Of Days
							if ((rows.getCell(2) != null) && cells.getStringCellValue().equalsIgnoreCase("Days")) {
								Row rowOfDaysName = row.next();
								Iterator<Cell> cellOfDaysName = rowOfDaysName.cellIterator();
								while (cellOfDaysName.hasNext()) {
									Cell selectedCell = cellOfDaysName.next();
									int cellNum = selectedCell.getColumnIndex();
									if (cellNum == 2) {
										String s = "";
										System.out.print(String.format("%1$-15s", s));
									} else {
										if (selectedCell.getCellType() == Cell.CELL_TYPE_STRING) {
											String s = selectedCell.getStringCellValue();
											System.out.print(String.format("%1$-15s", s));
										}
									}
								}
								System.out.println();
								System.out.println();

							}

						}

					}
					if (cells.getStringCellValue().equalsIgnoreCase("Out Time")) {
						System.out.println();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
