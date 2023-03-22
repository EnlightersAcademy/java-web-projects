package com.shipwell.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(urlPatterns = { "/registeremployee", "/viewemployee" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/createlogisticpartner")) {
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
		}
	}

}
