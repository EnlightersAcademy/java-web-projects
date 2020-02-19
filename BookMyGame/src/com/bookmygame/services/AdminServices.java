package com.bookmygame.services;

import java.util.List;

import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface AdminServices {

	
	public Customer loginCustomer(String userName, String password);
		
	public List<Customer> getAllCustomerDetails();
	
	public void blockCustomer(int customerId) throws Exception;
	
	public List<GameBooking> getAllBookingsOnCustomer(int customerId);
	
	public List<GameBooking> getAllBookingsOnSortCenter(int sportCenter);
	
	public void addNewSportCategories(String sportName);
	
	public void addNewLocation(String location);
	
	public SportCenter approveOrRejectCenterApplication(SportCenter center, boolean rejectedOnly);
	
	public List<SportCenter> getAllSportCenters();
	
	public void blockSportCenter(int sportCenterId) throws Exception;

}
