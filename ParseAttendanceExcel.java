package com.omniwyse.task.ReadingExcelFileStoreSeparateTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 
 * @author Rakesh Singh
 * 
 *         this class will parse the data from log in log out file.
 *
 */
public class ParseAttendanceExcel {
	private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\Attendance.xls";

	private static final String EMPLOYEE_CODE = "Employee Code:-";
	private static final String OUT_TIME = "Out Time";
	private static final String IN_TIME = "In Time";
	private static final String DAYS = "Days";

	private static List<LogInLogOut> inTimeEmployeeList;
	private static List<LogInLogOut> outTimeEmployeeList;
	private static List<LogInLogOut> finalEmployeeList;

	private static List<Date> listDate;

	public static List<LogInLogOut> processExcelFileForAttendance(String FILE_PATH) {
		FileInputStream fis = null;
		String empCode = "";
		String empName = "";
		Workbook workbook = null;
		finalEmployeeList = new ArrayList<LogInLogOut>();
		try {
			fis = new FileInputStream(FILE_PATH);
			workbook = new HSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.iterator();
			while (rows.hasNext()) {
				boolean employee_change = true;
				Row row = rows.next();
				String rowTypeValue = getRowType(row);
				switch (rowTypeValue) {
				case DAYS:
					listDate = parseDate(row);

					break;
				case EMPLOYEE_CODE:
					if (employee_change == true) {
						empCode = parseEmployeeRow(row);
						empName = parseEmployeeRowForName(row);
					}
					employee_change = false;
					break;

				case IN_TIME:
					inTimeEmployeeList = parseInTimeForOneEmployee(row, listDate, empCode, empName);
					break;
				case OUT_TIME:
					outTimeEmployeeList = parseOutTimeForOneEmployee(row, inTimeEmployeeList);
					finalEmployeeList.addAll(outTimeEmployeeList);
					employee_change = true;
					break;
				default:
					break;
				}
			}
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (workbook != null) {
				try {
					workbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return finalEmployeeList;
	}

	public static List<LogInLogOut> parseInTimeForOneEmployee(Row row, List<Date> listDate2, String code, String name)
			throws java.text.ParseException {
		Iterator<Cell> cells = row.cellIterator();
		int index = 0;
		inTimeEmployeeList = new ArrayList<LogInLogOut>();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getColumnIndex() >= 3 && cell.getColumnIndex() <= 10 && cell.getColumnIndex() != 8) {
				Date currentDate = listDate2.get(index);
				LogInLogOut temp = new LogInLogOut();
				temp.setDates(currentDate);
				temp.setEmployeeId(code);
				temp.setEmployeeName(name);

				String stringDate = cell.getStringCellValue();

				Date inTme = getInTimeFromInput(stringDate);

				Long sum = currentDate.getTime() + inTme.getTime();
				Date inDate = new Date(sum);
				temp.setInTime(inDate);
				inTimeEmployeeList.add(temp);
				index++;
				if (index == listDate2.size()) {
					break;
				}
			}
		}
		return inTimeEmployeeList;
	}

	public static List<LogInLogOut> parseOutTimeForOneEmployee(Row row, List<LogInLogOut> intimelist)
			throws java.text.ParseException {
		List<LogInLogOut> outTimeList = new ArrayList<LogInLogOut>();
		Iterator<Cell> cells = row.cellIterator();
		int index = 0;
		while (cells.hasNext()) {
			Cell cell = cells.next();

			if (cell.getColumnIndex() >= 3 && cell.getColumnIndex() <= 10 && cell.getColumnIndex() != 8) {
				LogInLogOut outTemp = intimelist.get(index);

				String tempOutDate = cell.getStringCellValue();
				Date outTempDate = getInTimeFromInput(tempOutDate);
				Date currentDate = outTemp.getDates();
				long sum = outTempDate.getTime() + currentDate.getTime();
				Date outDate = new Date(sum);
				outTemp.setOutTime(outDate);
				outTimeList.add(outTemp);
				index++;
				if (index == intimelist.size()) {
					break;
				}
			}
		}
		return outTimeList;
	}

	public static String getRowType(Row row) {
		String rowType = "";
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getStringCellValue().equalsIgnoreCase(DAYS)) {
				rowType = cell.getStringCellValue();
			} else if (cell.getStringCellValue().equalsIgnoreCase(EMPLOYEE_CODE)) {
				rowType = cell.getStringCellValue();
			} else if (cell.getStringCellValue().equalsIgnoreCase(IN_TIME)) {
				rowType = cell.getStringCellValue();
			} else if (cell.getStringCellValue().equalsIgnoreCase(OUT_TIME)) {
				rowType = cell.getStringCellValue();
			} else {
				continue;
			}
		}
		return rowType;
	}

	public static List<Date> parseDate(Row row) throws ParseException, java.text.ParseException {
		List<Date> dateList = null;

		String rowType = getRowType(row);
		if (rowType.equalsIgnoreCase(DAYS)) {
			dateList = new ArrayList<>();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();

				if (cell.getColumnIndex() >= 3 && cell.getColumnIndex() <= 10 && cell.getColumnIndex() != 8) {
					String dateString = cell.getStringCellValue();
					dateString = dateString + "-2019";
					DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
					Date attendanceDate = df.parse(dateString);
					dateList.add(attendanceDate);
				}
			}
		}
		return dateList;
	}

	private static String parseEmployeeRow(Row row) {
		String employeecode = "";
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getColumnIndex() == 10) {
				employeecode = cell.getStringCellValue();
			}
		}
		return employeecode;
	}

	private static String parseEmployeeRowForName(Row row) {
		String employeeName = "";
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getColumnIndex() == 24) {
				employeeName = cell.getStringCellValue();
			}
		}
		return employeeName;
	}

	private static Date getInTimeFromInput(String tempInDate) {
		String token[] = tempInDate.split("\\(");
		if (token == null || token.length == 0) {
		} else {

			tempInDate = token[0];
		}
		DateFormat df = new SimpleDateFormat("HH:mm");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date inTmeDate = null;
		try {
			inTmeDate = df.parse(tempInDate);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			inTmeDate = new Date();
		}
		return inTmeDate;
	}

}
