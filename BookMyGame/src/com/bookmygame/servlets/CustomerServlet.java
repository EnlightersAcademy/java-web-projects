package com.bookmygame.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.CustomerServices;
import com.bookmygame.services.impl.CustomerServicesImpl;

@WebServlet(urlPatterns = { "/customer/register", "/customer/login", "/customer/booking/centers" , "customer/game/booking"})
public class CustomerServlet extends HttpServlet {

	Logger logger = Logger.getLogger(CustomerServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerServices services = new CustomerServicesImpl();

		 if ("/BookMyGame/customer/booking/centers".equals(request.getRequestURI())) {
			String locationId = request.getParameter("searchmemberid");
			
			List<SportCenter> centers = services.getSportCentersByLocation(Integer.parseInt(locationId));
			
			request.setAttribute("sportCenters", centers);
			request.getRequestDispatcher("userBookGame.jsp?selectedLocation=" + locationId).forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerServices services = new CustomerServicesImpl();
		if ("/BookMyGame/customer/register".equals(request.getRequestURI())) {

			Customer customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setPassword(request.getParameter("password"));
			customer.setEmailId(request.getParameter("email"));
			customer.setDob(request.getParameter("name"));
			customer.setSex(request.getParameter("gender"));
			customer.setAddress(request.getParameter("address"));
			customer.setPhoneNo(Long.valueOf(request.getParameter("phone")));
			customer.setIdentificationId(request.getParameter("identityNumber"));

			try {
				services.registerCustomer(customer);
				request.getRequestDispatcher("index.jsp?regRequest=success").forward(request, response);
			} catch (Exception exe) {
				request.getRequestDispatcher("index.jsp?regRequest=fail").forward(request, response);
			}

		} else if ("/BookMyGame/customer/login".equals(request.getRequestURI())) {
			String userName = request.getParameter("email");
			String password = request.getParameter("password");
			Customer customer = services.loginCustomer(userName, password);
			if (customer != null) {
				request.getSession().setAttribute("customerId", customer.getId());
				request.getRequestDispatcher("userHome.jsp?result=success").forward(request, response);

			} else {
				request.getRequestDispatcher("index.jsp?result=fail").forward(request, response);
			}
		} else if ("/BookMyGame/customer/update".equals(request.getRequestURI())) {

			int customerId = (Integer) request.getSession().getAttribute("customerId");
			Customer customer = services.getCustomerById(customerId);
			if (customer != null) {
				customer.setPassword(request.getParameter("password"));
				customer.setAddress(request.getParameter("address"));
				customer.setPhoneNo(Long.valueOf(request.getParameter("phone")));
				customer.setIdentificationId(request.getParameter("identityNumber"));
			}

			try {
				services.updateCustomerDetails(customer);
				request.getRequestDispatcher("userAccount.jsp?request=success").forward(request, response);
			} catch (Exception exe) {
				request.getRequestDispatcher("userAccount.jsp?request=fail").forward(request, response);
			}

		}else if ("/BookMyGame/customer/game/booking".equals(request.getRequestURI())) {

			GameBooking booking = new GameBooking();
			booking.setCourtOrBoardName(request.getParameter("selectedCourt"));
			booking.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			booking.setSportCenterId(Integer.parseInt(request.getParameter("centerId")));
			booking.setDateOfBooking(request.getParameter("date"));
			booking.setSportName(request.getParameter("gameName"));
			booking.setTimeSlot(request.getParameter("gameTime"));
			try {
				services.bookMyGame(booking);
				request.getRequestDispatcher("userBookGame.jsp?gameBook=success").forward(request, response);
			} catch (Exception exe) {
				request.getRequestDispatcher("userBookGame.jsp?gameBook=fail").forward(request, response);
			}

		} 

	}

}
