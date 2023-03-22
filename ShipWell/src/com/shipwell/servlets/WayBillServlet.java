package com.shipwell.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shipwell.dto.WayBill;
import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet(urlPatterns = { "/waybillcreate", "/waybillupdate", "/waybillview" })
public class WayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WayBillServlet() {
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
		int customerId = -1;
		int logisticPartnerId = -1;
		int wayBillId = -1;
		if (session.getAttribute("customerId") != null) {
			if (request.getParameter("wayBillId") != null) {
				wayBillId = Integer.parseInt(request.getParameter("wayBillId"));
				WayBill wayBill = DBUtils.fetchWayBillsByWayBillId(wayBillId);
				request.setAttribute("waybill", wayBill);
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
				// need to send it back to right JSP file. need a parameter from client
			} else {
				customerId = (int) (session.getAttribute("customerId"));
				List<WayBill> wayBills = DBUtils.fetchWayBillsByCustomerId(customerId);
				request.setAttribute("waybills", wayBills);
				request.getRequestDispatcher("customerwaybill.jsp").forward(request, response);
			}

		}
		else if (session.getAttribute("logisticPartnerId") != null) {
			if (request.getParameter("wayBillId") != null) {
				wayBillId = Integer.parseInt(request.getParameter("wayBillId"));
				WayBill wayBill = DBUtils.fetchWayBillsByWayBillId(wayBillId);
				request.setAttribute("waybill", wayBill);
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
				// need to send it back to right JSP file. need a parameter from client
			} else {
				logisticPartnerId = (int) (session.getAttribute("logisticPartnerId"));
				List<WayBill> wayBills = DBUtils.fetchWayBillsByLogisticPartnerId(logisticPartnerId);
				request.setAttribute("waybills", wayBills);
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
			}
		}
		else if (session.getAttribute("employeeId") != null) {
			if (request.getParameter("wayBillId") != null) {
				wayBillId = Integer.parseInt(request.getParameter("wayBillId"));
				WayBill wayBill = DBUtils.fetchWayBillsByWayBillId(wayBillId);
				request.setAttribute("waybill", wayBill);
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
				// need to send it back to right JSP file. need a parameter from client
			} else {
				logisticPartnerId = (int) (session.getAttribute("logisticPartnerId"));
				List<WayBill> wayBills = DBUtils.fetchWayBillsByLogisticPartnerId(logisticPartnerId);
				request.setAttribute("waybills", wayBills);
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("wayBillId") != null) {
			wayBillId = Integer.parseInt(request.getParameter("wayBillId"));
			WayBill wayBill = DBUtils.fetchWayBillsByWayBillId(wayBillId);
			request.setAttribute("waybill", wayBill);
			request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
			// need to send it back to right JSP file. need a parameter from client
		}
		else {
			List<WayBill> wayBills = DBUtils.fetchAllWayBills();
			request.setAttribute("waybills", wayBills);
			request.getRequestDispatcher("adminwaybill.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/waybillcreate")) {

			WayBill wayBill = new WayBill();
			wayBill.setAmount(Float.parseFloat(request.getParameter("amount")));
			wayBill.setComment(request.getParameter("comment"));
			wayBill.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			wayBill.setDeliveryDate(request.getParameter("date"));
			wayBill.setLogisticPartnerId(Integer.parseInt(request.getParameter("logisticPartnerId")));
			wayBill.setModeOfTransportation(request.getParameter("modeOfTransport"));
			wayBill.setProductDetails(request.getParameter("productDetails"));
			wayBill.setStatus(request.getParameter("status"));
			wayBill.setWeight(Integer.parseInt(request.getParameter("weight")));

			boolean executionStatus = DBUtils.createWayBill(wayBill);
			String message = "Successfully created the Way Bill";
			if (!executionStatus) {
				message = "Failed to create the Way Bill. Please try again";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("customerhomepage.jsp").forward(request, response);
		} else if (request.getRequestURI().equalsIgnoreCase("/ShipWell/waybillupdate")) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			HttpSession session = request.getSession();
			int wayBillId = Integer.parseInt(request.getParameter("wayBillId"));
			WayBill wayBill = new WayBill();
			wayBill.setDeliveryDate(request.getParameter("wayBillId"));
			wayBill.setStatus(request.getParameter("wayBillId"));
			wayBill.setComment(request.getParameter("wayBillId"));
			wayBill.setWayBillId(wayBillId);
			boolean executionStatus = DBUtils.updateWayBill(wayBill);
			String message = "Successfully updated the Way Bill";
			if (!executionStatus) {
				message = "Failed to update the Way Bill. Please try again";
			}
			request.setAttribute("message", message);
			
			if (session.getAttribute("employeeId") != null) {

				request.getRequestDispatcher("employeewaybill.jsp").forward(request, response);
			} else if(session.getAttribute("logisticPartnerId") != null ) {
				request.getRequestDispatcher("logisticpartnerwaybill.jsp").forward(request, response);
			}

		}

	}

	// private byte[] getPhoto(HttpServletRequest request) throws Exception {
	// Part filePartProfile = request.getPart("picture");
	// int docLength1 = (int)filePartProfile.getSize();
	// InputStream inputProfile = filePartProfile.getInputStream();
	// ByteArrayOutputStream profileOutput = new ByteArrayOutputStream();
	// byte[] bufferProfile = new byte[docLength1 * 1024];
	// System.out.println("profile length:---------"+docLength1);
	// for (int length = 0; (length = inputProfile.read(bufferProfile)) > 0;)
	// profileOutput.write(bufferProfile, 0, length);
	// // ************ Set as output.toByteArray()***************
	// return profileOutput.toByteArray();
	// }

}
