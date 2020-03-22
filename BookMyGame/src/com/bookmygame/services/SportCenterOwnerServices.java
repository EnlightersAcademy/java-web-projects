package com.bookmygame.services;

import java.util.List;
import java.util.Map;

import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface SportCenterOwnerServices {

	public void registerSportCenter(SportCenter center) throws Exception;
	
	public SportCenter loginSportCenter(String userName, String password);
	
	public void updateSportCenterDetails(SportCenter center) throws Exception;
	
	public List<GameBooking> getAllBookings(int sportCenterId, String gameName, String date);
	
	public SportCenter getSportCenterById(int sportCenterId);
		
	public Map<String, Object> getProvisionToActiveCountMap(int sportCenterId);
}
