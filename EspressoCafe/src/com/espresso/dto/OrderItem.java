package com.espresso.dto;

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
@Table(name="Order_Item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private int orderItemId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cafe_order_id")
	private CafeOrder cafeOrder;

	public int getOrderId() {
		return orderItemId;
	}

	public void setOrderId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public CafeOrder getCafeOrder() {
		return cafeOrder;
	}

	public void setCafeOrder(CafeOrder cafeOrder) {
		this.cafeOrder = cafeOrder;
	}

}
