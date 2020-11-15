package com.espresso.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.espresso.dto.Category;

@Entity
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private boolean isAvailable;
	
	private int price;
	
	
	@Column(name="photo")
	@Lob
	private byte[] photo;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
