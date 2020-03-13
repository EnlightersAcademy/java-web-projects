package com.bookmygame.pojo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private Calendar dob;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_no")
	private long phoneNo;
	
	@Column(name="email_id",unique=true)
	private String emailId;
	
	@Column(name="location")
	private String location;
	
	@Column(name="password")
	private String password;
	
	@Column(name="identification_id",unique=true)
	private String identificationId;
	
	@Column(name="is_active")
	private int isActive;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIdentificationId() {
		return identificationId;
	}
	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


}
