package com.bookmygame.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmygame.services.CommonServices;
import com.bookmygame.services.impl.CommonServicesImpl;

@WebServlet({"/admin/game", "/admin/customer", "/admin/center", "/admin/booking"})
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommonServices commonServices = new CommonServicesImpl();
		if ("/BookMyGame/admin/game".equals(request.getRequestURI())) {
			commonServices.get
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
}
