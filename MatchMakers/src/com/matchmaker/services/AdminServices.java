package com.matchmaker.services;

import java.util.List;
import java.util.Map;

import com.matchmaker.pojo.Customer;

public interface AdminServices {

			
	public List<Customer> getAllCustomerDetails();
	
	public void blockCustomer(int customerId) throws Exception;
	
	public void addNewSportCategories(String sportName);
	
	public void addNewLocation(String location);
	
	public void blockSportCenter(int sportCenterId) throws Exception;
	
	public Map<String, Integer> getProvisionToActiveCountMap();


}
