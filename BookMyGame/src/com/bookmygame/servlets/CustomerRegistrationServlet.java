package com.bookmygame.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bookmygame.pojo.Customer;
import com.bookmygame.services.CustomerServices;
import com.bookmygame.services.impl.CustomerServicesImpl;

@WebServlet(urlPatterns = { "/customer/register", "/customer/login" })
public class CustomerRegistrationServlet extends HttpServlet {
	
	Logger logger = Logger.getLogger(CustomerRegistrationServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		if ("/BookMyGame/customer/register".equals(request.getRequestURI())) {
//
//			Customer customer = new Customer();
//			customer.setName(request.getParameter("name"));
//			customer.setPassword("aditya");
//			customer.setEmailId("aditya@gmail.com");
//			
//			CustomerServices services = new CustomerServicesImpl();
//			services.registerCustomer(customer);
//			
//			customer = services.loginCustomer("aditya@gmail.com", "aditya");
//			if(customer != null) {
//				logger.info("Customer name is "+ customer.getName());
//				System.out.println("customer name is " + customer.getName());
//			}
//			
//		} else if ("/BookMyGame/customer/login".equals(request.getRequestURI())) {
//			String username = request.getParameter("name");
//			String password = request.getParameter("pass");
//		}

	}

}
