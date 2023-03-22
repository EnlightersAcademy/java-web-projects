package com.shipwell.dto;

public class Employee {
	
	private int employeeId;
	
	private int logisticPartnerId;
	
	private String name;
	
	private String emailId;
	
	private String phoneNo;
	
	private String password;
	
	private int status;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLogisticPartnerId() {
		return logisticPartnerId;
	}

	public void setLogisticPartnerId(int logisticPartnerId) {
		this.logisticPartnerId = logisticPartnerId;
	}


}
