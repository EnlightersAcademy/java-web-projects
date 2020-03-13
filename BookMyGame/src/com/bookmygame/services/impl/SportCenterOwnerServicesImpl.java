package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.SportCenterOwnerServices;

public class SportCenterOwnerServicesImpl implements SportCenterOwnerServices {

	public void registerSportCenter(SportCenter center) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.persist(center);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public SportCenter loginSportCenter(String userName, String password) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		SportCenter sc = new SportCenter();
		try {
			TypedQuery<SportCenter> query = em.createNamedQuery(
					"select sc from SportCenter sc where sc.sportCenterEmailId =: emailId and sc.password =: password", SportCenter.class);
			query.setParameter("emailId", userName);
			query.setParameter("password", password);
			sc = query.getSingleResult();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sc;
	}
	
	public void updateSportCenterDetails(SportCenter center) throws Exception {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.persist(center);
			em.getTransaction().commit();

		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
			throw exe;
		} finally {
			em.close();
		}
	}
	
	public List<GameBooking> getAllBookings(int sportCenterId) {
		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createNamedQuery(
					"select gb from GameBooking gb where gb.sportCenter.sportCenterId =: sportCenterId", GameBooking.class);
			query.setParameter("sportCenterId", sportCenterId);
			gameBookings = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return gameBookings;
	}
	
}
