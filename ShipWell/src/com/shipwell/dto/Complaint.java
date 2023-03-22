package com.shipwell.dto;

public class Complaint {

	private int complaintId;
	
	private String complaint;
	
	private String response;
	
	private int logisticPartnerId;
	
	private int customerId;

	private String status;
	
	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getLogisticPartnerId() {
		return logisticPartnerId;
	}

	public void setLogisticPartnerId(int logisticPartnerId) {
		this.logisticPartnerId = logisticPartnerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
