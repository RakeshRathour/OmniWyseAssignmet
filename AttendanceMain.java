package com.omniwyse.task.ReadingExcelFileStoreSeparateTable;

import java.util.List;

public class AttendanceMain {
	private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\Attendance.xls";

	public static void main(String[] args) {
		List<LogInLogOut> gh = ParseAttendanceExcel.processExcelFileForAttendance(FILE_PATH);
		for (LogInLogOut listInfo : gh) {
			System.out.println(listInfo);
		}
		EmployeeAttendanceService pd = new EmployeeAttendanceService();
		List<LogInLogOut> sg = pd.procesAttendance(FILE_PATH);
		for(LogInLogOut l:sg){
			System.out.println(l);
		}

	}
}
