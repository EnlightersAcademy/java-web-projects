package com.shipwell.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shipwell.dto.Employee;
import com.shipwell.dto.LogisticPartner;
import com.shipwell.dto.LogisticPartnerOffice;
import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet(urlPatterns = { "/createlogisticpartner", "/changeemployeestatus", "/createlpoffice", "/viewlpoffices",
		"/editlpprofile", "/viewemployees" })
public class LogisticPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogisticPartnerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("lpId") == null) {
			request.setAttribute("message", "Session expired. Please login again");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		int lpId = (int) (session.getAttribute("lpId"));
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewlpoffices")) {
			List<LogisticPartnerOffice> offices = DBUtils.viewLogisticPartnerOfficesByLPId(lpId);
			request.setAttribute("offices", offices);
			request.getRequestDispatcher("logisticpartneroffices.jsp").forward(request, response);
		}
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/viewemployees")) {
			List<Employee> employees = DBUtils.fetchAllEmployees(lpId, false);
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("logisticpartneremployees.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/createlogisticpartner")) {

			LogisticPartner lp = new LogisticPartner();
			lp.setAirKmRate(Float.parseFloat(request.getParameter("airKmRate")));
			lp.setKgIncreaseRate10(Float.parseFloat(request.getParameter("10kg")));
			lp.setKgIncreaseRate20(Float.parseFloat(request.getParameter("20kg")));
			lp.setKgIncreaseRate5(Float.parseFloat(request.getParameter("5kg")));
			lp.setKgIncreaseRate50(Float.parseFloat(request.getParameter("50kg")));
			lp.setKgIncreaseRate50More(Float.parseFloat(request.getParameter("50MoreKg")));
			lp.setMainOfficeLocation(request.getParameter("officeLocation"));
			lp.setOwnerEmailId(request.getParameter("ownerEmailId"));
			lp.setOwnerName(request.getParameter("ownerName"));
			lp.setOwnerPhoneNo(request.getParameter("ownerPhone"));
			lp.setPassword(request.getParameter("password"));
			lp.setPhoneNo(request.getParameter("phoneNo"));
			lp.setRailKmRate(Float.parseFloat(request.getParameter("railKmRate")));
			lp.setRoadKmRate(Float.parseFloat(request.getParameter("roadKmRate")));
			lp.setSeaKmRate(Float.parseFloat(request.getParameter("seaKmRate")));
			lp.setSecurityAnswer(request.getParameter("securityAnswer"));
			lp.setSecurityQuestion(request.getParameter("securityQuestion"));
			lp.setEmailId(request.getParameter("securityQuestion"));
			lp.setName(request.getParameter("securityQuestion"));

			boolean executionStatus = DBUtils.createLogisticPartner(lp);
			String message = "Successfully created the profile";
			if (!executionStatus) {
				message = "Failed to create the profile. Please try again";
			}

			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("lpId") == null) {
			request.setAttribute("message", "Session expired. Please login again");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		int lpId = (int) (session.getAttribute("lpId"));
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/editlpprofile")) {

			LogisticPartner lp = new LogisticPartner();
			lp.setAirKmRate(Float.parseFloat(request.getParameter("airKmRate")));
			lp.setKgIncreaseRate10(Float.parseFloat(request.getParameter("10kg")));
			lp.setKgIncreaseRate20(Float.parseFloat(request.getParameter("20kg")));
			lp.setKgIncreaseRate5(Float.parseFloat(request.getParameter("5kg")));
			lp.setKgIncreaseRate50(Float.parseFloat(request.getParameter("50kg")));
			lp.setKgIncreaseRate50More(Float.parseFloat(request.getParameter("50MoreKg")));
			lp.setMainOfficeLocation(request.getParameter("officeLocation"));
			lp.setOwnerEmailId(request.getParameter("ownerEmailId"));
			lp.setOwnerName(request.getParameter("ownerName"));
			lp.setOwnerPhoneNo(request.getParameter("ownerPhone"));
			lp.setPassword(request.getParameter("password"));
			lp.setPhoneNo(request.getParameter("phoneNo"));
			lp.setRailKmRate(Float.parseFloat(request.getParameter("railKmRate")));
			lp.setRoadKmRate(Float.parseFloat(request.getParameter("roadKmRate")));
			lp.setSeaKmRate(Float.parseFloat(request.getParameter("seaKmRate")));
			lp.setSecurityAnswer(request.getParameter("securityAnswer"));
			lp.setSecurityQuestion(request.getParameter("securityQuestion"));
			lp.setLogisticPartnerId(lpId);

			boolean executionStatus = DBUtils.editLogisticPartner(lp);
			String message = "Successfully updated the profile";
			if (!executionStatus) {
				message = "Failed to update the profile. Please try again";
			}

			request.setAttribute("message", message);
			request.getRequestDispatcher("logisticpartnerhome.jsp").forward(request, response);

		} else if (request.getRequestURI().equalsIgnoreCase("/ShipWell/createlpoffice")) {

			LogisticPartnerOffice office = new LogisticPartnerOffice();
			office.setEmailId(request.getParameter("emailId"));
			office.setLocationId(Integer.parseInt(request.getParameter("locationId")));
			office.setLogisticPartnerId(Integer.parseInt(request.getParameter("complaintText")));
			office.setLogisticPartnerOfficeId(Integer.parseInt(request.getParameter("complaintText")));
			office.setOfficeAddress(request.getParameter("complaintText"));
			office.setPhoneNo(request.getParameter("complaintText"));

			boolean executionStatus = DBUtils.createLogisticPartnerOffice(office);
			String message = "Successfully created the new office entry";
			if (!executionStatus) {
				message = "Failed to create the office entry. Please try again";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("logisticpartnerhome.jsp").forward(request, response);

		} else if (request.getRequestURI().equalsIgnoreCase("/ShipWell/changeemployeestatus")) {
			
			int employeeId = Integer.parseInt(request.getParameter("locationId"));
			int status = Integer.parseInt(request.getParameter("status"));
			boolean executionStatus = DBUtils.changeEmployeeStatus(employeeId, status);
			String message = "Successfully updated the employee status";
			if (!executionStatus) {
				message = "Failed to update the employee status. Please try again";
			}

			request.setAttribute("message", message);
			request.getRequestDispatcher("logisticpartnerhome.jsp").forward(request, response);
		}

	}

}
