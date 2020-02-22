package com.bookmygame.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sport {

	@Id
	private int id;
	
	private String name;
	
	private String image;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
