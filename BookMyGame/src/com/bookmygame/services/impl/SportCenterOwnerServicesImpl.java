package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.Customer;
import com.bookmygame.pojo.GameBooking;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.pojo.enums.AnnouncementType;
import com.bookmygame.services.SportCenterOwnerServices;

public class SportCenterOwnerServicesImpl implements SportCenterOwnerServices {

	public void registerSportCenter(SportCenter center) throws Exception {
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
	
	public SportCenter loginSportCenter(String userName, String password) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		SportCenter sc = null;
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
	
	public List<GameBooking> getAllBookings(int sportCenterId, String gameName, String date) {
		List<GameBooking> gameBookings = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<GameBooking> query = em.createNamedQuery(
					"select gb from GameBooking gb where gb.sportCenter.sportCenterId =: sportCenterId and gb.dateOfBooking =: date and gb.sportName =: gameName", GameBooking.class);
			query.setParameter("sportCenterId", sportCenterId);
			query.setParameter("date", date);
			query.setParameter("gameName", gameName);
			gameBookings = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return gameBookings;
	}
	
	public SportCenter getSportCenterById(int sportCenterId) {
		
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		SportCenter sc = new SportCenter();
		try {
			TypedQuery<SportCenter> query = em.createNamedQuery(
					"select sc from SportCenter sc where sc.sportCenterId =: sportCenterId", SportCenter.class);
			query.setParameter("sportCenterId", sportCenterId);
			sc = query.getSingleResult();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sc;
	}
	
	public Map<String, Object> getProvisionToActiveCountMap(int sportCenterId) {
		Map<String, Object> provToCountMap = new HashMap<>();
		
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			TypedQuery<SportCenter> query = em.createNamedQuery(
					"select sc from SportCenter sc where sc.sportCenterId =: sportCenterId",
					SportCenter.class);
			query.setParameter("sportCenterId", sportCenterId);
			SportCenter center = query.getSingleResult();
			provToCountMap.put("gamesCount", center.getSports().size());


			TypedQuery<Integer> bookQuery = em.createNamedQuery("select count(booking) from GameBooking booking where booking.sportCenter =: sportCenterId", Integer.class);
			bookQuery.setParameter("sportCenterId", sportCenterId);
			provToCountMap.put("booking", bookQuery.getSingleResult());
			
			TypedQuery<Announcement> annoQuery = em.createNamedQuery(
					"select anno from Announcement anno where anno.announcementType =: announcementType",
					Announcement.class);
			annoQuery.setParameter("announcementType", AnnouncementType.OWNER);
			List<Announcement> announcements = annoQuery.getResultList();
			provToCountMap.put("announcements", announcements);
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return provToCountMap;
	}
	
}
