package com.bookmygame.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.enums.AnnouncementType;
import com.bookmygame.services.AdminServices;
import com.bookmygame.services.CommonServices;
import com.bookmygame.services.impl.AdminServicesImpl;
import com.bookmygame.services.impl.CommonServicesImpl;

@WebServlet({ "/admin-game", "/admin-customer", "/admin-center", "/admin-booking-customer", "/admin-booking-center",
		"/admin-announcement", "/admin-login" })
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonServices services = new CommonServicesImpl();
		if (request.getParameter("newAnno") != null) {
			String message = request.getParameter("content");
			int type = Integer.parseInt(request.getParameter("annou"));
			Announcement anno = new Announcement();
			anno.setAnnouncementType(AnnouncementType.values()[type]);
			anno.setMessage(message);
			anno.setMessageDate(new Date(System.currentTimeMillis()).toString());
			services.raiseAnnouncement(anno);
			if (request.getParameter("fromAdmin") != null) {
				request.getRequestDispatcher("adminMemberAnnouncement.jsp?result=success").forward(request, response);
			}
			if (type == 1) {
				request.getRequestDispatcher("centerOfferAnnouncement.jsp?result=success").forward(request, response);
			} else {
				request.getRequestDispatcher("adminCenterAnnouncement.jsp?result=success").forward(request, response);
			}
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminServices services = new AdminServicesImpl();

		if ("/BookMyGame/admin-login".equals(request.getRequestURI())) {

			String userName = request.getParameter("UserId");
			String password = request.getParameter("password");

			if (userName == null || password == null) {
				request.getRequestDispatcher("adminLogin.jsp?result=fail").forward(request, response);
			} else {
				if ("admin".equals(userName) && "admin".equals(password)) {
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("adminLogin.jsp?result=fail").forward(request, response);
				}
			}
		}

		if ("/BookMyGame/admin-center".equals(request.getRequestURI())) {
			boolean blockAction = Boolean.parseBoolean(request.getParameter("blockCenter"));
			if (blockAction) {
				int sportCenterId = Integer.parseInt(request.getParameter("id"));
				try {
					services.blockSportCenter(sportCenterId);
				} catch (Exception exe) {
					request.getRequestDispatcher("adminBlockCenter.jsp?result=fail").forward(request, response);
				}
				request.getRequestDispatcher("adminBlockCenter.jsp?result=success").forward(request, response);
			}
			String approveAction = request.getParameter("toApprove");
			if (approveAction != null) {
				int sportCenterId = Integer.parseInt(request.getParameter("id"));
				try {
					if (Boolean.parseBoolean(approveAction)) {
						services.approveOrRejectCenterApplication(sportCenterId, false);
					} else {
						services.approveOrRejectCenterApplication(sportCenterId, true);
					}
					request.getRequestDispatcher("adminCenterRequests.jsp?result=success").forward(request, response);
				} catch (Exception exe) {
					request.getRequestDispatcher("adminCenterRequests.jsp?result=fail").forward(request, response);
				}

			}
		}

		if ("/BookMyGame/admin-customer".equals(request.getRequestURI())) {
			boolean blockAction = Boolean.parseBoolean(request.getParameter("blockCustomer"));
			if (blockAction) {
				int customerId = Integer.parseInt(request.getParameter("id"));
				try {
					services.blockCustomer(customerId);
				} catch (Exception exe) {
					request.getRequestDispatcher("adminBlockCenter.jsp?result=fail").forward(request, response);
				}
				request.getRequestDispatcher("adminBlockCenter.jsp?result=success").forward(request, response);
			}
		}

		if ("/BookMyGame/admin-announcement".equals(request.getRequestURI())) {

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				doPost(request, response);
			}
		}
		if ("/BookMyGame/admin-booking-customer".equals(request.getRequestURI())) {

			int customerId = Integer.parseInt(request.getParameter("searchmemberid"));
			request.setAttribute("selectedMemberId", customerId);
			request.setAttribute("customerBookings", services.getAllBookingsOnCustomer(customerId));
			request.getRequestDispatcher("adminCustomerBookings.jsp").forward(request, response);
		}
		if ("/BookMyGame/admin-booking-center".equals(request.getRequestURI())) {
			int centerId = Integer.parseInt(request.getParameter("searchcenterid"));
			request.setAttribute("selectedCenterId", centerId);
			request.setAttribute("centerBookings", services.getAllBookingsOnSportCenter(centerId));
			request.getRequestDispatcher("adminCenterBookings.jsp").forward(request, response);
		}
	}
}