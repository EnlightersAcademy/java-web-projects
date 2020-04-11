package com.matchmaker.services;

import com.matchmaker.pojo.Customer;

public interface CustomerServices {

	public void registerCustomer(Customer customer) throws Exception;
	
	public Customer loginCustomer(String userName, String password);
	
	public void updateCustomerDetails(Customer customer) throws Exception;
	
	public void cancelBooking(int bookingId) throws Exception;
	
	public Customer getCustomerById(int customerId);
	
	
	
}
