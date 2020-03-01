package com.bookmygame.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookmygame.hibernate.HibernateUtil;
import com.bookmygame.pojo.Customer;

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

		if ("/BookMyGame/customer/register".equals(request.getRequestURI())) {
			SessionFactory factory =HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Customer customer = new Customer();
			customer.setName("Raj");
			session.save(customer);
			tx.commit();
			
			
		} else if ("/BookMyGame/customer/login".equals(request.getRequestURI())) {
			String username = request.getParameter("name");
			String password = request.getParameter("pass");
		}

	}

}
