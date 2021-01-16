package com.espresso.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.espresso.common.DbUtil;
import com.espresso.dto.Customer;
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
		boolean isExisting = Boolean.parseBoolean(request.getParameter("existing"));
		DbUtil<Customer> util = new DbUtil<>();
		String emailId = request.getParameter("email");
		String name = request.getParameter("customername");
		String phoneNo = request.getParameter("mobile");
		Customer cus = new Customer();
		cus.setEmailId(emailId);
		cus.setName(name);
		cus.setPhoneNo(phoneNo);

		try {
			if (!isExisting) {
				util.createEntry(cus);
			}
			Object orderMap = request.getSession().getAttribute("cusEmailToOrder");
			Map<String, Integer> cusEmailToOrder = null;
			if (orderMap != null) {
				cusEmailToOrder = (Map<String, Integer>) orderMap;
			} else {
				cusEmailToOrder = new HashMap<String, Integer>();
			}
			if (!isExisting) {
				cusEmailToOrder.put(emailId, null);
				request.getSession().setAttribute("cusEmailToOrder", cusEmailToOrder);
			}
			request.getRequestDispatcher("staffneworder3.jsp?msg=success&email="+emailId).forward(request, response);

		} catch (Exception exe) {
			exe.printStackTrace();
			request.getRequestDispatcher("staffneworder3.jsp?msg=fail").forward(request, response);
		}

	}

}
