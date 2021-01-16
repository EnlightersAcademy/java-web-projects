package com.espresso.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.espresso.common.DbUtil;
import com.espresso.dto.CafeOrder;
import com.espresso.dto.Item;
import com.espresso.dto.OrderItem;
import com.espresso.dto.Staff;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/itemorder")
public class ItemOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Staff staff = (Staff) request.getSession().getAttribute("staff");

		String emailId = request.getParameter("customerEmail");
		CafeOrder order = DbUtil.getOngoingOrdersByStaffIdAndCustomerEmail(staff.getStaffId(), emailId);
		request.setAttribute("CartCount", order.getItems().stream().mapToInt(item-> item.getQuantity()).sum());
		request.getRequestDispatcher("staffneworder3.jsp?orderid=" + order.getId()+"&email="+emailId).forward(request, response);
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
		String completed = request.getParameter("status");
		if (completed != null && "complete".equals(completed)) {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			CafeOrder order = DbUtil.getCafeOrderById(orderId);
			order.setStatus(1);
			try {
				DbUtil.udateCafeOrderSimple(order);
				HashMap<String, Integer> cusEmailToOrder = (HashMap<String, Integer>) request.getSession().getAttribute("cusEmailToOrder");

				cusEmailToOrder.put(order.getCustomerEmailId(), null);
				request.getSession().setAttribute("cusEmailToOrder", cusEmailToOrder);
				request.getRequestDispatcher("staffallorders.jsp?msg=success").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("stafforderpayment.jsp?msg=fail").forward(request, response);
			}
			return;
		}
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Object cusEmailToOrder = request.getSession().getAttribute("cusEmailToOrder");
		String customerEmail = request.getParameter("email");
		Staff staff = (Staff) request.getSession().getAttribute("staff");
		Map<String, Integer> cusToOrderMap = null;
		int orderId = -1;
		if (cusEmailToOrder != null) {
			cusToOrderMap = (Map<String, Integer>) cusEmailToOrder;
			if (cusToOrderMap.get(customerEmail) != null)
				orderId = cusToOrderMap.get(customerEmail);
		} else {

			cusToOrderMap = new HashMap<String, Integer>();

		}
		if (orderId < 0) {
			CafeOrder ongoingOrder = DbUtil.getOngoingOrdersByCustomerEmail(customerEmail);
			if (ongoingOrder != null) {
				orderId = ongoingOrder.getId();
				cusToOrderMap.put(customerEmail, ongoingOrder.getId());
			}
		}

		CafeOrder cafeOrder = null;
		if (orderId >= 0) {
			cafeOrder = DbUtil.getCafeOrderById(orderId);
		} else {
			cafeOrder = new CafeOrder();
			cafeOrder.setCustomerEmailId(customerEmail);
			cafeOrder.setStaffId(staff.getStaffId());
		}

		cafeOrder.setStatus(2);

		DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
		Date dateobj = new Date();
		String loggedInDateTime = df.format(dateobj);

		cafeOrder.setDateOfOrder(loggedInDateTime);
		try {
			

			DbUtil<CafeOrder> utilObj = new DbUtil<CafeOrder>();
			if (orderId > 0) {
				utilObj.updateCafeOrder(cafeOrder);
			} else {
				utilObj.createEntry(cafeOrder);
			}
			updateCafeOrderItems(cafeOrder, itemId, quantity);
			
			CafeOrder updatedOrder = DbUtil.getOngoingOrdersByStaffIdAndCustomerEmail(staff.getStaffId(),
					customerEmail);
			cusToOrderMap.put(customerEmail, updatedOrder.getId());
			request.getSession().setAttribute("cusEmailToOrder", cusToOrderMap);
			request.setAttribute("CartCount", cafeOrder.getItems().stream().mapToInt(item-> item.getQuantity()).sum());
			request.getRequestDispatcher("staffneworder3.jsp?orderid="+cafeOrder.getId()).forward(request, response);
		} catch (Exception exe) {
			exe.printStackTrace();
			request.getRequestDispatcher("staffneworder3.jsp").forward(request, response);
		}
	}

	private void updateCafeOrderItems(CafeOrder cafeOrder, int itemId, int quantity) throws Exception {
		List<OrderItem> items = cafeOrder.getItems();

		Item item = DbUtil.getItemById(itemId);

		int totalAmount = cafeOrder.getTotalAmount();
		boolean isExisting = false;
		DbUtil<OrderItem> util = new DbUtil<>();
		for (OrderItem existingOrderItem : items) {
			if (existingOrderItem.getItemId() == itemId) {
				// if there is a decrease in quantity by user. then handle it
				if (existingOrderItem.getQuantity() > quantity) {
					totalAmount = totalAmount - (existingOrderItem.getQuantity() - quantity) * item.getPrice();
				} else {
					int diffQuantity = Math.abs(existingOrderItem.getQuantity() - quantity);
					totalAmount = totalAmount + diffQuantity * item.getPrice();
				}
				existingOrderItem.setQuantity(quantity);
				isExisting = true;
				break;
			}
		}
			if(!isExisting) {
				OrderItem newOrderItem = new OrderItem();
				newOrderItem.setItemId(itemId);
				newOrderItem.setQuantity(quantity);

				items.add(newOrderItem);
				util.createEntry(newOrderItem);
				newOrderItem.setCafeOrder(cafeOrder);

				totalAmount = totalAmount + item.getPrice() * quantity;
			}
			cafeOrder.setTotalAmount(totalAmount);
		

		cafeOrder.setItems(items);
		util.udateCafeOrderSimple(cafeOrder);
		
	}

}
