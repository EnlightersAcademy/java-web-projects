package com.espresso.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.Category;
import com.espresso.dto.Staff;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!EspressoUtil.isValidSession(request)) {
			response.sendRedirect("index.jsp?exp=true");
		}
		List<Category> cats = DbUtil.getAllCategories();
		request.setAttribute("categories", cats);
		request.getRequestDispatcher("admincategory.jsp").forward(request, response);
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
		DbUtil<Category> util = new DbUtil<>();
		String name = request.getParameter("name");
		if (DbUtil.getCategoryByName(name) != null) {
			request.getRequestDispatcher("admincategory.jsp?msg=dup").forward(request, response);
		}
		Category cat = new Category();
		cat.setCategoryName(name);
		
		try {
			util.createEntry(cat);
			request.getRequestDispatcher("admincategory.jsp?msg=success").forward(request, response);
		} catch (Exception exe) {
			request.getRequestDispatcher("admincategory.jsp?msg=fail").forward(request, response);
		}

	}

}
