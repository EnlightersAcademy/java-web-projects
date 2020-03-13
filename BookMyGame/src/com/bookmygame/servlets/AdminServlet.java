package com.bookmygame.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.AdminServices;
import com.bookmygame.services.CommonServices;
import com.bookmygame.services.CustomerServices;
import com.bookmygame.services.impl.CommonServicesImpl;
import com.bookmygame.services.impl.CustomerServicesImpl;

@WebServlet({ "/admin/game", "/admin/customer", "/admin/center", "/admin/booking" })
public class AdminServlet extends HttpServlet {

	AdminServices customerSer = new AdminServicesImpl() {
		
		@Override
		public Customer loginCustomer(String userName, String password) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<SportCenter> getAllSportCenters() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Customer> getAllCustomerDetails() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<GameBooking> getAllBookingsOnSortCenter(int sportCenter) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<GameBooking> getAllBookingsOnCustomer(int customerId) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void blockSportCenter(int sportCenterId) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void blockCustomer(int customerId) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public SportCenter approveOrRejectCenterApplication(SportCenter center, boolean rejectedOnly) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void addNewSportCategories(String sportName) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addNewLocation(String location) {
			// TODO Auto-generated method stub
			
		}
	};();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommonServices commonServices = new CommonServicesImpl();
		if ("/BookMyGame/admin/game".equals(request.getRequestURI())) {
			
		}
		else if("/BookMyGame/admin/customer".equals(request.getRequestURI())){
			customerSer.
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}