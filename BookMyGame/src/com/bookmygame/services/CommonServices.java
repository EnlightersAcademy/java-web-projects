package com.bookmygame.services;

import java.util.List;
import java.util.Set;

import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.Location;
import com.bookmygame.pojo.Sport;
import com.bookmygame.pojo.SportCenter;

public interface CommonServices {
	
	public List<Announcement> getAllAnnoucements();
	
	public List<Location> getAllLocations();
	
	public List<SportCenter> getAllSportCentersByLocation(String locationName);
	
	public Set<Sport> getAllSportsInSportCenter(int sportCenterId);
	
	public void raiseAnnouncement(Announcement announcement);

	
}
