package com.shipwell.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shipwell.dto.Complaint;
import com.shipwell.dto.Customer;
import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet(urlPatterns = { "/createcomplaint", "/editprofile", "/viewcomplaint", "/createcustomer" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();

		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewcomplaint")) {

			if (session.getAttribute("customerId") != null) {
				List<Complaint> complaints = DBUtils
						.viewComplaintsByCustomerId((int) session.getAttribute("customerId"));
				request.setAttribute("complaints", complaints);
				request.getRequestDispatcher("customercomplaints.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Session expired. Please login again");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/createcustomer")) {
			Customer customer = new Customer();

			customer.setPhoneNo(request.getParameter("phoneNo"));
			customer.setHomeAdress(request.getParameter("homeAddress"));
			customer.setPassword(request.getParameter("password"));
			customer.setDob(request.getParameter("dob"));
			customer.setEmailId(request.getParameter("emailId"));
			customer.setName(request.getParameter("name"));
			customer.setStatus(1);

			boolean executionStatus = DBUtils.createCustomer(customer);
			String message = "Successfully created the customer";
			if(!executionStatus) {
				message = "Failed to create the customer. Please try again";
			}
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("customerId") == null) {
			request.setAttribute("message", "Session expired. Please login again");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		int customerId = (int) (session.getAttribute("customerId"));
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/editprofile")) {

			
			Customer customer = new Customer();
			customer.setCustomerId(customerId);
			customer.setPhoneNo(request.getParameter("phoneNo"));
			customer.setHomeAdress(request.getParameter("homeAddress"));
			customer.setPassword(request.getParameter("password"));

			boolean executionStatus = DBUtils.editCustomer(customer);
			String message = "Successfully updated the profile";
			if(!executionStatus) {
				message = "Failed to update the profile. Please try again";
			}
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("customerhomepage.jsp").forward(request, response);

		} else if (request.getRequestURI().equalsIgnoreCase("/ShipWell/createcomplaint")) {
			
			Complaint complaint = new Complaint();
			complaint.setComplaint(request.getParameter("complaintText"));
			complaint.setCustomerId(customerId);
			complaint.setLogisticPartnerId(Integer.parseInt(request.getParameter("logisticPartnerId")));

			boolean executionStatus = DBUtils.createComplaint(complaint);
			String message = "Successfully created the complaint";
			if(!executionStatus) {
				message = "Failed to create the complaint. Please try again";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("customerhomepage.jsp").forward(request, response);
		
		}  
	}

}
