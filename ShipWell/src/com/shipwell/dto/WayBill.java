package com.shipwell.dto;

import java.sql.Date;

public class WayBill {
	
	private int wayBillId;
	
	private int customerId;
	
	private int logisticPartnerId;
	
	private String productDetails;
	
	private float amount;
	
	private float weight;
	
	private String modeOfTransportation;
	
	private String status;
	
	private String comment;
	
	private String deliveryDate;

	public int getWayBillId() {
		return wayBillId;
	}

	public void setWayBillId(int wayBillId) {
		this.wayBillId = wayBillId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLogisticPartnerId() {
		return logisticPartnerId;
	}

	public void setLogisticPartnerId(int logisticPartnerId) {
		this.logisticPartnerId = logisticPartnerId;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getModeOfTransportation() {
		return modeOfTransportation;
	}

	public void setModeOfTransportation(String modeOfTransportation) {
		this.modeOfTransportation = modeOfTransportation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
