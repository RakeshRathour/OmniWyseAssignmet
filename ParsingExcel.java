package com.omniwyse.task.ReadExcelFormat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * 
 * @author Rakesh 
 * this class is parsing the employee attendance sheet
 *
 */

public class ParsingExcel {
	private static final String filename = "C:\\Users\\user\\Desktop\\Attendance.xls";
	FileInputStream fis;
	HSSFWorkbook wb;
	HSSFSheet sheet;

	ArrayList<String> dates = new ArrayList<String>();
	HashMap<String, String> employee = new HashMap<String, String>();
	List<LogInLogOut> logList = new ArrayList<LogInLogOut>();

	public ParsingExcel() throws IOException {
		fis = new FileInputStream(filename);
		wb = new HSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

	}

	int index1 = 0;
	int empIdIndex = 1;

	public String readCell(int i, int j) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		if (cell != null && cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell != null && cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return "" + cell.getNumericCellValue();
		} else {
			return "";
		}
	}

	public static void main(String[] args) throws IOException {

		try {

			ParsingExcel parseObj = new ParsingExcel();
			int lastRow = parseObj.sheet.getLastRowNum();
			// for storing all dates
			for (int i = 0; i < lastRow; i++) {
				Row row = parseObj.sheet.getRow(i);
				int lastCell = row.getLastCellNum();

				String result = parseObj.readCell(i, 1);
				if (result.equals("Days") || result.equals("Employee Code:-") || result.equals("In Time")
						|| result.equals("Employee Name:-")) {

					if (result.equals("Days")) {
						for (int cellIndex = 3; cellIndex <= lastCell; cellIndex++) {
							String dateList = parseObj.readCell(i, cellIndex);
							if (!("").equals(dateList)) {
								parseObj.dates.add(dateList);
							}
						}
					}
					if (result.equals("Employee Code:-")) {
						String eId = parseObj.readCell(i, 10);
						String eName = parseObj.readCell(i, 24);
						if (!eId.equals("") && !eName.equals("")) {
							parseObj.employee.put(eId, eName);
						}
					}
					if (("In Time").equals(result)) {
						for (int cellIndex = 3; cellIndex <= lastCell; cellIndex++) {
							String inTime = parseObj.readCell(i, cellIndex);
							String outTime = parseObj.readCell(i + 1, cellIndex);
							if (!inTime.equals("") && !outTime.equals("")) {
								LogInLogOut logInLogOut = new LogInLogOut();
								logInLogOut.setDates(parseObj.dates.get(parseObj.index1));
								logInLogOut.setEmployeeId("" + parseObj.empIdIndex);
								logInLogOut.setInTime(inTime);
								logInLogOut.setOutTime(outTime);
								parseObj.logList.add(logInLogOut);
								parseObj.index1++;

							}

						}
						parseObj.index1 = 0;
						parseObj.empIdIndex++;
					}

				}
			}
			//obj.displayEmployeeDetailsById();
			//obj.displayEmployeesDetailsByDate();
			
			//String empDetail=obj.Get_An_EmpDetail_by_Date("5", "07-feb");
			//System.out.println("Date   Emp Code    Name  	In Time  Out Time");
			//System.out.println(empdetail);
			//System.out.println("Employee Name : " + obj.Get_empName_by_EmpCode("4"));

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	// get employee name by employee code
	public String Get_empName_by_EmpCode(String eId) throws IOException {

		if (employee.get(eId) != null) {
			return employee.get(eId);
		} else
			return "";
	}

	// get particular employee details by eId and Date
	public String Get_An_EmpDetail_by_Date(String eId, String date) throws IOException {
		String singleRecord = "";
		for (LogInLogOut list : logList) {
			if (list.getDates().equalsIgnoreCase(date) && (list.getEmployeeId().equalsIgnoreCase(eId))) {

				singleRecord = list.getDates() + " " + list.getEmployeeId() + " " + employee.get(list.getEmployeeId()) + " " + list.getInTime()
						+ " " + list.getOutTime();

			}
		}
		return singleRecord;
	}

	// getting particular employee details
	public void displayEmployeeDetailsById() {

		System.out.println("---------------------------------------------------------Start-----------------------------------------------");
		System.out.println();
		System.out.print("\tEnter The Employee Code : ");
		String eId = new Scanner(System.in).next();
		System.out.println();
		System.out
				.println("-----------------------------------------------------EmpLoyee Details------------------------------------------");
		System.out.println();
		System.out.print("\tEmployee ID : " + eId + "\tName : " + employee.get(eId));
		System.out.println();
		System.out.println();
		System.out.println("\t" + String.format("%1$-15s", "Date") + "\t" + String.format("%1$-15s", "In  Time") + "\t"
				+ String.format("%1$-15s", "Out Time"));
		System.out.println();
		for (LogInLogOut list : logList) {
			if (list.getEmployeeId().equalsIgnoreCase(eId)) {

				System.out.println("\t" + String.format("%1$-15s", list.getDates()) + "\t"
						+ String.format("%1$-15s", list.getInTime()) + "\t" + String.format("%1$-15s", list.getOutTime()));
				System.out.println();
			}
		}
		System.out.println("-----------------------------------------------------------------End-----------------------------------------");
		System.out.println();
	}

	// getting all employee details
	public void displayEmployeesDetailsByDate() {

		System.out.println("---------------------------------------------------------------Start-----------------------------------------");
		System.out.println();
		System.out.print("\tEnter Date : ");
		String date = new Scanner(System.in).next();
		System.out.println();
		System.out.println("-------------------------------------------------------EmpLoyee Details--------------------------------------");
		System.out.println("\n");

		System.out.println("\t" + String.format("%1$-15s", "Date") + "\t" + String.format("%1$-15s", "Emp Code") + "\t"
				+ String.format("%1$-30s", "Emp Name") + "\t" + String.format("%1$-15s", "In  Time") + "\t"
				+ String.format("%1$-15s", "Out Time"));
		System.out.println("\n");
		for (LogInLogOut list : logList) {
			if (list.getDates().equalsIgnoreCase(date)) {

				System.out.println("\t" + String.format("%1$-15s", list.getDates()) + "\t"
						+ String.format("%1$-15s", list.getEmployeeId()) + "\t"
						+ String.format("%1$-30s", employee.get(list.getEmployeeId())) + "\t"
						+ String.format("%1$-15s", list.getInTime()) + "\t" + String.format("%1$-15s", list.getOutTime()));
				System.out.println();
			}
		}
		System.out.println("-----------------------------------------------------------------End-----------------------------------------");
		System.out.println();
	}

}
