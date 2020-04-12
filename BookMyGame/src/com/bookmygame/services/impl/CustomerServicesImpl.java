package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.Location;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.CustomerServices;

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

	public List<GameBooking> getAllBookings(int customerId) {
		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createQuery(
					"select gb from GameBooking gb where gb.customer.id = :customerId", GameBooking.class);
			query.setParameter("customerId", customerId);
			gameBookings = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return gameBookings;
	}

	public void bookMyGame(GameBooking booking) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(booking);
			em.getTransaction().commit();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			em.getTransaction().rollback();
			throw exe;
		} finally {
			em.close();
		}
	}

	public void cancelBooking(int bookingId) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		GameBooking booking = null;
		try {

			booking = em.find(GameBooking.class, bookingId);
			em.remove(booking);
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

	public List<SportCenter> getSportCentersByLocation(String locationName) {

		List<SportCenter> centers = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			Query query = em.createQuery("from SportCenter sp where sp.location.locationName =:locationId and sp.isActive = 1 and sp.isApproved= 1",
					SportCenter.class);
			query.setParameter("locationId", locationName);
			centers = query.getResultList();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			throw exe;
		} finally {
			em.close();
		}

		return centers;
	}

	public Location getLocationById(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Location location = null;
		try {
			TypedQuery<Location> query = em.createQuery("from Location loc where loc.locationId =:locationId",
					Location.class);
			query.setParameter("locationId", id);
			location = query.getSingleResult();
		} catch (Exception exe) {
			logger.error("Error saving customer object", exe);
			throw exe;
		} finally {
			em.close();
		}
		return location;
	}
}
