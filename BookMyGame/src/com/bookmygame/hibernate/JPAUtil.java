package com.bookmygame.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookmygame");

	public static EntityManagerFactory getEMF() {
		return emf;
	}
}




