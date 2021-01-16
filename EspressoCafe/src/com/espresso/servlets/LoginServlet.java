package com.espresso.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.espresso.common.DbUtil;
import com.espresso.dto.Staff;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logout = request.getParameter("logout");
		if(logout != null) {
			if("true".equals(logout)) {
				request.getSession().invalidate();
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(userName)) {
			if ("admin".equals(password)) {
				
				request.getRequestDispatcher("adminhome.jsp").forward(request, response);
				HttpSession session = request.getSession(true);
				session.setAttribute("sessionId", "admin");
			} else {
				response.sendRedirect("index.jsp?msg=fail");
			}
		} else {
			Staff staff = DbUtil.getStaffByEmailId(userName);
			if (staff != null) {
				if (staff.isActive() && password.equals(staff.getPassword())) {
					HttpSession session = request.getSession(true);
					
					DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
					Date dateobj = new Date();
					String loggedInDateTime = df.format(dateobj);
					staff.setLastLoginTime(loggedInDateTime);
					
					session.setAttribute("staff", staff);
					session.setAttribute("sessionId", staff.getEmailId());
					
					request.getRequestDispatcher("staffhome.jsp").forward(request, response);
				} else {
					response.sendRedirect("index.jsp?msg=fail");
				}
			} else {
				response.sendRedirect("index.jsp?msg=fail");
			}
		}
	}

}
