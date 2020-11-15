package com.espresso.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.Customer;
import com.espresso.dto.Staff;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/customer")
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
		
		DbUtil<Customer> util = new DbUtil<>();
		String emailId = request.getParameter("email");
		String name = request.getParameter("customername");
		String phoneNo = request.getParameter("mobile");
		Customer cus = new Customer();
		cus.setEmailId(emailId);
		cus.setName(name);
		cus.setPhoneNo(phoneNo);
		
		try {

			util.createEntry(cus);
			request.getRequestDispatcher("adminaddstaff.jsp?msg=success").forward(request, response);
						
		} catch (Exception exe) {
			request.getRequestDispatcher("adminaddstaff.jsp?msg=fail").forward(request, response);
		}

	}

}
