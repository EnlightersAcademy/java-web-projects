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
import com.shipwell.dto.LogisticPartner;
import com.shipwell.dto.LogisticPartnerOffice;
import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = { "/announcement", "/viewlogisticpartners", "/logisticpartnerstatechange", "/viewcustomers",
		"/customerstatechange", "updatecustomercomplaint", "viewcustomercomplaints" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null) {
			request.setAttribute("message", "Session expired. Please login again");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewlogisticpartners")) {

			boolean onlyActive = false;
			if (request.getParameter("onlyactive") != null)
				onlyActive = Boolean.getBoolean(request.getParameter("onlyactive"));
			List<LogisticPartner> lps = DBUtils.fetchAllLogisticParners(onlyActive);
			request.setAttribute("logicalpartners", lps);
			request.getRequestDispatcher("admin-manage-providers.jsp").forward(request, response);
		}
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewcustomers")) {

			boolean onlyActive = false;
			if (request.getParameter("onlyactive") != null)
				onlyActive = Boolean.getBoolean(request.getParameter("onlyactive"));
			List<Customer> customers = DBUtils.fetchAllCustomers(onlyActive);
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("admin-manage-customers.jsp").forward(request, response);
		}
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewcustomercomplaints")) {
			List<Complaint> complaints = DBUtils.viewAllComplaints();
			request.setAttribute("complaints", complaints);
			request.getRequestDispatcher("admin-manage-complaints.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/logisticpartnerstatechange")) {

			int lpId = Integer.parseInt(request.getParameter("lpId"));
			int status = Integer.parseInt(request.getParameter("status"));
			boolean executionStatus = DBUtils.changeLogisticParnerStatus(lpId, status);
			
			String message = "Successfully changed the status of Logistic Partner";
			if (!executionStatus) {
				message = "Failed to update the status of Logistic Partner. Please try again";
			}

			request.setAttribute("message", message);
			request.getRequestDispatcher("admin-manage-providers.jsp").forward(request, response);

		} else if(request.getRequestURI().equalsIgnoreCase("/ShipWell/customerstatechange")) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			int status = Integer.parseInt(request.getParameter("status"));
			boolean executionStatus = DBUtils.changeCustomerStatus(customerId, status);
			
			String message = "Successfully changed the status of Customer";
			if (!executionStatus) {
				message = "Failed to update the status of Customer. Please try again";
			}

			request.setAttribute("message", message);
			request.getRequestDispatcher("admin-manage-customers.jsp").forward(request, response);
		}
		
	}

}
