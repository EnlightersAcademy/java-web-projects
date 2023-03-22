package com.shipwell.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shipwell.dto.Location;
import com.shipwell.utils.DBUtils;



/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet(urlPatterns = {"/createlocation","/locations", "/viewlpsbylocation", "/viewlocationsbylp", "/viewlpbetweenlocation"})
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocationServlet() {
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

		if (request.getRequestURI().equalsIgnoreCase("/ShipWell/adminlocations")) {
			List<Location> locationList = DBUtils.fetchAllLocations();
			request.setAttribute("locationlist", locationList);
			request.getRequestDispatcher("adminlocation.jsp").forward(request, response);
		} else if(request.getRequestURI().equalsIgnoreCase("/ShipWell/customerlocations")) {
			List<Location> locationList = DBUtils.fetchAllLocations();
			request.setAttribute("locationlist", locationList);
			request.getRequestDispatcher("customerlocation.jsp").forward(request, response);
		} else if(request.getRequestURI().equalsIgnoreCase("/ShipWell/logisticpartnerlocations")) {
			List<Location> locationList = DBUtils.fetchAllLocations();
			request.setAttribute("locationlist", locationList);
			request.getRequestDispatcher("logisticpartnerlocation.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}
	
//	private byte[] getPhoto(HttpServletRequest request) throws Exception {
//		Part filePartProfile = request.getPart("picture");
//		int docLength1 = (int)filePartProfile.getSize();
//		InputStream inputProfile = filePartProfile.getInputStream();
//		ByteArrayOutputStream profileOutput = new ByteArrayOutputStream();
//		byte[] bufferProfile = new byte[docLength1 * 1024];
//		System.out.println("profile length:---------"+docLength1);
//		for (int length = 0; (length = inputProfile.read(bufferProfile)) > 0;) 
//			profileOutput.write(bufferProfile, 0, length);
//		// ************ Set as output.toByteArray()***************
//		return profileOutput.toByteArray();
//	}

}


