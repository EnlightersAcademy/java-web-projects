package com.bookmygame.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_booking")
public class GameBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne(targetEntity=SportCenter.class, cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="sport_center_id", insertable=false, updatable=false)
	private SportCenter sportCenter;
	
	@Column(name="sport_center_id")
	private int sportCenterId;
	
	@ManyToOne(targetEntity=Customer.class , cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id", insertable=false, updatable=false)
	private Customer customer;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="sport_name")
	private String sportName;
	
	@Column(name="court_or_board_name")
	private String courtOrBoardName;
	
	@Column(name="time_slot")
	private String timeSlot;
	
	@Column(name="date_of_booking")
	private String dateOfBooking;



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public SportCenter getSportCenter() {
		return sportCenter;
	}

	public void setSportCenter(SportCenter sportCenter) {
		this.sportCenter = sportCenter;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSportCenterId() {
		return sportCenterId;
	}

	public void setSportCenterId(int sportCenterId) {
		this.sportCenterId = sportCenterId;
	}
	
}
