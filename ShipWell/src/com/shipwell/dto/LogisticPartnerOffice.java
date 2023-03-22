package com.shipwell.dto;

/**
CREATE TABLE IF NOT EXISTS logistic_partner_office (
		  id INT NOT NULL AUTO_INCREMENT,
		  logistic_partner_id INT NOT NULL,
		  office_address VARCHAR(255) NOT NULL,
		  phone_no VARCHAR(20) NOT NULL,
		  email_id VARCHAR(100) NOT NULL,
		  locatcion VARCHAR(255) NOT NULL,
		  state VARCHAR(100) NOT NULL,
		  PRIMARY KEY (id),
		  FOREIGN KEY (logistic_partner_id) REFERENCES logistic_partner(id)
		);

*/
public class LogisticPartnerOffice {
	
	private int logisticPartnerOfficeId;
	
	private int logisticPartnerId;
	
	private String officeAddress;
	
	private String phoneNo;
	
	private String emailId;
	
	private int locationId;

	public int getLogisticPartnerOfficeId() {
		return logisticPartnerOfficeId;
	}

	public void setLogisticPartnerOfficeId(int logisticPartnerOfficeId) {
		this.logisticPartnerOfficeId = logisticPartnerOfficeId;
	}

	public int getLogisticPartnerId() {
		return logisticPartnerId;
	}

	public void setLogisticPartnerId(int logisticPartnerId) {
		this.logisticPartnerId = logisticPartnerId;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	

}
