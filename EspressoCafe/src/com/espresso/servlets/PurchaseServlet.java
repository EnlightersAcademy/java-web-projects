package com.espresso.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.PurchaseItem;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/purchases")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseServlet() {
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
		PurchaseItem purchase = new PurchaseItem();

		purchase.setName(request.getParameter("name"));
		purchase.setDescription(request.getParameter("description"));
		purchase.setTotalCost(Integer.parseInt(request.getParameter("price")));
		purchase.setQuantity(request.getParameter("quantity"));
		purchase.setDate(request.getParameter("purchasedate"));
		try {
			DbUtil<PurchaseItem> util = new DbUtil<>();
			util.createEntry(purchase);
			request.getRequestDispatcher("adminaddpurchase.jsp?msg=success").forward(request, response);
		} catch (Exception exe) {
			exe.printStackTrace();
			request.getRequestDispatcher("adminaddpurchase.jsp?msg=fail").forward(request, response);
		}

	}

}
