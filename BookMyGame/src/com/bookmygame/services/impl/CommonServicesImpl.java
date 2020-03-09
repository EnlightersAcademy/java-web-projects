package com.bookmygame.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookmygame.hibernate.JPAUtil;
import com.bookmygame.pojo.Announcement;
import com.bookmygame.pojo.Location;
import com.bookmygame.pojo.Sport;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.CommonServices;

public class CommonServicesImpl implements CommonServices {

	public List<Announcement> getAllAnnoucements() {

		List<Announcement> announcements = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {

			Query query = em.createQuery("select an from Announcement an");
			announcements = (List<Announcement>) query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return announcements;
	}

	public List<Location> getAllLocations() {

		List<Location> locations = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {

			Query query = em.createQuery("select loc from Location loc", Location.class);
			locations = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return locations;
	}

	public List<SportCenter> getAllSportCentersByLocation(String locationName) {

		List<SportCenter> spCenters = new ArrayList<>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			Query query = em.createQuery("select loc.locationId from Location as loc where loc.locationName =:locationName");
			query.setParameter("locationName", locationName);
			int locationId = (Integer) query.getSingleResult();
			
			query = em.createQuery("select spc from SportCenter as spc where spc.location =:locationId",SportCenter.class);
			query.setParameter("locationId", locationId);
			spCenters = query.getResultList();

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return spCenters;
	}

	public Set<Sport> getAllSportsInSportCenter(int sportCenterId) {

		Set<Sport> sports = new HashSet<Sport>();
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {

			Query query = em.createQuery("select spc from SportCenter as spc where spc.sportCenterId =:id", SportCenter.class);
			query.setParameter("id", sportCenterId);
			SportCenter sp = (SportCenter)query.getSingleResult();
			sports = sp.getSports();
			
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			em.close();
		}
		return sports;
		
	}

	public void raiseAnnouncement(Announcement announcement) {

		EntityManager em = JPAUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(announcement);
			em.getTransaction().commit();
			
		} catch (Exception exe) {
			exe.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
