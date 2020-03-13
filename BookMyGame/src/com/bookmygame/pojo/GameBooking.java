package com.bookmygame.pojo;

import java.util.Date;

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
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="sport_center_id")
	private SportCenter sportCenter;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@Column(name="court_or_board_name")
	private String courtOrBoardName;
	
	@Column(name="time_slot")
	private String timeSlot;
	
	@Column(name="date_of_booking")
	private Date dateOfBooking;



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
	
}
