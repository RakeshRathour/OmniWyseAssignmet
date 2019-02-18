package com.omniwyse.task.ReadExcelFormat;

public class LogInLogOut {

	private String dates;
	private String employeeId;
	private String outTime;
	private String inTime;

	
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	@Override
	public String toString() {
		return "LogInLogOut [dates=" + dates + ", employeeId=" + employeeId + ", outTime=" + outTime + ", inTime="
				+ inTime + "]";
	}

	

}
