package com.espresso.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "customer_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Customer.class)
	private Customer customer;

	@Column(name = "staff_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Staff.class)
	private Staff staff;


	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=OrderItem.class, fetch = FetchType.EAGER)
	private List<OrderItem> items = new ArrayList<OrderItem>();


	@Column(name = "total_amount")
	private int totalAmount;

	@Column(name = "date_of_order")
	private Date dateOfOrder;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}

//Add new staff – Name, Phone, Email, Address, ID Type, ID Number, Gender, DOB
//
//
//@ManyToOne(targetEntity=SportCenter.class, cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
//	@JoinColumn(name="sport_center_id", insertable=false, updatable=false)
//	private SportCenter sportCenter;
//
//
//		@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Sport.class, fetch = FetchType.EAGER)
//	@JoinTable(name = "sport_center_to_sports", joinColumns = {
//			@JoinColumn(name = "sport_center_id") }, inverseJoinColumns = { @JoinColumn(name = "sport_id") })
//	private Set<Sport> sports;