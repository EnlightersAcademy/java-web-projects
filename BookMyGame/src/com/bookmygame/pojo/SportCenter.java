package com.bookmygame.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SportCenter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sport_center_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Embedded
	private Location location;
	
	@Column(name="sport_center_phno")
	private long sportCenterPhNo;
	
	@Column(name="sport_center_emailid")
	private String sportCenterEmailId;
	
	@Column(name="two_wheeler_parking_availability")
	private String twoWheelerparkingAvailability;
	
	@Column(name="four_wheeler_parking_availability")
	private String fourWheelerParkingAvailability;
	
	
	private String OwnerName;
	
	private String phoneNo;
	
	private String ownerEmailId;
	
	private String identificationId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public long getSportCenterPhNo() {
		return sportCenterPhNo;
	}

	public void setSportCenterPhNo(long sportCenterPhNo) {
		this.sportCenterPhNo = sportCenterPhNo;
	}

	public String getSportCenterEmailId() {
		return sportCenterEmailId;
	}

	public void setSportCenterEmailId(String sportCenterEmailId) {
		this.sportCenterEmailId = sportCenterEmailId;
	}

	public String getTwoWheelerparkingAvailability() {
		return twoWheelerparkingAvailability;
	}

	public void setTwoWheelerparkingAvailability(String twoWheelerparkingAvailability) {
		this.twoWheelerparkingAvailability = twoWheelerparkingAvailability;
	}

	public String getFourWheelerParkingAvailability() {
		return fourWheelerParkingAvailability;
	}

	public void setFourWheelerParkingAvailability(String fourWheelerParkingAvailability) {
		this.fourWheelerParkingAvailability = fourWheelerParkingAvailability;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public String getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}
	
	
}
