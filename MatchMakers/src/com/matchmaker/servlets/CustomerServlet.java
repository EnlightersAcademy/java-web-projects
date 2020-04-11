package com.matchmaker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.matchmaker.pojo.Customer;
import com.matchmaker.pojo.Horoscope;
import com.matchmaker.services.CustomerServices;
import com.matchmaker.services.impl.CustomerServicesImpl;

@WebServlet(urlPatterns = { "/customer-register", "/customer-login", "/customer-booking-centers",
		"/customer-game-booking", "/customer-update", "/cancel-booking" })
public class CustomerServlet extends HttpServlet {

	Logger logger = Logger.getLogger(CustomerServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerServices services = new CustomerServicesImpl();

		if ("/BookMyGame/customer-booking-centers".equals(request.getRequestURI())) {
			String locationId = request.getParameter("searchmemberid");
			if (locationId == null || "null".equals(locationId)) {
				request.getRequestDispatcher("userBookGame.jsp?invalidLocation=true" + locationId).forward(request,
						response);
			} else {
//				Location location = services.getLocationById(Integer.parseInt(locationId));
//				List<SportCenter> centers = new ArrayList<SportCenter>();
//				if (location != null) {
//					centers = services.getSportCentersByLocation(location.getLocationName());
//				}

//				request.setAttribute("sportCenters", centers);
				request.getRequestDispatcher("userBookGame.jsp?selectedLocation=" + locationId).forward(request,
						response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerServices services = new CustomerServicesImpl();
		if ("/Match_Makers/customer-register".equals(request.getRequestURI())) {

			Customer customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setPassword(request.getParameter("password"));
			customer.setEmailId(request.getParameter("email"));
	//		customer.setDob(request.getParameter("dob"));
			customer.setSex(request.getParameter("gender"));
			customer.setAddress(request.getParameter("address"));
	//		customer.setLocation(request.getParameter("location"));
			customer.setPhoneNo(Long.valueOf(request.getParameter("phone")));
			customer.setIdentificationId(request.getParameter("identityNumber"));
			customer.setIsActive(1);
			Horoscope horo = new Horoscope();
			horo.setRasi("myrasi");

			customer.setHoroscope(horo);

			try {
				services.registerCustomer(customer);
				request.getRequestDispatcher("index.jsp?regRequest=success").forward(request, response);
			} catch (Exception exe) {
				request.getRequestDispatcher("index.jsp?regRequest=fail").forward(request, response);
			}

		} else if ("/BookMyGame/customer-login".equals(request.getRequestURI())) {
			String userName = request.getParameter("email");
			String password = request.getParameter("password");
			Customer customer = services.loginCustomer(userName, password);
			if (customer != null) {
				request.getSession().setAttribute("customerId", customer.getId());
				request.getRequestDispatcher("userHome.jsp?result=success").forward(request, response);

			} else {
				request.getRequestDispatcher("index.jsp?result=fail").forward(request, response);
			}
		} else if ("/BookMyGame/customer-update".equals(request.getRequestURI())) {

			int customerId = (Integer) request.getSession().getAttribute("customerId");
			Customer customer = services.getCustomerById(customerId);
			if (customer != null) {
				customer.setPassword(request.getParameter("password"));
				customer.setAddress(request.getParameter("address"));
		//		customer.setLocation(request.getParameter("location"));
				customer.setPhoneNo(Long.valueOf(request.getParameter("phone")));
				customer.setIdentificationId(request.getParameter("identityNumber"));
			}

			try {
				services.updateCustomerDetails(customer);
				request.getRequestDispatcher("userAccount.jsp?result=success").forward(request, response);
			} catch (Exception exe) {
				exe.printStackTrace();
				request.getRequestDispatcher("userAccount.jsp?result=fail").forward(request, response);
			}

		} else if ("/BookMyGame/customer-game-booking".equals(request.getRequestURI())) {

//			GameBooking booking = new GameBooking();
//			booking.setCourtOrBoardName(request.getParameter("selectedCourt"));
//			booking.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
//			booking.setSportCenterId(Integer.parseInt(request.getParameter("centerId")));
//			booking.setDateOfBooking(request.getParameter("date"));
//			booking.setSportName(request.getParameter("gameName"));
//			booking.setTimeSlot(request.getParameter("gameTime"));
			try {
//				services.bookMyGame(booking);
				request.getRequestDispatcher("userBookGame.jsp?gameBook=success").forward(request, response);
			} catch (Exception exe) {
				request.getRequestDispatcher("userBookGame.jsp?gameBook=fail").forward(request, response);
			}

		} else if ("/BookMyGame/cancel-booking".equals(request.getRequestURI())) {
			
			int bookingId = request.getParameter("bookingId") != null ? Integer.parseInt(request.getParameter("bookingId")) : 0;
			try {
				services.cancelBooking(bookingId);
				request.getRequestDispatcher("userViewBookings.jsp?gameCancel=success").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("userViewBookings.jsp?gameCancel=fail").forward(request, response);
			}
			
		}

	}

}
