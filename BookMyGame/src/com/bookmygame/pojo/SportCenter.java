package com.bookmygame.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SportCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sport_center_id")
	private int sportCenterId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@ManyToOne(cascade = {  CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },fetch=FetchType.EAGER)
	@JoinColumn(name = "location_id", referencedColumnName="location_name")
	private Location location;


	@Column(name = "sport_center_phno")
	private long sportCenterPhNo;

	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Sport.class, fetch = FetchType.EAGER)
	@JoinTable(name = "sport_center_to_sports", joinColumns = {
			@JoinColumn(name = "sport_center_id") }, inverseJoinColumns = { @JoinColumn(name = "sport_id") })
	private Set<Sport> sports;

	@Column(name = "sport_center_emailid")
	private String sportCenterEmailId;
	
	@Column(name = "password")
	private String password;

	@Column(name = "two_wheeler_parking_availability")
	private String twoWheelerparkingAvailability;

	@Column(name = "four_wheeler_parking_availability")
	private String fourWheelerParkingAvailability;

	@Column(name="owner_name")
	private String OwnerName;

	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="owner_email_id")
	private String ownerEmailId;

	@Column(name="identification_id")
	private String identificationId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="is_approved")
	private int isApproved;

	public int getSportCenterId() {
		return sportCenterId;
	}

	public void setSportCenterId(int sportCenterId) {
		this.sportCenterId = sportCenterId;
	}

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

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
