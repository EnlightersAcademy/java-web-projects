package com.matchmaker.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.matchmaker.hibernate.JPAUtil;
import com.matchmaker.pojo.Customer;
import com.matchmaker.services.AdminServices;

public class AdminServicesImpl implements AdminServices {

	public List<Customer> getAllCustomerDetails() {

		List<Customer> customers = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {

			TypedQuery<Customer> query = em.createQuery("select cus from Customer cus", Customer.class);
			customers = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return customers;
	}

	public void blockCustomer(int customerId) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		try {
			Query query = em.createQuery("update Customer set cus.isActive = 0 where cus.id = :customerId");
			query.setParameter("customerId", customerId);
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
			throw exe;
		} finally {
			em.close();
		}
	}

	public void addNewSportCategories(String sportName) {

	}

	@Override
	public void addNewLocation(String location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blockSportCenter(int sportCenterId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Integer> getProvisionToActiveCountMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
