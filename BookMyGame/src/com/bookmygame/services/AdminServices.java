package com.bookmygame.services;

import java.util.List;
import java.util.Map;

import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;

public interface AdminServices {

			
	public List<Customer> getAllCustomerDetails();
	
	public void blockCustomer(int customerId) throws Exception;
	
	public List<GameBooking> getAllBookingsOnCustomer(int customerId);
	
	public List<GameBooking> getAllBookingsOnSportCenter(int sportCenter);
	
	public void addNewSportCategories(String sportName);
	
	public void addNewLocation(String location);
	
	public SportCenter approveOrRejectCenterApplication(int sportCenterId, boolean rejectedOnly) throws Exception ;
	
	public List<SportCenter> getAllActiveSportCenters();
	
	public List<SportCenter> getAllSportCenters();
	
	public List<SportCenter> getAllSportCentersToApprove();
	
	public void blockSportCenter(int sportCenterId) throws Exception;
	
	public Map<String, Integer> getProvisionToActiveCountMap();
	
	public List<SportCenter> getAllRejectedSportCenters();

}
