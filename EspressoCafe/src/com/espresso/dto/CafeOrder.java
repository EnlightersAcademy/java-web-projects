package com.espresso.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cafe_Order")
public class CafeOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

//	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
//	@JoinColumn(name = "customer_id", unique= true)
	@Column(name="customer_email_id")
	private String customerEmailId;

//	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class, cascade=CascadeType.MERGE)
//	@JoinColumn(name = "staff_id", unique = true)
	@Column(name="staff_id")
	private int staffId;

	@OneToMany(targetEntity=OrderItem.class, mappedBy="cafeOrder", cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private List<OrderItem> items = new ArrayList<OrderItem>();


	@Column(name = "total_amount")
	private int totalAmount;

	@Column(name = "date_of_order")
	private String dateOfOrder;
	
	//1 for completed, 2 for in progress
	@Column(name = "status")
	private int status;

	public int getId() {
		return id;
	}


	public void setId(int orderId) {
		this.id = orderId;
	}


	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getCustomerEmailId() {
		return customerEmailId;
	}


	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

}
