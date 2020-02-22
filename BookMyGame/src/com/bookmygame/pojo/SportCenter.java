package com.bookmygame.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SportCenter {

	@Id
	private int id;
	
	private String name;
	
	private String address;
	
	private Location location;
	
	private long sportCenterPhNo;
	
	private String sportCenterEmailId;
	
	private String twoWheelerparkingAvailability;
	
	private String fourWheelerParkingAvailability;
	
	
	private String OwnerName;
	
	private String age;
	
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
