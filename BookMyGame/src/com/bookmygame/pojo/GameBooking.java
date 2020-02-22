package com.bookmygame.pojo;

import java.util.Date;

public class GameBooking {

	private int bookingId;
	
	private int sportCenterId;
	
	private int customerId;
	
	private int locationId;
	
	private String courtOrBoardName;
	
	private String timeSlot;
	
	private Date dateOfBooking;

	public int getSportCenterId() {
		return sportCenterId;
	}

	public void setSportCenterId(int sportCenterId) {
		this.sportCenterId = sportCenterId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCourtOrBoardName() {
		return courtOrBoardName;
	}

	public void setCourtOrBoardName(String courtOrBoardName) {
		this.courtOrBoardName = courtOrBoardName;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
}
