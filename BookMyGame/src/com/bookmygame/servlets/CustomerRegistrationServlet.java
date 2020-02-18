package com.bookmygame.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/customer/register", "/customer/login" })
public class CustomerRegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("/customer/register".equals(request.getRequestURI())) {

			
		} else if ("/customer/login".equals(request.getRequestURI())) {
			String username = request.getParameter("name");
			String password = request.getParameter("pass");
		}

	}

}
