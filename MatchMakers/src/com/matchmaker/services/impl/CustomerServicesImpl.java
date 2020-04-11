package com.matchmaker.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.matchmaker.hibernate.JPAUtil;
import com.matchmaker.pojo.Customer;
import com.matchmaker.services.CustomerServices;

public class CustomerServicesImpl implements CustomerServices {

	Logger logger = Logger.getLogger(CustomerServicesImpl.class);

	public void registerCustomer(Customer customer) throws Exception {

		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			em.getTransaction().rollback();
			throw exe;
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

		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			em.getTransaction().rollback();
			throw exe;
		} finally {
			em.close();
		}

	}


	public Customer getCustomerById(int customerId) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Customer customer = null;
		try {

			customer = em.find(Customer.class, customerId);

		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
		} finally {
			em.close();
		}

		return customer;

	}

	@Override
	public void cancelBooking(int bookingId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
