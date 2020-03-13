package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.Location;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.AdminServices;

public class AdminServicesImpl implements AdminServices {

	public Customer loginCustomer(String userName, String password) {
		Customer customer = null;
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<Customer> query = em.createNamedQuery(
					"select * from Customer as cus where cus.name=: name and cus.password =: password and cus.isActive = 1",
					Customer.class);
			query.setParameter("name", userName);
			query.setParameter("password", password);
			customer = query.getSingleResult();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return customer;
	}

	public List<Customer> getAllCustomerDetails() {

		List<Customer> customers = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {

			TypedQuery<Customer> query = em.createNamedQuery("select cus from Customer cus where cus.isActive = 1",
					Customer.class);
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
			Query query = em.createQuery("update Customer set cus.isActive = 0 where cus.id =: customerId");
			query.setParameter("customerId", customerId);
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public List<GameBooking> getAllBookingsOnCustomer(int customerId) {

		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createNamedQuery(
					"select gb from GameBooking gb where gb.customer.id =: customerId", GameBooking.class);
			query.setParameter("customerId", customerId);
			gameBookings = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return gameBookings;
	}

	public List<GameBooking> getAllBookingsOnSportCenter(int sportCenter) {

		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createNamedQuery(
					"select gb from GameBooking gb where gb.sportCenter.sportCenterId =: sportCenter",
					GameBooking.class);
			query.setParameter("sportCenter", sportCenter);
			gameBookings = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return gameBookings;
	}

	public void addNewSportCategories(String sportName) {

	}

	public void addNewLocation(String location) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		try {
			Location loc = new Location();
			loc.setLocationName(location);
			em.persist(loc);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public SportCenter approveOrRejectCenterApplication(int sportCenterId, boolean rejectedOnly) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		SportCenter spCenter = em.find(SportCenter.class, sportCenterId);
		try {
			if (!rejectedOnly) {
				spCenter.setIsApproved(1);
			} else {
				spCenter.setIsApproved(0);

			}
			em.persist(spCenter);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return spCenter;
	}

	public List<SportCenter> getAllActiveSportCenters() {
		List<SportCenter> sportCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createNamedQuery(
					"select sc from SportCenter sc where sc.isApproved =: approved and sc.isActive =: active",
					SportCenter.class);
			query.setParameter("approved", 1);
			query.setParameter("active", 1);
			sportCenters = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sportCenters;
	}

	public List<SportCenter> getAllSportCentersToApprove() {
		List<SportCenter> sportCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createNamedQuery(
					"select sc from SportCenter sc where sc.isApproved =: approved", SportCenter.class);
			query.setParameter("approved", 0);
			sportCenters = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sportCenters;
	}

	public void blockSportCenter(int sportCenterId) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		SportCenter spCenter = em.find(SportCenter.class, sportCenterId);
		try {
			spCenter.setIsActive(0);
			em.persist(spCenter);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
