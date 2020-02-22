package com.bookmygame.services;

import java.util.List;

import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface SportCenterOwnerServices {

	public void registerSportCenter(SportCenter center);
	
	public SportCenter loginSportCenter(String userName, String password);
	
	public void updateCustomerDetails(Customer customer) throws Exception;
	
	public List<GameBooking> getAllBookings(int customerId);
	
	public void bookMyGame(GameBooking booking) throws Exception;
	
	public void cancelBooking(GameBooking booking) throws Exception;
	
}
