package com.espresso.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.Staff;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffServlet() {
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
		if (!EspressoUtil.isValidSession(request)) {
			response.sendRedirect("index.jsp?exp=true");
		}
		DbUtil<Staff> util = new DbUtil<>();
		String emailId = request.getParameter("email");
		if (DbUtil.getStaffByEmailId(emailId) != null) {
			request.getRequestDispatcher("adminaddstaff.jsp?msg=dup").forward(request, response);
		}
		Staff staff = new Staff();
		staff.setName(request.getParameter("name"));
		staff.setEmailId(emailId);
		staff.setGender(request.getParameter("gender"));
		staff.setIdentification(request.getParameter("idnumber"));
		staff.setPhoneNo(request.getParameter("mobile"));
		staff.setDob(request.getParameter("dob"));
		staff.setAddress(request.getParameter("address"));
		staff.setIdType(request.getParameter("idtype"));

		try {
			util.createEntry(staff);
			request.getRequestDispatcher("adminaddstaff.jsp?msg=success").forward(request, response);
		} catch (Exception exe) {
			request.getRequestDispatcher("adminaddstaff.jsp?msg=fail").forward(request, response);
		}

	}

}
