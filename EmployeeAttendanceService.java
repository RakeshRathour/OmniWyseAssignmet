
package com.omniwyse.task.ReadingExcelFileStoreSeparateTable;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Rakesh Singh this class will persist all the employee attendance to
 *         the mysql database;
 */

public class EmployeeAttendanceService {

	private static final String EMPLOYEE_INSERT_QUERY = "insert into employee_details values(?,?)";
	private static final String ATTENDANCE_INSERT_QUERY = "insert into attendance_details values(?,?,?,?)";

	private static PreparedStatement empPreparedStatement, attetndancePreparedStatement;

	public void processAndSaveAttendanceFromExcel(String file) {
		try {
			List<LogInLogOut> employeeList = procesAttendance(file);
			saveAttendance(employeeList);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Connection getDatabaseConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties props = new Properties();
			String url = props.getProperty("url");
			String username = props.getProperty("userName");
			String password = props.getProperty("passWord");
			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
		} catch (SQLException | ClassNotFoundException cnfe) {
			cnfe.printStackTrace();

		}
		return con;
	}

	public void saveAttendance(List<LogInLogOut> employeeList) {
		Connection con;
		try {
			con = getDatabaseConnection();
			attetndancePreparedStatement = con.prepareStatement(ATTENDANCE_INSERT_QUERY);
			empPreparedStatement = con.prepareStatement(EMPLOYEE_INSERT_QUERY);
			saveEmployeeDetails(employeeList, empPreparedStatement);
			saveAttendanceDetails(employeeList, attetndancePreparedStatement);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<LogInLogOut> procesAttendance(String filepath) {
		List<LogInLogOut> employeeList = ParseAttendanceExcel.processExcelFileForAttendance(filepath);
		return employeeList;
	}

	private static void saveAttendanceDetails(List<LogInLogOut> attendanceList,
			PreparedStatement attendancePreparedStatement) {
		Iterator<LogInLogOut> logInLogOutIterator = attendanceList.iterator();
		try {
			while (logInLogOutIterator.hasNext()) {
				LogInLogOut logInLogOut = logInLogOutIterator.next();
				java.sql.Date attendanceSqlDate = new Date(logInLogOut.getDates().getTime());
				attendancePreparedStatement.setDate(1, attendanceSqlDate);
				java.sql.Timestamp inTimeSqlDate = new Timestamp(logInLogOut.getInTime().getTime());
				attendancePreparedStatement.setTimestamp(2, inTimeSqlDate);
				java.sql.Timestamp outTimeSqlDate = new Timestamp(logInLogOut.getOutTime().getTime());
				attendancePreparedStatement.setTimestamp(3, outTimeSqlDate);
				attendancePreparedStatement.setString(4, logInLogOut.getEmployeeId());
				attendancePreparedStatement.addBatch();
			}
			attendancePreparedStatement.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void saveEmployeeDetails(List<LogInLogOut> employeeList, PreparedStatement empPreparedStatement) {
		Map<String, LogInLogOut> employeeMap = new HashMap<String, LogInLogOut>();
		for (LogInLogOut logInLogOut : employeeList) {
			if (!employeeMap.containsKey(logInLogOut.getEmployeeId())) {
				employeeMap.put(logInLogOut.getEmployeeId(), logInLogOut);
			}

		}
		try {
			for (String key : employeeMap.keySet()) {
				LogInLogOut loginLogout = employeeMap.get(key);
				empPreparedStatement.setString(1, loginLogout.getEmployeeId());
				empPreparedStatement.setString(2, loginLogout.getEmployeeName());
				empPreparedStatement.addBatch();
			}
			empPreparedStatement.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
