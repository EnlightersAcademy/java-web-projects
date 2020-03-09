package com.bookmygame.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.services.CustomerServices;

public class CustomerServicesImpl implements CustomerServices {

	Logger logger = Logger.getLogger(CustomerServicesImpl.class);

	public void registerCustomer(Customer customer) {

		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Customer loginCustomer(String emailId, String password) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Customer customer = null;
		try {

			Query query = em.createQuery("from Customer c where c.emailId=:email and c.password=:password");
			query.setParameter("email", emailId);
			query.setParameter("password", password);
			customer = (Customer) query.getSingleResult();
			
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
		} finally {
			em.close();
		}
		
		return customer;
	}

	public void updateCustomerDetails(Customer customer) throws Exception {

	}

	public List<GameBooking> getAllBookings(int customerId) {
		return null;
	}

	public void bookMyGame(GameBooking booking) throws Exception {

	}

	public void cancelBooking(GameBooking booking) throws Exception {

	}
}
