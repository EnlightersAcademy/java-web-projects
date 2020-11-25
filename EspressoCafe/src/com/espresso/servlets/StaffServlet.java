package com.espresso.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.Item;
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

		String status = request.getParameter("status");
		int staffId = Integer.parseInt(request.getParameter("id"));
		if(status != null) {
			boolean returnStatus = true;
			if("true".equals(status)) {

				DbUtil<Item> util = new DbUtil<>();
				 returnStatus = util.updateStaffStatus(staffId, false);
			} else if("false".equals(status)) {
				DbUtil<Item> util = new DbUtil<>();
				 returnStatus = util.updateStaffStatus(staffId, true);
			}
			if(returnStatus) {
				request.getRequestDispatcher("adminviewstaff.jsp?msg=success").forward(request, response);
			} else {
				request.getRequestDispatcher("adminviewstaff.jsp?msg=fail").forward(request, response);
			}
			return;
		}
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Staff staff = DbUtil.getStaffByEmailId(userName);
		if(staff != null) {
			if(password.equals(staff.getPassword())) {
				HttpSession session = request.getSession(true);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!EspressoUtil.isValidSession(request)) {
			response.sendRedirect("index.jsp?exp=true");
			return;
		}
		
		if(request.getParameter("pass") != null && "true".equals(request.getParameter("pass"))) {
			Staff staff = (Staff)request.getSession().getAttribute("staff");
			String pass1 = request.getParameter("password1");
			String pass2 = request.getParameter("password2");
			if(!(pass1.equals(pass2))) {
				request.getRequestDispatcher("staffchangepass.jsp?msg=mismatch").forward(request, response);
				try {
					DbUtil.updateStaffPassword(staff, pass1);
					request.getRequestDispatcher("staffchangepass.jsp?msg=success").forward(request, response);
					return;
				} catch (Exception e) {
					request.getRequestDispatcher("staffchangepass.jsp?msg=fail").forward(request, response);
					return;
				}
			}
		}
		DbUtil<Staff> util = new DbUtil<>();
		String emailId = request.getParameter("email");

		Staff staff = null;
		boolean isUpdateReq = (request.getParameter("update") != null && "true".equals(request.getParameter("update")));
		if(isUpdateReq) {
			staff = util.getStaffByEmailId(emailId);
		} else {
		staff = new Staff();
		staff.setActive(true);
		}
		staff.setName(request.getParameter("name"));
		staff.setEmailId(emailId);
		staff.setGender(request.getParameter("gender"));
		staff.setIdentification(request.getParameter("idnumber"));
		staff.setPhoneNo(request.getParameter("mobile"));
		staff.setDob(request.getParameter("dob"));
		staff.setAddress(request.getParameter("address"));
		staff.setIdType(request.getParameter("idtype"));

		try {
			if(isUpdateReq) {
				util.updateStaffDetails(staff);
				request.getRequestDispatcher("admineditstaff.jsp?emailId="+emailId+"&msg=success").forward(request, response);
				return;
			}else {
			util.createEntry(staff);
			request.getRequestDispatcher("adminaddstaff.jsp?msg=success").forward(request, response);
			return;
			}
			
		} catch (Exception exe) {
			exe.printStackTrace();
			request.getRequestDispatcher("adminaddstaff.jsp?msg=fail").forward(request, response);
		}

	}

}
