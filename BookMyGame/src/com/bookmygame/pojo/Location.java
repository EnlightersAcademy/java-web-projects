package com.bookmygame.pojo;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

	private String locationName;

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
