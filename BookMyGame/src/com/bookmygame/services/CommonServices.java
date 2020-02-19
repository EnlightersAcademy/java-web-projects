package com.bookmygame.services;

import java.util.List;

import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface CommonServices {
	
	public List<Announcement> getAllAnnoucements();
	
	public List<String> getAllLocations();
	
	public List<SportCenter> getAllSportCentersByLocation(String location);
	
	public List<String> getAllSportsInSportCenter(int sportCenterId);
	
	public void raiseAnnouncement(Announcement announcement);

	
}
