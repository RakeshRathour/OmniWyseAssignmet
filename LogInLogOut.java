package com.omniwyse.task.ReadingExcelFileStoreSeparateTable;

import java.util.Date;

public class LogInLogOut {
	private Date dates;
	private String employeeId;
	private String employeeName;
	private Date inTime;
	private Date outTime;

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date finalInTimeDate) {
		this.inTime = finalInTimeDate;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	@Override
	public String toString() {
		return "LogInLogOut [dates=" + dates + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", inTime=" + inTime + ", outTime=" + outTime + "]";
	}

	

}
