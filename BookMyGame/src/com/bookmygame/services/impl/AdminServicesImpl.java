package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<GameBooking> getAllBookingsOnCustomer(int customerId) {

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

	public List<GameBooking> getAllBookingsOnSportCenter(int sportCenter) {

		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createQuery(
					"select gb from GameBooking gb where gb.sportCenter.sportCenterId = :sportCenter",
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

	public SportCenter approveOrRejectCenterApplication(int sportCenterId, boolean rejectedOnly) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		SportCenter spCenter = em.find(SportCenter.class, sportCenterId);
		try {
			if (!rejectedOnly) {
				spCenter.setIsActive(1);
				spCenter.setIsApproved(1);
			} else {
				spCenter.setIsActive(0);
				spCenter.setIsApproved(2);

			}
			em.persist(spCenter);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
			throw exe;
		} finally {
			em.close();
		}
		return spCenter;
	}

	public List<SportCenter> getAllActiveSportCenters() {
		List<SportCenter> sportCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createQuery(
					"select sc from SportCenter sc where sc.isApproved = :approved and sc.isActive = :active",
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

	public List<SportCenter> getAllSportCenters() {
		List<SportCenter> sportCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createQuery("select sc from SportCenter sc", SportCenter.class);
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
			TypedQuery<SportCenter> query = em.createQuery(
					"select sc from SportCenter sc where sc.isApproved =:approved", SportCenter.class);
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
			throw exe;

		} finally {
			em.close();
		}
	}

	public Map<String, Integer> getProvisionToActiveCountMap() {
		Map<String, Integer> provToCountMap = new HashMap<>();

		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createQuery(
					"select sc from SportCenter sc where sc.isApproved = :approved and sc.isActive = :active",
					SportCenter.class);
			query.setParameter("approved", 1);
			query.setParameter("active", 1);
			List<SportCenter> centers = query.getResultList();
			provToCountMap.put("sportCenter", centers.size());

			TypedQuery<Customer> customerQuery = em
					.createQuery("select cus from Customer cus where cus.isActive = :active", Customer.class);
			customerQuery.setParameter("active", 1);
			List<Customer> customers = customerQuery.getResultList();
			provToCountMap.put("customer", customers.size());

			TypedQuery<GameBooking> bookingQuery = em.createQuery("select booking from GameBooking booking",
					GameBooking.class);
			List<GameBooking> bookings = bookingQuery.getResultList();
			provToCountMap.put("booking", bookings.size());

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return provToCountMap;
	}

	public List<SportCenter> getAllRejectedSportCenters() {
		List<SportCenter> sportCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createQuery(
					"select sc from SportCenter sc where sc.isApproved = :approved", SportCenter.class);
			query.setParameter("approved", 2);
			sportCenters = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sportCenters;
	}

}
