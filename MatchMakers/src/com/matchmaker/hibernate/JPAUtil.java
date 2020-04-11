package com.matchmaker.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("matchmaker");

	public static EntityManagerFactory getEMF() {
		return emf;
	}
}




