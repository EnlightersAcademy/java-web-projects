package com.bookmygame.services;

import java.util.List;

import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface SportCenterOwnerServices {

	public void registerSportCenter(SportCenter center);
	
	public SportCenter loginSportCenter(String userName, String password);
	
	public void updateSportCenterDetails(SportCenter center) throws Exception;
	
	public List<GameBooking> getAllBookings(int sportCenterId);
		
}
