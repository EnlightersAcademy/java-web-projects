package com.espresso.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.espresso.db.util.DbUtil;
import com.espresso.dto.Item;
import com.espresso.util.EspressoUtil;

/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/items")
@MultipartConfig
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemsServlet() {
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
		int itemId = Integer.parseInt(request.getParameter("id"));
		if(status != null) {
			boolean returnStatus = true;
			if("true".equals(status)) {

				DbUtil<Item> util = new DbUtil<>();
				 returnStatus = util.updateItemStatus(itemId, false);
			} else if("false".equals(status)) {
				DbUtil<Item> util = new DbUtil<>();
				 returnStatus = util.updateItemStatus(itemId, true);
			}
			if(returnStatus) {
				request.getRequestDispatcher("adminviewitem.jsp?msg=success").forward(request, response);
			} else {
				request.getRequestDispatcher("adminviewitem.jsp?msg=fail").forward(request, response);
			}
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
		}
		String name = request.getParameter("name");
		DbUtil<Item> util = new DbUtil<>();
		if (DbUtil.getItemByName(name) != null) {
			request.getRequestDispatcher("adminadditem.jsp?msg=dup").forward(request, response);
			return;
		}
		Item item = new Item();
		item.setItemName(name);
		item.setDescription(request.getParameter("description"));
		item.setPrice(Integer.parseInt(request.getParameter("price")));
		item.setCategory(DbUtil.getCategoryByName(request.getParameter("category")));
		item.setAvailable(true);

		try {
			item.setPhoto(getPhoto(request));
			util.createEntry(item);
			request.getRequestDispatcher("adminadditem.jsp?msg=success").forward(request, response);
		} catch (Exception exe) {
			exe.printStackTrace();
			request.getRequestDispatcher("adminadditem.jsp?msg=fail").forward(request, response);
		}

	}
	
	private byte[] getPhoto(HttpServletRequest request) throws Exception {
		Part filePartProfile = request.getPart("picture");
		int docLength1 = (int)filePartProfile.getSize();
		InputStream inputProfile = filePartProfile.getInputStream();
		ByteArrayOutputStream profileOutput = new ByteArrayOutputStream();
		byte[] bufferProfile = new byte[docLength1 * 1024];
		System.out.println("profile length:---------"+docLength1);
		for (int length = 0; (length = inputProfile.read(bufferProfile)) > 0;) 
			profileOutput.write(bufferProfile, 0, length);
		// ************ Set as output.toByteArray()***************
		return profileOutput.toByteArray();
	}

}
